package com.example.bacard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    Player player1;
    Player player2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1 = new Player();
        player2 = new Player();

    }
}