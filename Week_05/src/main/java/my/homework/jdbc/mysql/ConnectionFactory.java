package my.homework.jdbc.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdb:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "root";

    public static HikariDataSource dataSource;

    static {
        HikariConfig srcConf = new HikariConfig();
        srcConf.setJdbcUrl(url);
        srcConf.setUsername(username);
        srcConf.setPassword(password);
        srcConf.setDriverClassName(driver);

        dataSource = new HikariDataSource(srcConf);
    }

    public static Connection getConnection(){

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
