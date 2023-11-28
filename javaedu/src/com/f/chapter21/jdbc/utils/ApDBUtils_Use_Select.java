package com.f.chapter21.jdbc.utils;

import com.f.chapter21.jdbc.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fzy
 * @date 2023/8/13 14:10
 * 使用Apache DBUtils工具类 + Druid数据库连接池的方式，完成对 `account` 表的查询
 */
public class ApDBUtils_Use_Select {
    @Test
    public void testDBUtils_Query() throws SQLException {
        //1.使用 Druid 得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用 DBUtils 的类和接口
        //2.使用 QueryRunner 执行查询的操作，将得到的结果存放在 List 中
        QueryRunner queryRunner = new QueryRunner();
        String selectSQL = "SELECT * FROM account WHERE id >= ?";
        //创建了一个Account类，该Account类对应于account表
        // (1)query方法就是执行一个sql语句，得到一个Resultset，并将 ResultSet 封装到 ArrayList 集合中
        // (2)返回该 ArrayList 集合
        // (3)connection：连接
        // (4)selectSQL：执行的查询sql语句
        // (5)new BeanListHandler<>(Account.class)：ResultSet -> Account对象(用反射得到Account类的信息) -> ArrayList
        //     底层使用反射机制获取 Account 类的属性，然后对 ResultSet 进行封装，封装为 Account对象
        // (6)1：传给sql语句中占位符 ? 的参数，可以有多个值，因为是可变参数 Object... params
        // (7)在 query 方法中会关闭 ResultSet 和 PreparedStatement 对象，所以后面无需关闭
        /**
         * query方法源码：
         *     public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         if (conn == null) {
         *             throw new SQLException("Null connection");
         *         } else if (sql == null) {
         *             throw new SQLException("Null SQL statement");
         *         } else if (rsh == null) {
         *             throw new SQLException("Null ResultSetHandler");
         *         } else {
         *             Statement stmt = null;   //定义Statement
         *             ResultSet resultSet = null;  //接收查询得到的ResultSet
         *             T result = null; //最终返回的ArrayList
         *
         *             try {
         *                 if (params != null && params.length > 0) {
         *                     PreparedStatement ps = this.prepareStatement(conn, sql); //得到PreparedStatement
         *                     stmt = ps;
         *                     this.fillStatement(ps, params);  //将sql语句的 ? 填入值
         *                     resultSet = this.wrap(ps.executeQuery());    //得到ResultSet并包装
         *                 } else {
         *                     stmt = conn.createStatement();
         *                     resultSet = this.wrap(((Statement)stmt).executeQuery(sql));
         *                 }
         *
         *                 result = rsh.handle(resultSet);  //进一步包装，包装为ArrayList，在这里用到了反射，对传入的Account.class进行使用
         *             } catch (SQLException var12) {
         *                 this.rethrow(var12, sql, params);
         *             } finally {
         *                 this.closeQuietly(resultSet);    //关闭ResultSet
         *                 this.closeQuietly((Statement)stmt);  //关闭Statement
         *             }
         *
         *             return result;   //返回ArrayList
         *         }
         *     }
         */
        List<Account> queryResult
                = queryRunner.query(connection, selectSQL, new BeanListHandler<>(Account.class), 1);    //1是传给?的值
        System.out.println(queryResult);
        //3.关闭连接，释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
