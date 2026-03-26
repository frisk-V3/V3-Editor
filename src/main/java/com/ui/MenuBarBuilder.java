package com.ui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarBuilder {

    public static MenuBar create(MainWindow window) {

        Menu file = new Menu("File");

        Menu view = new Menu("View");

        MenuItem dark = new MenuItem("Dark Theme");
        dark.setOnAction(e -> ThemeManager.setTheme("dark", window.getScene()));

        MenuItem light = new MenuItem("Light Theme");
        light.setOnAction(e -> ThemeManager.setTheme("light", window.getScene()));

        view.getItems().addAll(dark, light);

        return new MenuBar(file, view);
    }
}
