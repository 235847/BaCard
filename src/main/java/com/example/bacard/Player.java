package com.example.bacard;

import javafx.scene.control.Button;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Player {

    enum choice{
        attack,
        card_manage
    }

    private int current_mana;
    private int starting_mana;
    private int hp;
    private int id;
    private final static int STARTING_HP = 30;
    choice status;
    private ArrayList<Card> player_deck;
    AnchorPane MainStage;

    public Player(int i,Card first, Card second, Card third, AnchorPane stage) {
        hp = STARTING_HP;
        starting_mana = 1;
        id = i;
        MainStage = stage;
        current_mana = starting_mana;
        status = choice.card_manage;
        player_deck = new ArrayList<>(3);
        addCard(first);
        addCard(second);
        addCard(third);
    }

    public void setCardView()
    {
        for(int i = 0 ; i < player_deck.size() ; i++)
        {

        }
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Card> getPlayer_deck() {
        return player_deck;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCurrent_mana() {
        return current_mana;
    }

    public void addCard(Card c)
    {
        player_deck.add(c);

        AnchorPane card1 = new AnchorPane();
        card1.setId(c.getName());
        card1.setLayoutX(782.0);
        card1.setLayoutY(575.0);
        card1.setPrefHeight(200.0);
        card1.setPrefWidth(200.0);

        ImageView sth1 = new ImageView();
        sth1.setId(c.getName() + "imView");
        sth1.setFitHeight(388.0);
        sth1.setFitWidth(409.0);
        sth1.setPickOnBounds(true);
        sth1.setPreserveRatio(true);
        //uncomment when database fix
        //Image im = new Image("assets/" + c.getName() + ".png");
        Image im = new Image("/assets/Apophix_Aquos.png");
        sth1.setImage(im);

        card1.getChildren().add(sth1);
        MainStage.getChildren().add(card1);

        Button b = new Button();
        b.setId(c.getName() + "Button");
        b.setLayoutX(0.0);
        b.setLayoutY(0.0);
        b.setMnemonicParsing(false);
        b.setOnAction(actionEvent -> c.ready = 1);
        b.setOpacity(0.0);
        b.setPrefHeight(710.0);
        b.setPrefWidth(500.0);
        card1.getChildren().add(b);
    }

}
