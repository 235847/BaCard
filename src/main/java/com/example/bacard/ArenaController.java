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
        //invisibleBut.setVisible(false);

        draggableMaker.makeDraggable(bakuAndBut);

        deck = new Deck();
        deck.shuffleDeck();
        player1 = new Player(deck.drawCard());
        player2 = new Player(deck.drawCard());
//        showcards(player1);
        manaPlayer1.setText(Integer.toString(player1.getCurrent_mana()));
        hpPlayer1.setText(Integer.toString(player1.getHp()));
        manaPlayer2.setText(Integer.toString(player2.getCurrent_mana()));
        hpPlayer2.setText(Integer.toString(player2.getHp()));

//        invisibleBut.setVisible(false);
//        invisibleBut.setLayoutX(baku1.getLayoutX() + 247);
//        invisibleBut.setLayoutY(baku1.getLayoutY() + 269);
//        invisibleBut.layoutYProperty().bindBidirectional(baku1.layoutYProperty());
//        invisibleBut.layoutXProperty().bindBidirectional(baku1.layoutXProperty());
//        invisibleBut.layoutXProperty().bind(baku1.layoutXProperty().add(247));
    }
    @FXML
    private void attackHero(){
        //player2.setHp(player2.getHp()- player2.getPlayer_deck().get(0).getAttack());
        player2.setHp(player2.getHp()- 6);
        hpPlayer2.setText(Integer.toString(player2.getHp()));

        AnchorPane card1 = new AnchorPane();
        card1.setId("Skorpion");
        card1.setLayoutX(782.0);
        card1.setLayoutY(575.0);
        card1.setPrefHeight(200.0);
        card1.setPrefWidth(200.0);

        ImageView sth1 = new ImageView();
        sth1.setId("im1");
        sth1.setFitHeight(388.0);
        sth1.setFitWidth(409.0);
        sth1.setPickOnBounds(true);
        sth1.setPreserveRatio(true);

        Image im = new Image("C:/Users/osada/IdeaProjects/BaCard/src/main/resources/com/example/bacard/Card_prev.png");
        sth1.setImage(im);

        card1.getChildren().add(sth1);
        MainStage.getChildren().add(card1);

        draggableMaker.makeDraggable(card1);

        Button b = new Button();
        b.setId("invisibleBut1");
        b.setLayoutX(246.0);
        b.setLayoutY(270.0);
        b.setMnemonicParsing(false);
        b.setOnAction(actionEvent -> attackHero());
        b.setOpacity(0.0);
        b.setPrefHeight(13.0);
        b.setPrefWidth(15.0);
        card1.getChildren().add(b);
    }

    private void showcards(Player player){

//        Stage stage = (Stage) sth2.getScene().getWindow();
//        Scene scene = stage.getScene();
//        scene
    }
}