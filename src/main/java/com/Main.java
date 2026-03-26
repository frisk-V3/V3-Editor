package com;

import com.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // IDE のメインウィンドウを起動
        new MainWindow(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
