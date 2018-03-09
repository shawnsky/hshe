package com.xt.hshe.judge;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        int result = 0;
        Process run = Runtime.getRuntime().exec("java -classpath c:\\prog\\ Main");
        String input = "1 2 3 4 5";
        String output = "5\n15";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(run.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(run.getInputStream()));
        writer.write(input);
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[64];
        while (reader.read(buf) != -1){
            sb.append(buf);
            System.out.println(buf);
        }
        if (!output.equals(sb.toString())){
            result = 1;
        }
        System.out.println(sb.toString());
        System.out.println(run.waitFor());
        System.out.println(result==0?"AC":"WA");
    }
}
