package org.example;

import java.sql.*;

/**
 *
 * JDBC 查询返回结果集 使用字段名取值
 * @author shibor
 */
public class Demo2 {

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
            try (PreparedStatement stmt = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
                stmt.setObject(1, "M");
                stmt.setObject(2, 3);
                // 4.返回结果集
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        // 用字段名可读性更好
                        long id = rs.getLong("id");
                        long grade = rs.getLong("grade");
                        String name = rs.getString("name");
                        String gender = rs.getString("gender");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
