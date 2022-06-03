package com.example.bacard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class Player {

    enum choice{
        attack,
        card_manage
    }

    private int current_mana;
    private final static int starting_mana = 8;
    private int hp;
    private int id;
    private final static int STARTING_HP = 30;
    choice status;
    private ArrayList<Card> player_deck;
    AnchorPane MainStage;
    private HashMap<String, AnchorPane> deck_Anchor_Pane;
    Label hpLabel;
    Label manaLabel;

    public Player(int i,Card first, Card second, Card third, AnchorPane stage, Label hpLabel, Label manaLabel) {
        this.hpLabel = hpLabel;
        this.manaLabel = manaLabel;
        hp = STARTING_HP;
        id = i;
        MainStage = stage;
        current_mana = starting_mana;
        status = choice.card_manage;
        player_deck = new ArrayList<>(3);
        deck_Anchor_Pane = new HashMap<>();
        addCard(first);
        addCard(second);
        addCard(third);
        setCardView();
    }

    public void setCardView()
    {
        if(id == 1)
        {
            for(int i = 0 ; i < player_deck.size() ; i++)
            {
                deck_Anchor_Pane.get(player_deck.get(i).getName()).setLayoutX(100 + i * 200);
                deck_Anchor_Pane.get(player_deck.get(i).getName()).setLayoutY(780);
            }
        }
        if(id == 2)
        {
            for(int i = 0 ; i < player_deck.size() ; i++)
            {
                deck_Anchor_Pane.get(player_deck.get(i).getName()).setLayoutX(1920 - (350 + i * 200));
                deck_Anchor_Pane.get(player_deck.get(i).getName()).setLayoutY(0);
            }
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
        c.setPlayerId(id);
        player_deck.add(c);
        Label hape = new Label();
        hape.setText(Integer.toString(c.getHp()));
        hape.setTextFill(Paint.valueOf("WHITE"));
        hape.setId(c.getName() + "hp");
        hape.setLayoutX(23);
        hape.setLayoutY(220);
        hape.setFont(new Font("Papyrus",40));

        AnchorPane card1 = new AnchorPane();
        card1.setId(c.getName());
        card1.setLayoutX(782.0);
        card1.setLayoutY(575.0);
        card1.setPrefHeight(200.0);
        card1.setPrefWidth(200.0);


        ImageView sth1 = new ImageView();
        sth1.setId(c.getName() + "imView");
        sth1.setFitHeight(300.0);
        sth1.setPickOnBounds(true);
        sth1.setPreserveRatio(true);

        //ODKOMENTOWAC PO PRZEROBIENIU NAZW W BAZIE DANYCH
        //URL url = getClass().getResource(c.getName() + ".png");
        URL url = getClass().getResource("Apophix_Aquos.png");
        Image im = new Image(String.valueOf(url));
        sth1.setImage(im);

        card1.getChildren().add(sth1);
        card1.getChildren().add(hape);
        MainStage.getChildren().add(card1);
        deck_Anchor_Pane.put(card1.getId(),card1);

        Button b = new Button();
        b.setId(c.getName() + "Button");
        b.setLayoutX(0.0);
        b.setLayoutY(0.0);
        b.setMnemonicParsing(false);
        b.setOnAction(actionEvent -> readyCards(c));
        b.setOpacity(0.0);
        b.setPrefHeight(300.0);
        b.setPrefWidth(200.0);
        card1.getChildren().add(b);
    }

    @FXML
    private void readyCards(Card c)
    {
        if(c.getPlayerId() == 1)
        {
            if(c.ready == 0)
            {
                if(current_mana - c.getMana_cost() >= 0)
                {
                    c.ready = 1;
                    reduce_mana(c.getMana_cost());
                    manaLabel.setText(Integer.toString(getCurrent_mana()));
                    deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).setLayoutY(
                            deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).getLayoutY() - 200);
                }

            }
            else if(c.ready == 1)
            {
                c.ready = 0;
                current_mana += c.getMana_cost();
                manaLabel.setText(Integer.toString(getCurrent_mana()));
                deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).setLayoutY(
                        deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).getLayoutY() + 200);
            }
        }
        else
        {
            if(c.ready == 0)
            {
                if(current_mana - c.getMana_cost() >= 0)
                {
                    c.ready = 1;
                    reduce_mana(c.getMana_cost());
                    manaLabel.setText(Integer.toString(getCurrent_mana()));
                    deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).setLayoutY(
                            deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).getLayoutY() + 200);
                }

            }
            else if(c.ready == 1)
            {
                c.ready = 0;
                current_mana += c.getMana_cost();
                manaLabel.setText(Integer.toString(getCurrent_mana()));
                deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).setLayoutY(
                        deck_Anchor_Pane.get(player_deck.get(player_deck.indexOf(c)).getName()).getLayoutY() - 200);
            }
        }

    }

    public void reduce_mana(int x)
    {
        current_mana -= x;
    }

}
