package com.core;

import java.nio.file.Path;

public class AppConfig {

    private final Path homeDir;
    private final Path workspaceDir;
    private final Path settingsFile;
    private final Path recentFile;
    private final Path extensionsDir;

    public AppConfig(Path homeDir) {
        this.homeDir = homeDir;
        this.workspaceDir = homeDir.resolve("workspace");
        this.settingsFile = homeDir.resolve("settings.json");
        this.recentFile = homeDir.resolve("recent.json");
        this.extensionsDir = homeDir.resolve("extensions");
    }

    public Path home()       { return homeDir; }
    public Path workspace()  { return workspaceDir; }
    public Path settings()   { return settingsFile; }
    public Path recent()     { return recentFile; }
    public Path extensions() { return extensionsDir; }
}
