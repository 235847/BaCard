package com.example.bacard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Arena extends Application {

//    Player player1;
//    Player player2;
//    Deck deck;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Arena");

        FXMLLoader fxmlLoader = new FXMLLoader(Arena.class.getResource("hello-view.fxml"));

//        player1 = new Player();
//        player2 = new Player();
//        deck = new Deck();
//        deck.testDiplayDeck();

        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}