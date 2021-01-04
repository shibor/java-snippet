package org.example;

import java.sql.*;

/**
 * JDBC查询
 * @author shibor
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
        String JDBC_USER = "learn";
        String JDBC_PASSWORD = "learnpassword";
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.连接
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 3. 创建一个sql语句的发送命令对象
            try (Statement stmt = conn.createStatement()) {
                // 4.返回结果集
                try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
                    while (rs.next()) {
                        // 注意：索引从1开始
                        long id = rs.getLong(1);
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
