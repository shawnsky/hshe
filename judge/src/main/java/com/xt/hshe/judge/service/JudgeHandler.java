package com.xt.hshe.judge.service;

import com.xt.hshe.judge.pojo.entity.Submission;
import com.xt.hshe.judge.pojo.entity.TestPoint;
import com.xt.hshe.judge.util.Consts;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Component("judgeHandler")
public class JudgeHandler {
    public int judge(Submission s, List<TestPoint> testPoints) throws IOException {
        int result = 1;
        switch (s.getLang()) {
            case Consts.Language.C:
                break;
            case Consts.Language.CPP:
                break;
            case Consts.Language.GO:
                break;
            case Consts.Language.JAVA:
                result = java(s, testPoints);
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




    private int java(Submission s, List<TestPoint> testPoints) throws IOException {
        int result = 0;
        for (TestPoint tp: testPoints){
            Process run = Runtime.getRuntime().exec("java /data/subs/"+s.getProblemId()+"/"+s.getId()+"/Main");
            try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(run.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(run.getInputStream()))) {
                writer.write(tp.getInput());
                StringBuilder sb = new StringBuilder();
                char[] buf = new char[64];
                while (reader.read(buf) != -1){
                    sb.append(buf);
                }
                if (!tp.getOutput().equals(sb.toString())){
                    result = 1;
                    break;
                }

            }
        }
        return result;
    }
}
