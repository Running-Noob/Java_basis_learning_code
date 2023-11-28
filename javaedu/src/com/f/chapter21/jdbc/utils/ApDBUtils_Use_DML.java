package com.f.chapter21.jdbc.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author fzy
 * @date 2023/8/13 15:29
 * 使用Apache DBUtils工具类 + Druid数据库连接池的方式，完成对 `account` 表的DML(insert、delete、update)
 */
public class ApDBUtils_Use_DML {
    @Test
    public void testDBUtils_DML() throws SQLException {
        //1.使用 Druid 得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用 DBUtils 的类和接口
        //2.使用 QueryRunner 执行dml的操作
        // (1)执行dml操作的方法都是 queryRunner.update
        // (2)返回的值是受影响的行数
        QueryRunner queryRunner = new QueryRunner();

        //insert
        String insertSQL = "INSERT INTO account VALUES (null, ?, ?)";
        int insertAffectedRows = queryRunner.update(connection, insertSQL, "王五", 1000);
        System.out.println(insertAffectedRows > 0 ? "插入成功" : "插入失败");

        //delete
        String deleteSQL = "DELETE FROM account WHERE name = ?";
        int deleteAffectedRows = queryRunner.update(connection, deleteSQL, "李四");
        System.out.println(deleteAffectedRows > 0 ? "删除成功" : "删除失败/所要删除的数据不存在");

        //update
        String updateSQL = "UPDATE account SET balance = ? WHERE name = ?";
        int updateAffectedRows = queryRunner.update(connection, updateSQL, 10000, "张三");
        System.out.println(updateAffectedRows > 0 ? "更新成功" : "更新失败/所要更新的数据不存在");

        //3.关闭连接，释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
