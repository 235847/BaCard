//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        try {
            this.deck = new ArrayList();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan", "root", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bacard");

            while(rs.next()) {
                String name = rs.getString("name");
                int attack = rs.getInt("attack");
                int hp = rs.getInt("hp");
                int mana = rs.getInt("mana");
                this.deck.add(new Card(name, attack, hp, mana));
            }

            statement.close();
            connection.close();
        } catch (Exception var8) {
            System.out.println("Error: loading from database\n");
            var8.printStackTrace();
        }

    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card drawCard() {
        return (Card)this.deck.remove(this.deck.size() - 1);
    }

    public Card drawCard(int id) {
        return (Card)this.deck.remove(id);
    }

    public void testDiplayDeck() {
        System.out.println("I want to see my first card:");
        System.out.println("Name:" + ((Card)this.deck.get(0)).getName());
        System.out.println("Attack:" + ((Card)this.deck.get(0)).getAttack());
        System.out.println("Hp:" + ((Card)this.deck.get(0)).getHp());
        System.out.println("Mana:" + ((Card)this.deck.get(0)).getMana_cost());
    }
}
