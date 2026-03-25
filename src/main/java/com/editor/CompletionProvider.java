package com.editor;

import com.languages.LanguageDefinition;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

import java.util.List;

public class CompletionProvider {

    private final List<String> tokens;

    public CompletionProvider(LanguageDefinition lang) {
        this.tokens = lang.tokens().stream()
                .map(t -> t.token())
                .distinct()
                .sorted()
                .toList();
    }

    public void showPopup(EditorPane editor) {
        String prefix = editor.getSelectedText();
        ContextMenu menu = new ContextMenu();

        tokens.stream()
                .filter(t -> t.startsWith(prefix))
                .limit(20)
                .forEach(t -> {
                    MenuItem item = new MenuItem(t);
                    item.setOnAction(e -> editor.replaceSelection(t));
                    menu.getItems().add(item);
                });

        menu.show(editor, editor.getLayoutX(), editor.getLayoutY());
    }
}
