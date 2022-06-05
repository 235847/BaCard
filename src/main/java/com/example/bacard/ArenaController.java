//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ArenaController implements Initializable {

    /*  Player 1 attributes  */
    @FXML
    private Label player1_hp;
    @FXML
    private Label player1_mana;

    /*  Player 2 attributes  */
    @FXML
    private Label player2_hp;
    @FXML
    private Label player2_mana;

    /* Round attributes */
    @FXML
    private Label value_round;
    @FXML
    private Label round;

    @FXML
    private AnchorPane MainStage;
    @FXML
    private Button start_button;

    private Player player1;
    private Player player2;
    private final Deck deck = new Deck();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.deck.shuffleDeck();
    }


    public void start(ActionEvent event) {
        this.player1 = new Player(1, this.deck.drawCard(), this.deck.drawCard(), this.deck.drawCard(), this.MainStage, this.player1_hp, this.player1_mana);
        this.player2 = new Player(2, this.deck.drawCard(), this.deck.drawCard(), this.deck.drawCard(), this.MainStage, this.player2_hp, this.player2_mana);
        this.player1_mana.setText(Integer.toString(this.player1.getCurrent_mana()));
        this.player1_hp.setText(Integer.toString(this.player1.getHp()));
        this.player2_mana.setText(Integer.toString(this.player2.getCurrent_mana()));
        this.player2_hp.setText(Integer.toString(this.player2.getHp()));
    }
}
