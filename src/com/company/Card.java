package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private static int OVERHEALTH = 5000;
    private final String name;
    private int attack;
    private int hp;
    private int mana_cost;

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
    public boolean damage(int ammount)
    {
        if(hp - ammount >= OVERHEALTH)  return true;
        if(hp - ammount <= 0)
        {
            hp = 0;
            return true;
        }
        return false;
    }

    //returns true if bakugan died as a result else returns false
    public boolean heal(int ammount)
    {
        if(hp + ammount >= OVERHEALTH)  return true;
        if(hp + ammount <= 0)
        {
            hp = 0;
            return true;
        }
        return false;
    }

    //constructor
    public Card(String n, int a, int h, int m)
    {
        name =n;
        attack = a;
        hp = h;
        mana_cost = m;
    }
}
