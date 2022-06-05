//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Player {

    enum Choice {
        attack,
        card_manage;
    }

    /* Player's attributes */
    private final int id;
    private int hp;
    private int current_mana;
    Choice status = Choice.card_manage;
    private ArrayList<Card> player_deck = new ArrayList<>();

    /* Player's constants */
    private static final int STARTING_HP = 30;
    private static final int STARTING_MANA = 8;

    /* Visual aspects */
    @FXML
    private final AnchorPane stage;
    @FXML
    private HashMap<String, AnchorPane> deck_Anchor_Pane = new HashMap<>();
    @FXML
    private final Label hpLabel;
    @FXML
    private final Label manaLabel;


    public Player(int id, Card first, Card second, Card third, AnchorPane stage, Label hp_label, Label mana_label) {
        this.id = id;
        this.hp = STARTING_HP;
        this.current_mana = STARTING_MANA;

        this.addCard(first);
        this.addCard(second);
        this.addCard(third);

        this.hpLabel = hp_label;
        this.manaLabel = mana_label;
        this.stage = stage;

        this.setCardView();         //Displaying your hand.
    }

    private void setCardView() {
        for(int i = 0; i < this.player_deck.size(); i++){
            if (this.id == 1) {
                this.deck_Anchor_Pane.get(this.player_deck.get(i).getName()).setLayoutX((100 + (i+1) * 200));
                this.deck_Anchor_Pane.get(this.player_deck.get(i).getName()).setLayoutY(780.0D);
            }
            else{
                this.deck_Anchor_Pane.get(this.player_deck.get(i).getName()).setLayoutX((1920 - (350 + (i+1) * 200)));
                this.deck_Anchor_Pane.get(this.player_deck.get(i).getName()).setLayoutY(0.0D);
            }
        }
    }

    public int getHp() {
        return this.hp;
    }

    public ArrayList<Card> getPlayer_deck() {
        return this.player_deck;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCurrent_mana() {
        return this.current_mana;
    }

    public void addCard(Card c) {
        c.setPlayer_id(this.id);
        this.player_deck.add(c);

        /* Card's health points configuration*/
        Label hape = new Label();
        hape.setText(Integer.toString(c.getHp()));
        hape.setTextFill(Paint.valueOf("WHITE"));
        hape.setId(c.getName() + "hp");
        hape.setLayoutX(23.0D);
        hape.setLayoutY(220.0D);
        hape.setFont(new Font("Papyrus", 40.0D));

        /* Setting space for the card */
        AnchorPane card = new AnchorPane();
        card.setId(c.getName());
        card.setLayoutX(782.0D);
        card.setLayoutY(575.0D);
        card.setPrefHeight(200.0D);
        card.setPrefWidth(200.0D);

        /* Card's Image */
        ImageView imageView = new ImageView();
        imageView.setId(c.getName() + "imView");
        imageView.setFitHeight(300.0D);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

//        System.out.println(c.getName());
        URL url = this.getClass().getResource("bakugans/"+c.getName()+".png");
        Image image = new Image(String.valueOf(url));
        imageView.setImage(image);

        /* Throw card button*/
        Button button = new Button();
        button.setId(c.getName() + "Button");
        button.setLayoutX(0.0D);
        button.setLayoutY(0.0D);
        button.setMnemonicParsing(false);
        button.setOnAction((actionEvent) -> {
            this.readyCards(c);
        });
        button.setOpacity(0.0D);
        button.setPrefHeight(300.0D);
        button.setPrefWidth(200.0D);

        /* Creating tree */
        card.getChildren().addAll(imageView,hape,button);
        this.stage.getChildren().add(card);
        this.deck_Anchor_Pane.put(card.getId(), card);
    }

    @FXML
    private void readyCards(Card c) {
        if (c.getPlayer_id() == 1) {
            if (c.ready == 0) {
                if (this.current_mana - c.getMana_cost() >= 0) {
                    c.ready = 1;
                    this.reduce_mana(c.getMana_cost());
                    this.manaLabel.setText(Integer.toString(this.getCurrent_mana()));
                    ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).setLayoutY(((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).getLayoutY() - 200.0D);
                }
            } else if (c.ready == 1) {
                c.ready = 0;
                this.current_mana += c.getMana_cost();
                this.manaLabel.setText(Integer.toString(this.getCurrent_mana()));
                ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).setLayoutY(((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).getLayoutY() + 200.0D);
            }
        }
        else {
            if (c.ready == 0) {
                if (this.current_mana - c.getMana_cost() >= 0) {
                    c.ready = 1;
                    this.reduce_mana(c.getMana_cost());
                    this.manaLabel.setText(Integer.toString(this.getCurrent_mana()));
                    ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).setLayoutY(((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).getLayoutY() + 200.0D);
                }
            } else if (c.ready == 1) {
                c.ready = 0;
                this.current_mana += c.getMana_cost();
                this.manaLabel.setText(Integer.toString(this.getCurrent_mana()));
                ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).setLayoutY(((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(this.player_deck.indexOf(c))).getName())).getLayoutY() - 200.0D);
            }
        }

    }

    private void reduce_mana(int x) {
        this.current_mana -= x;
    }
}
