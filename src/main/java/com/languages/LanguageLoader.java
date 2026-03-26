package com.languages;

import com.utils.FileUtils;
import com.utils.JsonUtils;

import java.nio.file.Path;

public class LanguageLoader {

    public static LanguageDefinition load(Path jsonPath) throws Exception {
        String json = FileUtils.read(jsonPath);
        return JsonUtils.load(json, LanguageDefinition.class);
    }
}
