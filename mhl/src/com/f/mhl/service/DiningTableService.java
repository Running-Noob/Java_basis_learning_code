package com.f.mhl.service;

import com.f.mhl.dao.DiningTableDAO;
import com.f.mhl.domain.DiningTable;

import java.util.List;

/**
 * @author fzy
 * @date 2023/8/14 15:40
 * 处理DiningTable相关业务逻辑的类
 */
public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌的信息
    public List<DiningTable> listDiningTables() {
        List<DiningTable> diningTables = diningTableDAO.queryMulti("SELECT * FROM dining_table",
                DiningTable.class);
        return diningTables;
    }

    //根据餐桌id，查询对应的餐桌的信息
    public DiningTable getDiningTableById(Integer id) {
        DiningTable diningTable = diningTableDAO.querySingle("SELECT * FROM dining_table WHERE id = ?",
                DiningTable.class, id);
        return diningTable;
    }

    //对餐桌进行预定，更新餐桌的状态
    public boolean orderDiningTable(Integer id, String orderName, String orderTel) {
        int affectedRow = diningTableDAO.dml("UPDATE dining_table SET state = '预定', orderName = ?, orderTel = ? WHERE id = ?",
                orderName, orderTel, id);
        return affectedRow > 0;
    }

    //更新餐桌状态
    public boolean updateDiningTableState(Integer id, String state) {
        int affectRow = diningTableDAO.dml("UPDATE dining_table SET state = ? WHERE id = ?", state, id);
        return affectRow > 0;
    }

    //结账后更新餐桌状态
    public boolean updateDiningTableState2Free(Integer id) {
        int affectedRow = diningTableDAO.dml("UPDATE dining_table SET state = '空闲', orderName = '', orderTel = '' WHERE id = ?",
                id);
        return affectedRow > 0;
    }
}
