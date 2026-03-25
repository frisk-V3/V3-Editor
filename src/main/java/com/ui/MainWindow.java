package com.ui;

import com.core.BuildManager;
import com.core.Project;
import com.core.ProjectManager;
import com.editor.EditorTab;
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

    private final ProjectManager projectManager = new ProjectManager();
    private final BuildManager buildManager = new BuildManager(output);

    public MainWindow(Stage stage) {
        this.stage = stage;

        root.setTop(MenuBarBuilder.create(this));
        root.setCenter(tabs);
        root.setBottom(output);   // OutputPane を下に配置
        root.setBottom(status);   // StatusBar をさらに下に

        stage.setScene(new Scene(root, 1400, 900));
        stage.setTitle("frisk-IDE");
        stage.show();
    }

    public BuildManager buildManager() {
        return buildManager;
    }

    public Project getActiveProject() {
        if (tabs.getTabs().isEmpty()) return null;
        EditorTab tab = (EditorTab) tabs.getSelectionModel().getSelectedItem();
        return tab.project();
    }

    public EditorTab getActiveEditorTab() {
        if (tabs.getTabs().isEmpty()) return null;
        return (EditorTab) tabs.getSelectionModel().getSelectedItem();
    }

    public OutputPane output() {
        return output;
    }
}
