package com.f.chapter21.dao_.test;

import com.f.chapter21.dao_.dao.AccountDAO;
import com.f.chapter21.dao_.domain.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author fzy
 * @date 2023/8/13 20:45
 */
public class TestDAO {
    @Test
    //测试 AccountDAO 对 account 表的 crud 操作
    public void testAccountDAO() {
        AccountDAO accountDAO = new AccountDAO();
        //1.测试查询操作
        // (1)查询多行多列数据
        List<Account> accounts = accountDAO.queryMulti("SELECT * FROM account WHERE id >= ?", Account.class, 1);
        System.out.println(accounts);
        // (2)查询单行多列数据
        Account account = accountDAO.querySingle("SELECT * FROM account WHERE id = ?", Account.class, 1);
        System.out.println(account);
        // (3)查询单行单列数据，即查询单值
        Object name = accountDAO.queryScalar("SELECT name FROM account WHERE id = ?", 1);
        System.out.println(name);

        //2.测试dml操作
        int insertAffectedRows = accountDAO.dml("INSERT INTO account VALUES (null, ?, ?)", "王五", 1000);
        System.out.println(insertAffectedRows > 0 ? "插入成功" : "插入失败");
        int deleteAffectedRows = accountDAO.dml("DELETE FROM account WHERE name = ?", "李四");
        System.out.println(deleteAffectedRows > 0 ? "删除成功" : "删除失败/所要删除的数据不存在");
        int updateAffectedRows = accountDAO.dml("UPDATE account SET balance = ? WHERE name = ?", 20000, "张三");
        System.out.println(updateAffectedRows > 0 ? "更新成功" : "更新失败/所要更新的数据不存在");
    }
}
