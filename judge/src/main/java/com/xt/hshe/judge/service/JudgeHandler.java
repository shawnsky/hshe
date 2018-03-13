package com.xt.hshe.judge.service;

import com.xt.hshe.judge.pojo.entity.Problem;
import com.xt.hshe.judge.pojo.entity.Submission;
import com.xt.hshe.judge.pojo.entity.TestPoint;
import com.xt.hshe.judge.util.Comparator;
import com.xt.hshe.judge.util.Consts;
import com.xt.hshe.judge.util.NativeLibraryLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.*;

@Component("judgeHandler")
public class JudgeHandler {

    @Value("${judge.sys.tests-path}")
    private String sysTestsPath;


    @Value("${judge.sys.subs-path}")
    private String sysSubsPath;


    @Value("${judge.sys.username}")
    private String systemUsername;


    @Value("${judge.sys.password}")
    private String systemPassword;


    private static final Logger LOGGER = LogManager.getLogger(JudgeHandler.class);

    /**
     * Load Native Library.
     */
    static {
        try {
            NativeLibraryLoader.loadLibrary("JudgerCore");
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.catching(ex);
        }
    }


    /**
     * 判题处理器
     * 遍历所有测试点运行情况,给出综合结果,最大运行耗时及最大运行内存.
     * 优先级 WA > TLE > MLE > RE > AC
     * @param submission - 提交记录对象
     * @param problem - 题目记录对象
     * @param testPoints - 测试用例列表
     */
    public Map<String, Integer> judge(Submission submission, Problem problem, List<TestPoint> testPoints) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        List<Map<String, Integer>> data = runProgram(submission, problem, testPoints);
        int totalPoints = data.size();
        int maxMemUsed = 0;
        int maxTimeUsed = 0;
        for (Map<String, Integer> m: data){
            maxMemUsed = Math.max(maxMemUsed, m.get("usedMemory"));
            maxTimeUsed = Math.max(maxTimeUsed, m.get("usedTime"));
            if (m.get("runtimeResult")==Consts.Judge.WA) {
                map.put("result", Consts.Judge.WA);
                break;
            }
            if (m.get("runtimeResult")==Consts.Judge.TLE) {
                map.put("result", Consts.Judge.TLE);
                break;
            }
            if (m.get("runtimeResult")==Consts.Judge.MLE) {
                map.put("result", Consts.Judge.MLE);
                break;
            }
            if (m.get("runtimeResult")==Consts.Judge.RE) {
                map.put("result", Consts.Judge.RE);
                break;
            }
            if (m.get("runtimeResult")==Consts.Judge.AC) {
                totalPoints--;
            }
        }
        if (!map.containsKey("result") && totalPoints==0) {
            map.put("result", Consts.Judge.AC);
        }
        if (!map.containsKey("result")) {
            map.put("result", Consts.Judge.SE);
        }
        map.put("usedMemory", maxMemUsed);
        map.put("usedTime", maxTimeUsed);
        return map;
    }

    /**
     * 执行程序.
     * @param submission - 提交记录对象
     * @param problem - 题目记录对象
     * @param testPoints - 测试用例列表
     */
    private List<Map<String, Integer>> runProgram(Submission submission, Problem problem, List<TestPoint> testPoints) throws IOException {
        List<Map<String, Integer>> runtimeResults = new ArrayList<>();
        long submissionId = submission.getId();
        long problemId = submission.getProblemId();
        for ( TestPoint testPoint : testPoints ) {
            String index = testPoint.getIndex();
            String inputFilePath = sysTestsPath + submissionId + File.separator + "input" + index + ".txt";
            String stdOutputFilePath = sysTestsPath + submissionId + File.separator + "output" + index + ".txt";
            String outputFilePath = sysSubsPath + problemId + File.separator + submissionId + File.separator + "output" + index + ".txt";
            //创建输出文件
//            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
////            FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
////            Files.createFile(Paths.get(outputFilePath), attr);
            Files.createFile(Paths.get(outputFilePath));
            String compiledFilePathNoExtension = sysSubsPath + problemId + File.separator + submissionId + File.separator + "Main";
            Map<String, Integer> runtimeResult = getRuntimeResult(
                    runnerGetRuntimeResult0(submission, problem, compiledFilePathNoExtension, inputFilePath, outputFilePath),
                    stdOutputFilePath, outputFilePath);
            runtimeResults.add(runtimeResult);
        }
        return runtimeResults;
    }

    /**
     * 获取程序运行结果(及答案比对结果).
     * @param result - 包含程序运行结果的Map对象
     * @param standardOutputFilePath - 标准输出文件路径
     * @param outputFilePath - 用户输出文件路径
     * @return 包含程序运行结果的Map对象
     */
    private Map<String, Integer> getRuntimeResult(Map<String, Integer> result,
                                                 String standardOutputFilePath, String outputFilePath) {
        int runtimeResultSlug = (Integer) result.get("runtimeResult");
        int usedTime = (Integer)result.get("usedTime");
        int usedMemory = (Integer)result.get("usedMemory");

        if ( runtimeResultSlug==Consts.Judge.AC &&
                !isOutputTheSame(standardOutputFilePath, outputFilePath) ) {
            runtimeResultSlug = Consts.Judge.WA;
            result.put("runtimeResult", runtimeResultSlug);
        }
        LOGGER.info(String.format("RuntimeResult: [%s, Time: %d ms, Memory: %d KB]",
                runtimeResultSlug, usedTime, usedMemory));

        return result;
    }

    /**
     * 获取(用户)程序运行结果.
     *
     * @param submission - 评测记录对象
     * @param problem - 题目记录对象
     * @param compiledFilePathNoExtension - 待执行的应用程序文件名(不包含文件后缀)
     * @param inputFilePath - 输入文件路径
     * @param outputFilePath - 输出文件路径
     * @return 一个包含程序运行结果的Map<String, Integer>对象
     */
    private Map<String, Integer> runnerGetRuntimeResult0(Submission submission, Problem problem, String compiledFilePathNoExtension, String inputFilePath, String outputFilePath) {
        String commandLine = getRunCommandLine(submission, compiledFilePathNoExtension);
        int timeLimit = Integer.parseInt(problem.getTimeLimit());//unit ms
        int memoryLimit = Integer.parseInt(problem.getMemoryLimit())*1000;//unit kb
        Map<String, Integer> result = new HashMap<>(4, 1);
        int runtimeResultSlug = -1;
        int usedTime = 0;
        int usedMemory = 0;
        try {
            LOGGER.info(String.format("[Submission #%d] Start running with command %s (TimeLimit=%d, MemoryLimit=%s)",
                    submission.getId(), commandLine, timeLimit, memoryLimit));
            Map<String, Object> runtimeResult = runnerGetRuntimeResult(commandLine,
                    systemUsername, systemPassword, inputFilePath, outputFilePath,
                    timeLimit, memoryLimit);

            int exitCode = (Integer) runtimeResult.get("exitCode");
            usedTime = (Integer) runtimeResult.get("usedTime");
            usedMemory = (Integer) runtimeResult.get("usedMemory");
            runtimeResultSlug = getRuntimeResultSlug(exitCode, timeLimit, usedTime, memoryLimit, usedMemory);
        } catch ( Exception ex ) {
            LOGGER.catching(ex);
        }

        result.put("runtimeResult", runtimeResultSlug);
        result.put("usedTime", usedTime);
        result.put("usedMemory", usedMemory);
        return result;
    }


    /**
     * 获取程序运行结果.
     * @param commandLine - 待执行程序的命令行
     * @param systemUsername - 登录操作系统的用户名
     * @param systemPassword - 登录操作系统的密码
     * @param inputFilePath - 输入文件路径(可为NULL)
     * @param outputFilePath - 输出文件路径(可为NULL)
     * @param timeLimit - 时间限制(单位ms, 0表示不限制)
     * @param memoryLimit - 内存限制(单位KB, 0表示不限制)
     * @return 一个包含程序运行结果的Map<String, Object>对象
     */
    public native Map<String, Object> runnerGetRuntimeResult(String commandLine,
                                                       String systemUsername, String systemPassword, String inputFilePath,
                                                       String outputFilePath, int timeLimit, int memoryLimit);


    /**
     * 根据JNI返回的结果封装评测结果.
     * @param exitCode - 程序退出状态位
     * @param timeLimit - 最大时间限制
     * @param timeUsed - 程序运行所用时间
     * @param memoryLimit - 最大空间限制
     * @param memoryUsed - 程序运行所用空间(最大值)
     * @return 程序运行结果的唯一英文缩写
     */
    private int getRuntimeResultSlug(int exitCode, int timeLimit, int timeUsed, int memoryLimit, int memoryUsed) {
        if ( exitCode == 0 ) {
            // Output will be compared in next stage
            return Consts.Judge.AC;
        }
        if ( timeUsed >= timeLimit ) {
            return Consts.Judge.TLE;
        }
        if ( memoryUsed >= memoryLimit ) {
            return Consts.Judge.MLE;
        }
        return Consts.Judge.RE;
    }

    /**
     * 获取待执行的命令行.
     * @param submission - 提交记录对象
     * @param compiledFilePathNoExtension - 待执行(编译后)的文件(不包含扩展名)
     * @return 待执行的命令行
     */
    private String getRunCommandLine(Submission submission, String compiledFilePathNoExtension) {
        String sampleCommand;
        switch (submission.getLang()) {
            case Consts.Language.C:
                sampleCommand = "{filename}.exe";
                break;
            case Consts.Language.CPP:
                sampleCommand = "{filename}.exe";
                break;
            case Consts.Language.GO:
                sampleCommand =  "go {filename}.go";
                break;
            case Consts.Language.JAVA:
                sampleCommand =  "java -classpath {pathname} Main";
                break;
            case Consts.Language.PERL:
                sampleCommand = "sorry, idk";
                break;
            case Consts.Language.PYTHON:
                sampleCommand =  "python {filename}.py";
                break;
            case Consts.Language.RUBY:
                sampleCommand =  "ruby {filename}.rb";
                break;
            default:
                sampleCommand = "java -cp {filename}";
                break;
        }
        if ("java".equals(submission.getLang())) {
            String classpath = compiledFilePathNoExtension.substring(0, compiledFilePathNoExtension.indexOf("Main"));
            return sampleCommand.replaceAll("\\{pathname\\}", classpath);
        }
        return sampleCommand.replaceAll("\\{filename\\}", compiledFilePathNoExtension);

    }

    /**
     * 获取用户输出和标准输出的比对结果.
     * @param standardOutputFilePath - 标准输出文件路径
     * @param outputFilePath - 用户输出文件路径
     * @return 用户输出和标准输出是否相同
     */
    private boolean isOutputTheSame(String standardOutputFilePath, String outputFilePath) {
        try {
            return Comparator.isOutputTheSame(standardOutputFilePath, outputFilePath);
        } catch (IOException ex) {
            LOGGER.catching(ex);
        }
        return false;
    }
}
