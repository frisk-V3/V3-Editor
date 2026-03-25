package com.core;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {

    private final List<Project> openProjects = new ArrayList<>();

    public Project open(Path path) {
        Project p = new Project(path);
        openProjects.add(p);
        return p;
    }

    public void close(Project p) {
        openProjects.remove(p);
    }

    public List<Project> all() {
        return List.copyOf(openProjects);
    }
}
