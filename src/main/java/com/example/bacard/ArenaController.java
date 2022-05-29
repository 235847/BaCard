package com.example.bacard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    private Player player1;
    private Player player2;
    private Deck deck;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new Deck();
        deck.shuffleDeck();
        player1 = new Player(deck.drawCard(), deck.drawCard(), deck.drawCard());
        player2 = new Player(deck.drawCard(), deck.drawCard(), deck.drawCard());
        int i = 0;
        while(player1.getHp() > 0 && player2.getHp() > 0){
            if(i == 0){
                
            }
            i++;
        }
    }
}