package ru.geek.brains.javathree.lessonTwo;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect();
            //System.out.println("connect");
            prepareAllStatements();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }

    }

    private static void fillTable() throws SQLException {
        for (int i = 1; i <= 10; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, i * 15%100);
            psInsert.executeUpdate();
        }
    }


    private static void prepareAllStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
    }

    // |Выборка из БД.
    private static void exSelect() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT name, score FROM students WHERE score > 70;");
        while (rs.next()){
            System.out.println(rs.getString(1) + " " + rs.getInt(2));
        }
        rs.close();
    }
    // Удаление.
    private static void exDelete() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE score < 80;");
    }

    // Обеновление БД.
    private static void exUpdate() throws SQLException {
        stmt.executeUpdate("UPDATE students SET score = 100 WHERE score = 50;");
    }

// Вставка в таблицу.
    private static void exInsert(){
        try {
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 80);");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private static void disconnect(){
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
