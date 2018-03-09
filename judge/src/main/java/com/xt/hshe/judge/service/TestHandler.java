package com.xt.hshe.judge.service;

import com.xt.hshe.judge.pojo.entity.Submission;
import com.xt.hshe.judge.pojo.entity.TestPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
@Component("testHandler")
public class TestHandler {
    @Value("${judge.sys.tests-path}")
    private String sysTestsPath;

    public void save(Submission s, List<TestPoint> testPoints) throws IOException {
        //e.g. /data/tests/1/input1.txt
        String[] strings = {sysTestsPath+s.getId()+ File.separator};
        Path testPath = Paths.get(strings[0]);
        //某道題文件夾存在，說明測試用例文件已經存在，跳到下一步
        if (Files.exists(testPath)) {
            return;
        }
        Files.createDirectory(testPath);
        for (TestPoint t: testPoints) {
            Path inPath = Paths.get(strings[0] + "input" + t.getIndex() + ".txt");
            Files.createFile(inPath);
            try(BufferedWriter writer = Files.newBufferedWriter(inPath, StandardCharsets.UTF_8, StandardOpenOption.WRITE)){
                writer.write(t.getInput());
                writer.flush();
            }
            Path outPath = Paths.get(strings[0] + "output" + t.getIndex() + ".txt");
            Files.createFile(outPath);
            try(BufferedWriter writer = Files.newBufferedWriter(outPath, StandardCharsets.UTF_8, StandardOpenOption.WRITE)){
                writer.write(t.getOutput());
                writer.flush();
            }
        }
    }
}
