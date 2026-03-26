package com.ui;

import javafx.scene.image.Image;

public class IconLoader {

    public static Image loadLogo() {
        return new Image(IconLoader.class.getResourceAsStream("/icons/frisk.ico"));
    }
}
