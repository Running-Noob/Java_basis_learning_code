package com.f.chapter21.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/4 19:21
 * JDBC 的快速入门
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();   //创建驱动对象

        //2.获取连接
        // (1) jdbc:mysql:// 是规定好的，用来表示协议。通过 jdbc 的方式连接 mysql
        // (2) localhost 表示主机，可以是 ip 地址
        // (3) 3306 表示 mysql 监听的端口
        // (4) java_db 表示连接到 MySQL DBMS 的 java_db 数据库
        //MySQL 连接的本质就是前面学过的 Socket 连接
        String url = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
        //将用户名和密码放入到 Properties 对象中
        Properties properties = new Properties();
        // user 和 password 关键字是规定好的，不要乱写
        properties.setProperty("user", "root"); //用户
        properties.setProperty("password", "123456");   //密码
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        String sql = "INSERT INTO test_table VALUES (100, 'tom')";
        //Statement 对象用于执行静态 SQL 语句并返回其生成的结果的对象。
        Statement statement = connect.createStatement();    //statement是帮我们执行sql语句的
        int rows = statement.executeUpdate(sql);    //如果是dml语句，返回的就是影响的行数
        System.out.println(rows > 0 ? "sql语句执行成功" : "sql语句执行失败");

        //4.关闭连接，释放资源
        statement.close();
        connect.close();
    }
}
