package com.build;

import com.core.Project;
import com.ui.OutputPane;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythonBuilder {

    private final OutputPane output;

    public PythonBuilder(OutputPane output) {
        this.output = output;
    }

    public void build(Project project) {
        output.log("Python has no build step.");
    }

    public void run(Project project) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python", project.root().resolve("main.py").toString());
        pb.directory(project.root().toFile());
        readOutput(pb.start());
    }

    private void readOutput(Process p) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                output.log(line);
            }
        }
    }
}
