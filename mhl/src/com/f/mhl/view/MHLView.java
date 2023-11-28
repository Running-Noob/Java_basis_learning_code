package com.f.mhl.view;

import com.f.mhl.domain.Bill;
import com.f.mhl.domain.DiningTable;
import com.f.mhl.domain.Employee;
import com.f.mhl.domain.Food;
import com.f.mhl.service.BillService;
import com.f.mhl.service.DiningTableService;
import com.f.mhl.service.EmployeeService;
import com.f.mhl.service.FoodService;
import com.f.mhl.utils.Utility;

import java.util.List;

/**
 * @author fzy
 * @date 2023/8/14 13:41
 * 满汉楼主界面
 */
public class MHLView {
    private boolean loop = true;    //控制是否退出满汉楼
    private String key = "";  //接收用户的选择
    private EmployeeService employeeService = new EmployeeService();    //创建EmployeeService对象
    private DiningTableService diningTableService = new DiningTableService();    //创建DiningTableService对象
    private FoodService foodService = new FoodService();    //创建MenuService对象
    private BillService billService = new BillService();    //创建BillService对象


    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //显示主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("========满汉楼(一级菜单)========");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入员工号: ");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密 码: ");
                    String empPwd = Utility.readString(32);
                    //到数据库判断员工号和密码是否合法
                    Employee employee = employeeService.verification(empId, empPwd);
                    if (employee != null) {  //返回不为null表示员工号和密码合法
                        System.out.println("用户 " + employee.getName() + " 登陆成功!");
                        secondaryMenu();
                    } else {
                        System.out.println("用户名或密码错误, 登录失败...");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误, 请重新输入");
            }
        }
        System.out.println("退出满汉楼系统...");
    }

    //显示二级菜单
    public void secondaryMenu() {
        while (loop) {
            System.out.println("========满汉楼(二级菜单)========");
            System.out.println("\t\t 1 显示餐桌状态");
            System.out.println("\t\t 2 预定餐桌");
            System.out.println("\t\t 3 显示所有菜品");
            System.out.println("\t\t 4 点餐服务");
            System.out.println("\t\t 5 查看账单");
            System.out.println("\t\t 6 结账");
            System.out.println("\t\t 9 退出满汉楼");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    listTableState();
                    break;
                case "2":
                    orderDiningTable();
                    break;
                case "3":
                    listMenuFoods();
                    break;
                case "4":
                    order();
                    break;
                case "5":
                    listBills();
                    break;
                case "6":
                    payBill();
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误, 请重新输入");
            }
        }
    }

    //显示所有餐桌状态
    public void listTableState() {
        List<DiningTable> list = diningTableService.listDiningTables();
        System.out.println("餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable.getId() + "\t\t\t" + diningTable.getState());
        }
        System.out.println("==========显示完毕==========");
    }

    //预定餐桌
    public void orderDiningTable() {
        System.out.println("==========预定餐桌==========");
        System.out.print("请选择要预定的餐桌编号(-1表示退出预定): ");
        int id = Utility.readInt();
        if (id == -1) {
            System.out.println("==========取消预定餐桌==========");
            return;
        }
        char confirm = Utility.readConfirmSelection();
        if (confirm == 'N') {
            System.out.println("==========取消预定餐桌==========");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableById(id);
        if (diningTable == null) {
            System.out.println("所要预定的餐桌不存在...");
            return;
        }
        if (!diningTable.getState().equals("空闲")) {
            System.out.println("所要预定的餐桌已经被预定了!");
            return;
        }
        System.out.print("预定人名字: ");
        String orderName = Utility.readString(50);
        System.out.print("预定人电话: ");
        String orderTel = Utility.readString(20);
        boolean success = diningTableService.orderDiningTable(id, orderName, orderTel);
        if (success) {
            System.out.println("预定成功");
        } else {
            System.out.println("预定失败, 请重试");
        }
    }

    //显示菜单上的所有食品
    public void listMenuFoods() {
        List<Food> list = foodService.listMenuFoods();
        System.out.println("菜品编号\t\t菜品名称\t\t类别\t\t价格");
        for (Food food : list) {
            System.out.println(food);
        }
        System.out.println("==========显示完毕==========");
    }

    //点餐
    public void order() {
        System.out.println("==========点餐服务==========");
        System.out.print("请选择点餐的桌号(-1退出): ");
        int tableId = Utility.readInt();
        if (tableId == -1) {
            System.out.println("==========取消点餐==========");
            return;
        }
        //对餐桌的合法性的校验
        DiningTable diningTable = diningTableService.getDiningTableById(tableId);
        if (diningTable == null) {
            System.out.println("所要点餐的餐桌不存在...");
            return;
        }
        System.out.print("请选择菜品编号(-1退出): ");
        int foodId = Utility.readInt();
        if (foodId == -1) {
            System.out.println("==========取消点餐==========");
            return;
        }
        //对菜品的合法性的校验
        Food food = foodService.getFoodById(foodId);
        if (food == null) {
            System.out.println("所点的菜品不存在...");
            return;
        }
        System.out.print("请选择菜品数量(-1退出): ");
        int foodNum = Utility.readInt();
        if (foodNum == -1) {
            System.out.println("==========取消点餐==========");
            return;
        }
        char confirm = Utility.readConfirmSelection();
        if (confirm == 'N') {
            System.out.println("==========取消点餐==========");
            return;
        }
        boolean success = billService.order(foodId, foodNum, tableId);
        if (success) {
            System.out.println("点餐成功");
        } else {
            System.out.println("点餐失败, 请重试");
        }
    }

    //显示所有账单
    public void listBills() {
        List<Bill> bills = billService.listBills();
        System.out.println("编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        System.out.println("==========显示完毕==========");
    }

    //结账
    public void payBill() {
        System.out.println("==========结账服务==========");
        System.out.print("请选择要结账的餐桌编号(-1表示退出): ");
        int id = Utility.readInt();
        if (id == -1) {
            System.out.println("==========取消结账服务==========");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableById(id);
        if (diningTable == null) {
            System.out.println("所要结账的餐桌不存在...");
            return;
        }
        if (!billService.hasPayBillByDiningTableId(id)) {
            System.out.println("所要结账的餐桌没有未结账账单...");
            return;
        }
        System.out.print("结账的方式(现金/支付宝/微信) 回车表示退出: ");
        String state = Utility.readString(50, "");
        if (state.equals("")) {
            System.out.println("==========取消结账服务==========");
            return;
        }
        char confirm = Utility.readConfirmSelection();
        if (confirm == 'N') {
            System.out.println("==========取消结账服务==========");
            return;
        }
        boolean success = billService.payBillByDiningTableId(id, state);
        if (success) {
            System.out.println("结账成功");
        } else {
            System.out.println("结账失败, 请重试");
        }
    }
}
