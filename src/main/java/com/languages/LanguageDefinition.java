package com.languages;

import java.util.List;

public class LanguageDefinition {
    public String name;                 // 言語名
    public List<String> extensions;     // ["cs", "js", "py"]
    public List<TokenRule> tokens;      // ハイライトルール
}
