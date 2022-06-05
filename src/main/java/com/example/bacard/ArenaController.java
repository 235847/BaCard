//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ArenaController implements Initializable {
    int Actround =0;
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

    @FXML
    public void start(ActionEvent event) throws Exception{

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

//        while(player1.getHp()>0 && player2.getHp()>0){
//
//
//        }
        if(Actround%2==0){
            player1.addCard(deck.drawCard());
        }
        else{
            player2.addCard(deck.drawCard());
        }
        Actround++;
        valueRound.setText(Integer.toString(Actround));

        //display("Game Over","Player 1 HP :" + player1.getHp() + "\nPlayer 2 HP :" + player2.getHp());
        //window.close();

    }


    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button close = new Button("Close the window");
        close.setOnAction(actionEvent -> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,close);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,200,150);
        window.setScene(scene);
        window.showAndWait();
    }

}
