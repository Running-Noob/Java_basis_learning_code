package com.f.mhl.service;

import com.f.mhl.dao.BillDAO;
import com.f.mhl.domain.Bill;
import com.f.mhl.domain.Food;

import java.util.List;
import java.util.UUID;

/**
 * @author fzy
 * @date 2023/8/14 20:40
 * 处理Bill相关业务逻辑的类
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    private FoodService foodService = new FoodService();
    private DiningTableService diningTableService = new DiningTableService();

    //点餐，生成账单，并更新对应餐桌的状态
    public boolean order(Integer foodId, Integer foodNum, Integer tableId) {
        //生成一个账单号
        String billId = UUID.randomUUID().toString();
        //生成账单，插入到bill表
        Food food = foodService.getFoodById(foodId);
        int affectRow = billDAO.dml("INSERT INTO bill VALUES(null, ?, ?, ?, ?, ?, DEFAULT, '未结账')",
                billId, foodId, foodNum, food.getPrice() * foodNum, tableId);
        //更新对应餐桌状态
        diningTableService.updateDiningTableState(tableId, "用餐中");
        return affectRow > 0;
    }

    //返回所有的账单
    public List<Bill> listBills() {
        return billDAO.queryMulti("SELECT * FROM bill", Bill.class);
    }

    //查看某个餐桌是否还有未结账的账单
    public boolean hasPayBillByDiningTableId(Integer tableId) {
        List<Bill> bills = billDAO.queryMulti("SELECT * FROM bill WHERE tableId = ? AND state = '未结账'",
                Bill.class, tableId);
        return !bills.isEmpty();
    }

    //对餐桌进行结账
    public boolean payBillByDiningTableId(Integer tableId, String state) {
        //1.对账单的状态进行更新
        int updateBill = billDAO.dml("UPDATE bill SET state = ? WHERE tableId = ? AND state = '未结账'", state, tableId);
        if (updateBill <= 0) {
            return false;
        }
        //2.对餐桌的状态进行更新
        boolean updateDiningTable = diningTableService.updateDiningTableState2Free(tableId);
        return updateDiningTable;
    }
}
