package com.f.chapter21.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/6 13:32
 * JDBC的工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关属性
    private static String driver;   //驱动名
    private static String url;  //连接数据库的url
    private static String user; //用户名
    private static String password; //密码

    //在static代码块去初始化相关属性
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("file\\jdbc.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理：
            //  1.将编译异常用运行时异常抛出
            //  2.这时调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection对象
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭相关资源：
     * 1.结果集 ResultSet
     * 2.Statement 或者 PreparedStatement
     * 3.Connection
     * 4.如果需要关闭资源，就传入对象，否则传入null
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
