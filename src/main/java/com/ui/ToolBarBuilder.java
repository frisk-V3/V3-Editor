package com.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class ToolBarBuilder {

    public static ToolBar create(MainWindow window) {

        Button buildBtn = new Button("Build");
        buildBtn.setOnAction(e -> window.buildProject());

        Button runBtn = new Button("Run");
        runBtn.setOnAction(e -> window.runProject());

        return new ToolBar(buildBtn, runBtn);
    }
}
