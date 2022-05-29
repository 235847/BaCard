package com.example.bacard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    @FXML
    private Label manaPlayer1;
    @FXML
    private Label hpPlayer1;
    @FXML
    private Label hpPlayer2;
    @FXML
    private Label manaPlayer2;
    @FXML
    private ImageView baku1;
    @FXML
    private Button invisibleBut;

    DraggableMaker draggableMaker = new DraggableMaker();


    private Player player1;
    private Player player2;
    private Deck deck;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //invisibleBut.setVisible(false);
        draggableMaker.makeDraggable(baku1);
        deck = new Deck();
        deck.shuffleDeck();
        player1 = new Player(deck.drawCard(), deck.drawCard(), deck.drawCard());
        player2 = new Player(deck.drawCard(), deck.drawCard(), deck.drawCard());

        manaPlayer1.setText(Integer.toString(player1.getCurrent_mana()));
        hpPlayer1.setText(Integer.toString(player1.getHp()));
        manaPlayer2.setText(Integer.toString(player1.getCurrent_mana()));
        hpPlayer2.setText(Integer.toString(player1.getHp()));

        int i = 0;

    }
}