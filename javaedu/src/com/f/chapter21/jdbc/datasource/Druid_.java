package com.f.chapter21.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/8/12 21:03
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        //1.创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("file\\druid.properties"));
        //2.根据 Properties 对象创建 Druid 数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //3.得到连接池中的数据库连接
        Connection connection = dataSource.getConnection();
        //4.将连接归还给数据库连接池
        connection.close();
    }
}
