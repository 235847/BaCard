package com.example.bacard;

public class Player {

    enum choice{
        attack,
        card_manage
    }

    private int current_mana;
    private int starting_mana;
    private int hp;
    private final static int STARTING_HP = 30;
    choice status;

    public Player() {
        hp = STARTING_HP;
        starting_mana = 1;
        current_mana = starting_mana;
        status = choice.card_manage;
    }
}
