package com.example.bacard;

public class Card {

    private final static int OVERHEALTH = 5000;
    private final String name;
    private final int attack;
    private int hp;
    private final int mana_cost;
    public int ready;

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    private int playerId;
    //constructor
    public Card(String n, int a, int h, int m)
    {
        ready = 0;
        name =n;
        attack = a;
        hp = h;
        mana_cost = m;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public int getMana_cost() {
        return mana_cost;
    }

    //returns true if bakugan died as a result else returns false
    public boolean damage(int amount)
    {
        if(hp - amount >= OVERHEALTH)  return true;
        if(hp - amount <= 0)
        {
            hp = 0;
            return true;
        }
        return false;
    }

    //returns true if bakugan healed as a result else returns false
    public boolean heal(int amount)
    {
        if(hp + amount >= OVERHEALTH)  return true;
        if(hp + amount <= 0)
        {
            hp = 0;
            return true;
        }
        return false;
    }
}

