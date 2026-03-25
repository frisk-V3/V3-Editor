package com.build;

import com.core.Project;
import com.ui.OutputPane;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DotNetBuilder {

    private final OutputPane output;

    public DotNetBuilder(OutputPane output) {
        this.output = output;
    }

    public void build(Project project) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("dotnet", "build");
        pb.directory(project.root().toFile());

        Process p = pb.start();
        readOutput(p);
    }

    public void run(Project project) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("dotnet", "run");
        pb.directory(project.root().toFile());

        Process p = pb.start();
        readOutput(p);
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
