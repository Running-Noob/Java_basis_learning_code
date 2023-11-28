package com.f.chapter21.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/4 20:28
 */
public class JdbcConn {
    public static void main(String[] args) throws Exception {
        //使用配置文件，连接数据库更加灵活
        Properties properties = new Properties();
        properties.load(new FileInputStream("file\\jdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
