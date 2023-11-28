package com.f.chapter21.dao_.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/12 21:25
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块完成ds的初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("file\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //得到Druid数据库连接池的Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接，即将Connection对象归还给Druid数据库连接池
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
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
