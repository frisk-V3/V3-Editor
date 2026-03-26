package com.ui;

import javafx.scene.Scene;

public class ThemeManager {

    private static String current = "dark";

    public static void apply(Scene scene) {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(
                ThemeManager.class.getResource("/themes/" + current + ".css").toExternalForm()
        );
    }

    public static void setTheme(String theme, Scene scene) {
        current = theme;
        apply(scene);
    }

    public static String getTheme() {
        return current;
    }
}
