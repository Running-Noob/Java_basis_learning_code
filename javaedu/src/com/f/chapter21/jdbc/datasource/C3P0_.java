package com.f.chapter21.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/7 21:26
 * 演示C3P0数据库连接池的使用
 */
public class C3P0_ {
    @Test
    //方式1：相关参数在程序中指定，如 user、password、url等
    public void testC3P0_01() throws Exception {
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件获取相关的连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("file\\jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //3.手动给数据源 comboPooledDataSource 设置相关的参数
        //  连接是由 comboPooledDataSource 来管理的
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setInitialPoolSize(10);   //初始化连接数为 10 个
        comboPooledDataSource.setMaxPoolSize(50);       //设置连接池的最大连接数为 50 个
        //4.得到连接池中的数据库连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("第一种方式连接成功，其中一个连接为 " + connection);
        //5.将连接归还给数据库连接池
        connection.close();
    }

    @Test
    //方式2：使用配置文件模板来完成
    public void testC3P0_02() throws Exception {
        //1.将 C3P0 提供的 c3p0-config.xml 配置文件放在项目的 src 目录下
        //  在文件中指定连接数据库和连接池的相关参数
        //2.创建一个数据源对象，将配置文件中对应的数据源的名称作为参数传入
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mySource");
        //3.得到连接池中的数据库连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("第二种方式连接成功，其中一个连接为 " + connection);
        //4.将连接归还给数据库连接池
        connection.close();
    }
}