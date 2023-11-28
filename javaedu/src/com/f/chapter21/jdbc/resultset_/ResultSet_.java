package com.f.chapter21.jdbc.resultset_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/5 20:45
 * 演示SELECT语句返回ResultSet，并取出结果
 */
public class ResultSet_ {
    public static void main(String[] args) throws Exception {
        //1.连接数据库，得到Statement对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("file\\jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        // (1)注册驱动
        Class.forName(driver);
        // (2)得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // (3)得到Statement对象
        Statement statement = connection.createStatement();

        //2.执行SELECT语句，返回ResultSet
        String selectSQL = "SELECT * " +
                "FROM `news`";
        ResultSet resultSet = statement.executeQuery(selectSQL);

        //3.通过while循环取出 ResultSet 中的数据
        while (resultSet.next()) {  //让光标向后移动，如果没有更多行则返回 `false`
            int id = resultSet.getInt(1);    //获取当前记录的第一列数据
            String content = resultSet.getString(2);    //获取当前记录的第二列数据
            System.out.println(id + " - " + content);
        }

        //4.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
