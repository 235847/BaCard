//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Card {
    private static final int OVERHEALTH = 5000;
    private final String name;
    private final int attack;
    private int hp;
    private final int mana_cost;
    public int ready = 0;
    private int playerId;
    public boolean is_dead = false;
    public Label hp_label;
    public AnchorPane pane;

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public Card(String n, int a, int h, int m) {
        this.name = n;
        this.attack = a;
        this.hp = h;
        this.mana_cost = m;
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMana_cost() {
        return this.mana_cost;
    }

    public void attack(Card enemy)
    {
        System.out.println(this.getName() + "Attacked " + enemy.getName());
        reduce_hp(enemy.getAttack());
        enemy.reduce_hp(attack);
    }

    public void reduce_hp(int amount)
    {
        hp -= amount;
        if(hp <= 0)
        {
            is_dead = true;
        }
        hp_label.setText(Integer.toString(hp));
    }

}
