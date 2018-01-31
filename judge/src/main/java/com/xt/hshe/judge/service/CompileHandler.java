package com.xt.hshe.judge.service;

import com.xt.hshe.judge.pojo.entity.Submission;
import com.xt.hshe.judge.repository.SubmissionRepository;
import com.xt.hshe.judge.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component("compileHandler")
public class CompileHandler {

    /**
     * Compiler
     * @param s Submission object
     * @return 0 if succeed
     */
    public int compile(Submission s) throws IOException, InterruptedException {
        String[] strings = createFile(s);
        int result = 1;
        switch (s.getLang()) {
            case Consts.Language.C:
                break;
            case Consts.Language.CPP:
                break;
            case Consts.Language.GO:
                break;
            case Consts.Language.JAVA:
                result = java(strings);
                break;
            case Consts.Language.PERL:
                break;
            case Consts.Language.PYTHON:
                break;
            case Consts.Language.RUBY:
                break;
            default:
                break;
        }
        return result;
    }

    private String[] createFile(Submission s) throws IOException {
        //e.g. /data/subs/{pid}/{sid}/Main.java
        String[] strings = {"/data/subs/" + s.getProblemId() + File.separator,  s.getId() + File.separator, "Main." + s.getLang()};
        Path problemPath = Paths.get(strings[0]);
        if (Files.notExists(problemPath)) {
            Files.createDirectory(problemPath);
        }
        Path submissionPath = Paths.get(strings[0]+strings[1]);
        Files.createDirectory(submissionPath);
        Path path = Paths.get(strings[0]+strings[1]+strings[2]);
        Files.createFile(path);
        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.WRITE)){
            writer.write(s.getSrc());
            writer.flush();
        }
        return strings;
    }

    private int java(String[] strings) throws IOException, InterruptedException {
        Process build = Runtime.getRuntime().exec("javac "+strings[0]+strings[1]+strings[2]);
        int result = build.waitFor();
        Process delete = Runtime.getRuntime().exec("rm -f "+strings[0]+strings[1]+"Main.class");
        return result;
    }
}
