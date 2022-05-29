package com.example.bacard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ArenaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}