package com.f.chapter21.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/5 21:49
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        //1.连接数据库，得到 PreparedStatement 对象
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
        // (3)传入sql语句，得到PreparedStatement对象
        //      sql语句的 ? 就相当于占位符
        String selectSQL = "SELECT * FROM news WHERE id = ?";
        //该PreparedStatement对象是实现了PreparedStatement接口的类的对象，PreparedStatement是一个接口
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

        //2.通过 PreparedStatement 对象执行 sql 语句，得到执行的结果
        // (1)给 ? 赋值
        preparedStatement.setInt(1, 2);
        // (2)执行sql语句
        //      这里执行查询的时候，不需要再传入sql语句了，
        //      因为在创建PreparedStatement对象时，已经将sql语句和该对象关联起来了。
        //      而且就算传入了sql语句，就相当于
        //      ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM news WHERE id = ?");
        //      语法是错误的，执行也不会成功
        ResultSet resultSet = preparedStatement.executeQuery();

        //3.通过while循环取出 ResultSet 中的数据
        while (resultSet.next()) {  //让光标向后移动，如果没有更多行则返回 `false`
            int id = resultSet.getInt(1);    //获取当前记录的第一列数据
            String content = resultSet.getString(2);    //获取当前记录的第二列数据
            System.out.println(id + " - " + content);
        }

        //4.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
