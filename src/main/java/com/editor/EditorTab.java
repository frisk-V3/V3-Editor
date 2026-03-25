package com.editor;

import javafx.scene.control.Tab;

public class EditorTab extends Tab {

    private final EditorPane editor;

    public EditorTab(EditorPane editor, String title) {
        this.editor = editor;
        setText(title);
        setContent(editor);
    }

    public EditorPane editor() { return editor; }
}
