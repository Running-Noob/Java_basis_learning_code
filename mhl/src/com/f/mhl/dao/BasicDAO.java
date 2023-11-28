package com.f.mhl.dao;

import com.f.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fzy
 * @date 2023/8/13 20:12
 * BasicDAO，是其他DAO的父类
 */
public class BasicDAO<T> {  //泛型指定具体的类型
    private QueryRunner queryRunner = new QueryRunner();

    //通用的dml操作，针对任意的表
    public int dml(String sql, Object... params) {
        //1.获得连接
        Connection connection = null;
        try {
            //2.执行sql语句
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //3.关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 通用的select操作，针对任意的表，返回多行多列数据
     *
     * @param sql    sql语句，可以有?
     * @param clazz  类的Class对象,例如Account.class
     * @param params 传入?的具体的值，可以有多个
     * @return 根据类的类型，返回对应的ArrayList集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        //1.获得连接
        Connection connection = null;
        try {
            //2.执行sql语句
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //3.关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //通用的select操作，针对任意的表，返回单行多列数据
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        //1.获得连接
        Connection connection = null;
        try {
            //2.执行sql语句
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //3.关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //通用的select操作，针对任意的表，返回单行单列数据，即返回单值
    public Object queryScalar(String sql, Object... params) {
        //1.获得连接
        Connection connection = null;
        try {
            //2.执行sql语句
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //3.关闭连接
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
