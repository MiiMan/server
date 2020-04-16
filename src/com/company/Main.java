package com.company;

import Database.Database;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Database database = new Database("users.db");
            System.out.println(database.student.hashExists("1"));

            String[] str = database.student.get("1");
            System.out.println(str[0] + " " + str[1] + " " + str[2]);



            database.teacher.add("MiMan", "2512");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
