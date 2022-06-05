//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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

    public ArenaController() {
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.player1 = new Player(1, this.deck.drawCard(), this.deck.drawCard(), this.deck.drawCard(), this.MainStage, this.hpPlayer1, this.manaPlayer1);
        this.player2 = new Player(2, this.deck.drawCard(), this.deck.drawCard(), this.deck.drawCard(), this.MainStage, this.hpPlayer2, this.manaPlayer2);
        this.manaPlayer1.setText(Integer.toString(this.player1.getCurrent_mana()));
        this.hpPlayer1.setText(Integer.toString(this.player1.getHp()));
        this.manaPlayer2.setText(Integer.toString(this.player2.getCurrent_mana()));
        this.hpPlayer2.setText(Integer.toString(this.player2.getHp()));
    }

    @FXML
    private void attackHero() {
        this.player2.setHp(this.player2.getHp() - 6);
        this.hpPlayer2.setText(Integer.toString(this.player2.getHp()));
    }
}
