package com.example.bacard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Arena extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Arena");

        FXMLLoader fxmlLoader = new FXMLLoader(Arena.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}