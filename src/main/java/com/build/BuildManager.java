package com.core;

import com.build.*;
import com.ui.OutputPane;

public class BuildManager {

    private final OutputPane output;

    public BuildManager(OutputPane output) {
        this.output = output;
    }

    public void build(Project project) {
        output.log("=== Build Started ===");

        new Thread(() -> {
            try {
                switch (project.buildConfig().tool()) {
                    case "dotnet" -> new DotNetBuilder(output).build(project);
                    case "node"   -> new NodeBuilder(output).build(project);
                    case "python" -> new PythonBuilder(output).build(project);
                    default -> output.log("Unknown build tool");
                }
            } catch (Exception e) {
                output.log("Build failed: " + e.getMessage());
            }
        }).start();
    }

    public void run(Project project) {
        output.log("=== Run Started ===");

        new Thread(() -> {
            try {
                switch (project.buildConfig().tool()) {
                    case "dotnet" -> new DotNetBuilder(output).run(project);
                    case "node"   -> new NodeBuilder(output).run(project);
                    case "python" -> new PythonBuilder(output).run(project);
                    default -> output.log("Unknown run tool");
                }
            } catch (Exception e) {
                output.log("Run failed: " + e.getMessage());
            }
        }).start();
    }
}
