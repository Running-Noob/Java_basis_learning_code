package com.f.chapter21.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fzy
 * @date 2023/8/12 21:37
 */
public class JDBCUtilsByDruid_Use {
    @Test
    public void testDML() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //System.out.println(connection.getClass());  //class com.alibaba.druid.pool.DruidPooledConnection
        //2.组织一个dml sql语句
        String insertSQL = "INSERT INTO test_table VALUES (?, ?)";
        //3.创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertSQL);
            //给占位符 ? 赋值
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "北京新闻");
            //执行dml sql语句
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //4.关闭资源
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void testSelect() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.组织一个select sql语句
        String selectSQL = "SELECT * FROM test_table WHERE id = ?";
        //3.创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        //4.创建ResultSet对象
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(selectSQL);
            //给占位符 ? 赋值
            preparedStatement.setInt(1, 1);
            //执行select sql语句，得到 ResultSet 结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //5.关闭资源
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
