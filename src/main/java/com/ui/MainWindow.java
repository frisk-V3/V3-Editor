package com.ui;

import javafx.scene.Scene;
import javafx.scene.control.BorderPane;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainWindow {

    private final Stage stage;
    private final BorderPane root = new BorderPane();
    private final TabPane tabs = new TabPane();
    private final OutputPane output = new OutputPane();
    private final StatusBar status = new StatusBar();

    public MainWindow(Stage stage) {
        this.stage = stage;

        root.setTop(MenuBarBuilder.create(this));
        root.setCenter(tabs);
        root.setBottom(status);

        stage.setScene(new Scene(root, 1400, 900));
        stage.setTitle("frisk-IDE");
        stage.show();
    }

    public void openEditorTab(EditorTab tab) {
        tabs.getTabs().add(tab);
        tabs.getSelectionModel().select(tab);
        status.setMessage("Opened: " + tab.getText());
    }

    public OutputPane output() {
        return output;
    }

    public StatusBar status() {
        return status;
    }
}
