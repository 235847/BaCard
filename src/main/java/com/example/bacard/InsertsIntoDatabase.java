package com.example.bacard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertsIntoDatabase {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bakugan","root","");
            String query = " insert into bacard (bakuID, name, attack, hp, mana)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            File fp = new File("inserts");
            Scanner scanner = new Scanner(fp);
            int i = 1;
            int separator_index_before, separator_index_after;
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                separator_index_after = data.indexOf('|');
                String name = data.substring(0,separator_index_after);
                separator_index_before = separator_index_after + 1;
                separator_index_after = data.indexOf('|',separator_index_before);
                String attack = data.substring(separator_index_before,separator_index_after);
                separator_index_before = separator_index_after + 1;
                separator_index_after = data.indexOf('|',separator_index_before);
                String hp = data.substring(separator_index_before,separator_index_after);
                separator_index_before = separator_index_after + 1;
                String mana = data.substring(separator_index_before);
//                System.out.println(data+"\n");
                System.out.println(name+" "+Integer.parseInt(attack)+" "+Integer.parseInt(hp)+" "+Integer.parseInt(mana)+"\n");
                preparedStmt.setInt(1, i);
                preparedStmt.setString(2, name);
                preparedStmt.setInt(3,Integer.parseInt(attack));
                preparedStmt.setInt(4,Integer.parseInt(hp));
                preparedStmt.setInt(5,Integer.parseInt(mana));
                preparedStmt.execute();
                i++;
            }
            scanner.close();
            preparedStmt.close();
            connection.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: couldn't open the file");
        }catch (Exception e){
            System.out.println("Error: writing into database");
        }
    }
}

