package org.example;

import java.io.Console;
import java.sql.*;

/**
 * JDBC 插入
 */
public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO students (id, grade, name, gender, score) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                // 注意：索引从1开始
                preparedStatement.setObject(1, 99);
                preparedStatement.setObject(2, 1);
                preparedStatement.setObject(3, "Bob");
                preparedStatement.setObject(4, 2);
                preparedStatement.setObject(5, 100);
                int i = preparedStatement.executeUpdate();
                System.out.println("insert into students: " + i);
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        System.out.println(id);
                    }
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
