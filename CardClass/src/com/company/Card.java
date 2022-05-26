package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private String name;
    private int attack;
    private int hp;
    private int mana_cost;

    public Card(int record){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bacard WHERE bacard.bakuID = "+ record);     //passing our query through the statement
            while (rs.next()){
                name = rs.getString("name");
                attack = rs.getInt("attack");
                hp = rs.getInt("hp");
                mana_cost = rs.getInt("mana");
            }
            statement.close();          //closing the conversation with database.
            connection.close();             //optional
        }catch (Exception e){
            System.out.println("Error: loading from database\n");
            e.printStackTrace();
        }
    }
}
