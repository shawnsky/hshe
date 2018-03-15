package com.xt.hshe.sim;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("ipconfig");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line = br.readLine();
            line = br.readLine();
            if (line==null || "".equals(line)) {
                System.out.println("无输出");
            } else {
                System.out.println("第2行:"+line);
            }
        }
    }
}
