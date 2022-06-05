//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bacard;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertsIntoDatabase {
    private static final String QUERY_CREATE_TABLE = "CREATE TABLE bacard (bakuID int NOT NULL,name varchar(100) NOT NULL,attack int NOT NULL,hp int NOT NULL,mana int NOT NULL,PRIMARY KEY (bakuID))";
    private static final String QUERY_INSERT = " insert into bacard (bakuID, name, attack, hp, mana) values (?, ?, ?, ?, ?)";

    public InsertsIntoDatabase() {
    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bakugan", "root", "");
            PreparedStatement prepareStatement_for_creating = connection.prepareStatement("CREATE TABLE bacard (bakuID int NOT NULL,name varchar(100) NOT NULL,attack int NOT NULL,hp int NOT NULL,mana int NOT NULL,PRIMARY KEY (bakuID))");
            prepareStatement_for_creating.executeUpdate();
            prepareStatement_for_creating.close();
            PreparedStatement preparedStmt = connection.prepareStatement(" insert into bacard (bakuID, name, attack, hp, mana) values (?, ?, ?, ?, ?)");
            File fp = new File("inserts");
            Scanner scanner = new Scanner(fp);

            for(int i = 1; scanner.hasNextLine(); ++i) {
                String data = scanner.nextLine();
                int separator_index_after = data.indexOf(124);
                String name = data.substring(0, separator_index_after);
                int separator_index_before = separator_index_after + 1;
                separator_index_after = data.indexOf(124, separator_index_before);
                String attack = data.substring(separator_index_before, separator_index_after);
                separator_index_before = separator_index_after + 1;
                separator_index_after = data.indexOf(124, separator_index_before);
                String hp = data.substring(separator_index_before, separator_index_after);
                separator_index_before = separator_index_after + 1;
                String mana = data.substring(separator_index_before);
                System.out.println(name + " " + Integer.parseInt(attack) + " " + Integer.parseInt(hp) + " " + Integer.parseInt(mana) + "\n");
                preparedStmt.setInt(1, i);
                preparedStmt.setString(2, name);
                preparedStmt.setInt(3, Integer.parseInt(attack));
                preparedStmt.setInt(4, Integer.parseInt(hp));
                preparedStmt.setInt(5, Integer.parseInt(mana));
                preparedStmt.execute();
            }

            scanner.close();
            preparedStmt.close();
            connection.close();
        } catch (FileNotFoundException var14) {
            System.out.println("Error: couldn't open the file");
        } catch (Exception var15) {
            var15.printStackTrace();
            System.out.println("Error: writing into database");
        }

    }
}
