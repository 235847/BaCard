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
    private int current_mana;
    private static final int starting_mana = 8;
    private int hp;
    private int id;
    private static final int STARTING_HP = 30;
    Player.choice status;
    private ArrayList<Card> player_deck;
    AnchorPane MainStage;
    private HashMap<String, AnchorPane> deck_Anchor_Pane;
    Label hpLabel;
    Label manaLabel;

    public Player(int i, Card first, Card second, Card third, AnchorPane stage, Label hpLabel, Label manaLabel) {
        this.hpLabel = hpLabel;
        this.manaLabel = manaLabel;
        this.hp = 30;
        this.id = i;
        this.MainStage = stage;
        this.current_mana = 8;
        this.status = Player.choice.card_manage;
        this.player_deck = new ArrayList(3);
        this.deck_Anchor_Pane = new HashMap();
        this.addCard(first);
        this.addCard(second);
        this.addCard(third);
        this.setCardView();
    }

    public void setCardView() {
        int i;
        if (this.id == 1) {
            for(i = 0; i < this.player_deck.size(); i++) {
                ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(i)).getName())).setLayoutX((double)(100 + i * 200));
                ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(i)).getName())).setLayoutY(780.0D);
            }
        }

        if (this.id == 2) {
            for(i = 0; i < this.player_deck.size(); i++) {
                ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(i)).getName())).setLayoutX((double)(1920 - (350 + i * 200)));
                ((AnchorPane)this.deck_Anchor_Pane.get(((Card)this.player_deck.get(i)).getName())).setLayoutY(0.0D);
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
        c.setPlayerId(this.id);
        this.player_deck.add(c);
        Label hape = new Label();
        hape.setText(Integer.toString(c.getHp()));
        hape.setTextFill(Paint.valueOf("WHITE"));
        hape.setId(c.getName() + "hp");
        hape.setLayoutX(23.0D);
        hape.setLayoutY(220.0D);
        hape.setFont(new Font("Papyrus", 40.0D));
        AnchorPane card1 = new AnchorPane();
        card1.setId(c.getName());
        card1.setLayoutX(782.0D);
        card1.setLayoutY(575.0D);
        card1.setPrefHeight(200.0D);
        card1.setPrefWidth(200.0D);
        ImageView sth1 = new ImageView();
        sth1.setId(c.getName() + "imView");
        sth1.setFitHeight(300.0D);
        sth1.setPickOnBounds(true);
        sth1.setPreserveRatio(true);

        System.out.println(c.getName());
        URL url = this.getClass().getResource(c.getName()+".png");
        Image im = new Image(String.valueOf(url));
        sth1.setImage(im);
        card1.getChildren().add(sth1);
        card1.getChildren().add(hape);
        this.MainStage.getChildren().add(card1);
        this.deck_Anchor_Pane.put(card1.getId(), card1);
        Button b = new Button();
        b.setId(c.getName() + "Button");
        b.setLayoutX(0.0D);
        b.setLayoutY(0.0D);
        b.setMnemonicParsing(false);
        b.setOnAction((actionEvent) -> {
            this.readyCards(c);
        });
        b.setOpacity(0.0D);
        b.setPrefHeight(300.0D);
        b.setPrefWidth(200.0D);
        card1.getChildren().add(b);
    }

    @FXML
    private void readyCards(Card c) {
        if (c.getPlayerId() == 1) {
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
        } else if (c.ready == 0) {
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

    public void reduce_mana(int x) {
        this.current_mana -= x;
    }

    static enum choice {
        attack,
        card_manage;

        private choice() {
        }
    }
}
