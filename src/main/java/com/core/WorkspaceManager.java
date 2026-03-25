package com.core;

import java.nio.file.Path;

public class WorkspaceManager {

    private final AppConfig config;

    public WorkspaceManager(AppConfig config) {
        this.config = config;
    }

    public Path defaultWorkspace() {
        return config.workspace();
    }
}
