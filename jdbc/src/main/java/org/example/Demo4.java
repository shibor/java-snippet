package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC 批量操作
 */
public class Demo4 {

    public static void main(String[] args) throws ClassNotFoundException {
        List<Student> students = new ArrayList();
        students.add(new Student("小明", 1, 2, 98));
        students.add(new Student("小宏", 1, 2, 97));

        Class.forName("com.mysql.cj.jdbc.Driver");
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
                for (Student s : students) {
                    preparedStatement.setString(1, s.name);
                    preparedStatement.setInt(2, s.gender);
                    preparedStatement.setInt(3, s.grade);
                    preparedStatement.setInt(4, s.score);
                    preparedStatement.addBatch(); // 添加到batch
                }
                int[] ints = preparedStatement.executeBatch();
                for(int n : ints){
                    // batch中每个SQL执行的结果数量
                    System.out.println(n + " inserted.");
                }

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

class Student {
    public Student(String name, int gender, int grade, int score) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.score = score;
    }

    String name;
    int gender;
    int grade;
    int score;
}
