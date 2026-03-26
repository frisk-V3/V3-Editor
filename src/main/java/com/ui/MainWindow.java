package com.ui;

import com.editor.EditorTab;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;

public class MainWindow {

    private final Stage stage;

    // FXML から読み込む UI パーツ
    public MenuBar menuBar;
    public TabPane editorTabs;
    public TextArea outputPane;
    public Label statusLabel;
    public VBox sideBar;

    private Explorer explorer;

    public MainWindow(Stage stage) {
        this.stage = stage;

        try {
            // FXML 読み込み
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/main.fxml"));
            loader.setController(this);
            BorderPane root = loader.load();

            // シーン作成
            Scene scene = new Scene(root, 1400, 900);
            ThemeManager.apply(scene);

            // アイコン設定（frisk.ico）
            stage.getIcons().add(IconLoader.loadLogo());

            stage.setScene(scene);
            stage.setTitle("frisk-IDE");
            stage.show();

            // Explorer（サイドバー）を追加
            explorer = new Explorer(this);
            sideBar.getChildren().add(explorer);

            // 仮のプロジェクト読み込み（必要に応じて変更）
            File projectDir = new File("project");
            if (projectDir.exists()) {
                explorer.loadProject(projectDir);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log("Failed to initialize MainWindow");
        }
    }

    // -----------------------------
    // ファイルをエディタで開く
    // -----------------------------
    public void openFile(Path path) {
        try {
            // すでに開いているタブがあるか確認
            for (Tab t : editorTabs.getTabs()) {
                if (t.getText().equals(path.getFileName().toString())) {
                    editorTabs.getSelectionModel().select(t);
                    return;
                }
            }

            // 新しいタブを作成
            EditorTab tab = new EditorTab(path);
            editorTabs.getTabs().add(tab);
            editorTabs.getSelectionModel().select(tab);

            setStatus("Opened: " + path.getFileName());

        } catch (Exception e) {
            e.printStackTrace();
            log("Failed to open file: " + path);
        }
    }

    // -----------------------------
    // ログ出力
    // -----------------------------
    public void log(String text) {
        outputPane.appendText(text + "\n");
    }

    // -----------------------------
    // ステータスバー更新
    // -----------------------------
    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public Scene getScene() {
        return stage.getScene();
    }
}
