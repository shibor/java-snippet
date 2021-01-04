package org.example.cp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.text.MessageFormat;

/**
 * 数据库连接池HikariCP
 *
 * @author shibor
 */
public class HikariCPDemo {

    public static void main(String[] args) {
        {
            String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
            String JDBC_USER = "learn";
            String JDBC_PASSWORD = "learnpassword";

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(JDBC_URL);
            config.setUsername(JDBC_USER);
            config.setPassword(JDBC_PASSWORD);
            config.addDataSourceProperty("connectionTimeout", "1000");
            config.addDataSourceProperty("idleTimeout", "60000");
            config.addDataSourceProperty("maximumPoolSize", "10");
            DataSource ds = new HikariDataSource(config);

            try (Connection conn = ds.getConnection()) {
                try (Statement stmt = conn.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
                        while (rs.next()) {
                            long id = rs.getLong(1);
                            long grade = rs.getLong(2);
                            String name = rs.getString(3);
                            int gender = rs.getInt(4);
                            System.out.println(MessageFormat.format("id:{0} name:{1} grade:{2} gender:{3}", id, name, grade, gender));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
