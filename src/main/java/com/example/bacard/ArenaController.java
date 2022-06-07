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
    int Actround =0;
    int maxRoundMana=8;

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

        if(Actround%2==0){
            player1.can_move = false;
            player2.can_move = true;
            Actround++;
        }
        else {
            int ammount1 = get_ready_num(player1);
            int ammount2 = get_ready_num(player2);
            if(ammount1 >= ammount2)
            {
                fight(player1,player2,ammount1,ammount2);
            }
            else
            {
                fight(player2,player1,ammount2,ammount1);
            }
            player1.can_move = true;
            player2.can_move = false;
            maxRoundMana++;
            Actround++;
            round_end_addcards();
            valueRound.setText(Integer.toString(Actround/2));
            this.manaPlayer1.setText(Integer.toString(this.player1.getCurrent_mana()));
            this.hpPlayer1.setText(Integer.toString(this.player1.getHp()));
            this.manaPlayer2.setText(Integer.toString(this.player2.getCurrent_mana()));
            this.hpPlayer2.setText(Integer.toString(this.player2.getHp()));
        }

        if(Actround >= 40){
            display("Game Over","Player 1 HP :" + player1.getHp() + "\nPlayer 2 HP :" + player2.getHp());
            window.close();
        }


    }
    public boolean remove_if_dead(Card card)
    {
        if(card.is_dead)
        {
            MainStage.getChildren().remove(card.pane);
            if(card.getPlayerId() == 1)
            {
                player1.getPlayer_deck().remove(card);
            }
            else
            {
                player2.getPlayer_deck().remove(card);
            }
            return true;
        }
        return false;
    }

    public void fight(Player more, Player less, int more_num, int less_num)
    {
        Card card1,card2;
        int i;
        for(i = 0 ; i < less_num ; i++)
        {
            card1 = more.get_next_ready(i);
            card2 = less.get_next_ready(i);
            card1.attack(card2);
        }
        for( ; i < more_num ; i++)
        {
            less.setHp(less.getHp() - more.get_next_ready(i).getAttack());
        }
        for(int j = 0 ; j < more.getPlayer_deck().size() ; j++)
        {
            if(remove_if_dead(more.getPlayer_deck().get(j)))
            {
                j = 0;
            }
        }
        for(int j = 0 ; j < less.getPlayer_deck().size() ; j++)
        {
            if(remove_if_dead(less.getPlayer_deck().get(j)))
            {
                j = 0;
            }
        }
        more.reset_ready_states();
        less.reset_ready_states();
        if(less.getHp() <= 0)
        {
            display("Game Over","Player 1 HP :" + player1.getHp() + "\nPlayer 2 HP :" + player2.getHp());
        }
    }
    public int get_ready_num(Player player)
    {
        int res = 0;
        for(int i = 0 ; i < player.getPlayer_deck().size() ; i++)
        {
            if(player.getPlayer_deck().get(i).ready == 1)
            {
                res++;
            }
        }
        return res;
    }

    private void round_end_addcards()
    {
        if(player1.getPlayer_deck().size()<7){
            player1.addCard(deck.drawCard());
        }
        if(player2.getPlayer_deck().size()<7) {
            player2.addCard(deck.drawCard());
        }
            player1.setCardView();
            player1.setCurrent_mana(maxRoundMana);
            player2.setCardView();
            player2.setCurrent_mana(maxRoundMana);
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
