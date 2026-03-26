package com.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ProcessUtils {

    public static void run(String[] cmd, String workDir, Consumer<String> output) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        if (workDir != null) pb.directory(new java.io.File(workDir));

        Process p = pb.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                output.accept(line);
            }
        }
    }
}
