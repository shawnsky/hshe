package com.xt.hshe.judge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("C:\\prog\\");
        System.out.println(0);
        Files.createDirectory(dir);
        System.out.println(1);
        Path path = Paths.get("C:\\prog\\Main.java");
        //Files.deleteIfExists(path);
       // Files.createFile(path);

    }
}
