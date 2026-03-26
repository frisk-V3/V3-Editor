package com.languages;

import java.nio.file.Path;

public class LanguageDetector {

    public static LanguageDefinition detect(Path file) {
        String name = file.getFileName().toString();
        int dot = name.lastIndexOf('.');
        if (dot == -1) return null;

        String ext = name.substring(dot + 1);
        return LanguageRegistry.getByExtension(ext);
    }
}
