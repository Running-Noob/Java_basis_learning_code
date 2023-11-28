package com.f.chapter21.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author fzy
 * @date 2023/8/5 20:21
 */
public class Jdbc02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE news");
        //创建表
        String createTableSql = "CREATE TABLE news ( " +
                "id INT PRIMARY KEY," +
                "content VARCHAR(255) NOT NULL DEFAULT '')";
        boolean createTableResult = statement.execute(createTableSql);  //创建表成功却返回 false
        /*
        * 其实这个不叫问题，是人家返回的一个机制，execute方法执行的语句可以是任何种类的sql语句，
        * 一些特别处理过的语句返回多个结果，execute 方法处理这些复杂的语句；executeQuery 和 executeUpdate 处理形式更简单的语句。
        * execute 方法返回一个 boolean 值，以指示第一个结果的形式。必须调用 getResultSet 或 getUpdateCount 方法来检索结果，
        * 并且必须调用 getMoreResults 移动到任何后面的结果返回：
        * 如果第一个结果是 ResultSet 对象，则返回 true；如果第一个结果是更新计数或者没有结果，则返回 false，
        * 意思就是如果是查询的话返回true，如果是更新或插入的话就返回false了；
        * execute()返回的是一个boolean值,代表两种不同的操作啊,getResultSet()返回的是结果集,而getUpdateCount()返回的是更新的记数。
        * */
        System.out.println(createTableResult ? "创建表成功" : "创建表失败");
        System.out.println(createTableResult);  //false
        //增加记录
        String insertSql = "INSERT INTO news VALUES " +
                "(1, '北京新闻'), " +
                "(2, '上海新闻'), " +
                "(3, '深圳新闻'), " +
                "(4, '广州新闻'), " +
                "(5, '杭州新闻')";
        int insertResult = statement.executeUpdate(insertSql);
        System.out.println(insertResult > 0 ? "增加记录成功" : "增加记录失败");
        System.out.println(insertResult);
        //修改记录
        String updateSql = "UPDATE news SET content = '南京新闻' " +
                "WHERE id = 1";
        int updateResult = statement.executeUpdate(updateSql);
        System.out.println(updateResult > 0 ? "修改记录成功" : "修改记录失败");
        System.out.println(updateResult);
        //删除记录
        String deleteSql = "DELETE FROM news WHERE id = 3";
        int deleteResult = statement.executeUpdate(deleteSql);
        System.out.println(deleteResult > 0 ? "删除记录成功" : "删除记录失败");
        System.out.println(deleteResult);
    }
}
