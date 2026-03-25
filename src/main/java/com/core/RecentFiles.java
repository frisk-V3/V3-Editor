package com.core;

import java.util.LinkedList;
import java.util.List;

public class RecentFiles {

    private final LinkedList<String> files = new LinkedList<>();

    public void add(String path) {
        files.remove(path);
        files.addFirst(path);
        if (files.size() > 20) files.removeLast();
    }

    public List<String> list() {
        return List.copyOf(files);
    }
}
