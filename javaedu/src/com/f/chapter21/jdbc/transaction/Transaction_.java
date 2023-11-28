package com.f.chapter21.jdbc.transaction;

import com.f.chapter21.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author fzy
 * @date 2023/8/6 14:50
 * 演示在JDBC中事务的使用
 */
public class Transaction_ {
    @Test
    public void testTransaction_() {
        //1.得到连接
        //Connection在默认情况下是自动提交事务的
        Connection connection = JDBCUtils.getConnection();
        //2.组织sql语句
        String sql1 = "UPDATE account SET balance = balance - 100 WHERE id = 1";
        String sql2 = "UPDATE account SET balance = balance + 100 WHERE id = 2";
        //3.创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            //取消Connection自动提交事务，也是事务开始的地方
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();  //执行第一条sql
            //...
            //可能发生异常，出现程序无法继续运行下去的情况，例如下面的语句
            //int i = 1 / 0;
            //...
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();  //执行第二条sql

            //如果程序正常运行，则可以在这里进行事务的提交
            connection.commit();
        } catch (Exception e) {
            try {
                //可以在这里进行回滚，撤销已经执行的sql
                //默认回滚到事务开始的地方
                System.out.println("发生了异常，撤销执行的sql，进行回滚");
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            //4.关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
