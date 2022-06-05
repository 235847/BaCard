//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

public class Card {

    /* Card's attributes */
    private final String name;
    private int hp;
    private final int attack;
    private final int mana_cost;

    /* Card's status */
    private int player_id;
    public int ready = 0;

    public Card(String name, int attack, int hp, int mana) {
        this.name = name;
        this.attack = attack;
        this.hp = hp;
        this.mana_cost = mana;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getPlayer_id() {
        return this.player_id;
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

    public boolean damage(int amount) {
        if (this.hp - amount >= 5000) {
            return true;
        } else if (this.hp - amount <= 0) {
            this.hp = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean heal(int amount) {
        if (this.hp + amount >= 5000) {
            return true;
        } else if (this.hp + amount <= 0) {
            this.hp = 0;
            return true;
        } else {
            return false;
        }
    }
}
