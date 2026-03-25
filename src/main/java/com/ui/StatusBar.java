package com.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatusBar extends HBox {

    private final Label message = new Label("Ready");

    public StatusBar() {
        getChildren().add(message);
        setStyle("-fx-padding: 4; -fx-background-color: #333; -fx-text-fill: white;");
    }

    public void setMessage(String msg) {
        message.setText(msg);
    }
}
