package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private static int COPIES = 2;
    private ArrayList<Card> deck;

    public CardDeck() {
        try{
            deck = new ArrayList<>();
            String name;
            int attack;
            int hp;
            int mana;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bacard");     //passing our query through the statement
            while (rs.next()){
                name = rs.getString("name");
                attack = rs.getInt("hp");
                hp = rs.getInt("hp");
                mana = rs.getInt("mana");
                //adding 2 of the same cards into the deck, changeable with COPIES variable
                for(int i = 0 ; i < COPIES ; i++)
                    deck.add(new Card(name,attack,hp,mana));
            }
            statement.close();          //closing the conversation with database.
            connection.close();             //optional
        }catch (Exception e){
            System.out.println("Error: loading from database\n");
            e.printStackTrace();
        }
    };

    public void changeCopies(int x)
    {
        COPIES = x;
    }

    private void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    public Card drawCard()
    {
        return deck.remove(deck.size() - 1);
    }

    public Card drawCard(int id)
    {
        return deck.remove(id);
    }

    public void testDiplayDeck()
    {

    }
}
