package com.example.bacard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private AnchorPane bakuAndBut;
    @FXML
    private Label valueRound;
    @FXML
    private Label round;

    @FXML
    private Button invisibleBut;
    @FXML
    private VBox vbox1;

    @FXML
    private AnchorPane MainStage;

    DraggableMaker draggableMaker = new DraggableMaker();


    private Player player1;
    private Player player2;
    private Deck deck;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new Deck();
        deck.shuffleDeck();
        player1 = new Player(1,deck.drawCard(),deck.drawCard(),deck.drawCard(),MainStage);
        player2 = new Player(2,deck.drawCard(),deck.drawCard(),deck.drawCard(),MainStage);

        manaPlayer1.setText(Integer.toString(player1.getCurrent_mana()));
        hpPlayer1.setText(Integer.toString(player1.getHp()));
        manaPlayer2.setText(Integer.toString(player2.getCurrent_mana()));
        hpPlayer2.setText(Integer.toString(player2.getHp()));

    }

    @FXML
    private void attackHero(){
        //player2.setHp(player2.getHp()- player2.getPlayer_deck().get(0).getAttack());
        player2.setHp(player2.getHp()- 6);
        hpPlayer2.setText(Integer.toString(player2.getHp()));


    }
}