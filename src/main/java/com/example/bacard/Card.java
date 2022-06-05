//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

public class Card {
    private static final int OVERHEALTH = 5000;
    private final String name;
    private final int attack;
    private int hp;
    private final int mana_cost;
    public int ready = 0;
    private int playerId;

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
