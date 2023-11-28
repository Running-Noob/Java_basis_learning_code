package com.f.houserent.view;

import com.f.houserent.domain.House;
import com.f.houserent.service.HouseService;

import java.util.Scanner;

/**
 * 1.显示菜单界面
 * 2.接收用户输入
 * 3.调用 HouseService 完成对房屋信息的各种操作
 */
public class HouseView {

    Scanner scanner = new Scanner(System.in);
    private boolean flag = true;
    private String choice;

    private HouseService houseService = new HouseService(3);

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("------------房屋出租系统------------");
            System.out.println("\t\t\t1.新 增 房 源");
            System.out.println("\t\t\t2.查 找 房 屋");
            System.out.println("\t\t\t3.删 除 房 屋");
            System.out.println("\t\t\t4.修 改 房 屋 信 息");
            System.out.println("\t\t\t5.房 屋 列 表");
            System.out.println("\t\t\t6.退      出");
            System.out.print("请选择(1 - 6)：");
            choice = scanner.next();
            switch (choice) {
                case "1":   //新增房源
                    CreateHouse();
                    break;
                case "2":   //查找房屋
                    RetrieveHouse();
                    break;
                case "3":   //删除房屋
                    DeleteHouse();
                    break;
                case "4":   //修改房屋信息
                    UpdateHouse();
                    break;
                case "5":   //房屋列表
                    ListHouses();
                    break;
                case "6":   //退出
                    flag = false;
                    break;
                default:
                    System.out.println("您输入的不是 1 - 6，请重新输入\n");
            }
        } while (flag);
    }

    //新增房源
    public void CreateHouse() {
        System.out.println("------------添加房屋信息------------");
        House houseNew = new House();
        System.out.print("姓名：");
        houseNew.setName(scanner.next());
        System.out.print("电话：");
        houseNew.setPhone(scanner.next());
        System.out.print("地址：");
        houseNew.setAddr(scanner.next());
        System.out.print("月租：");
        houseNew.setRent(scanner.nextDouble());
        System.out.print("状态（未出租/已出租）：");
        houseNew.setState(scanner.next());
        if (houseService.Create(houseNew)) {
            System.out.println("------------添加完成------------\n");
        } else {
            System.out.println("------------添加失败------------\n");
        }
    }

    //查找房屋
    public void RetrieveHouse() {
        System.out.println("------------查找房屋信息------------");
        System.out.print("请输入要查找的房屋 id：");
        int searchID = scanner.nextInt();
        House searchHouse = houseService.Retrieve(searchID);
        if (searchHouse == null) {
            System.out.println("------------没有该房屋------------\n");
        } else {
            System.out.println(searchHouse);
            System.out.println();
        }
    }

    //删除房屋
    public void DeleteHouse() {
        System.out.println("------------删除房屋信息------------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int deleteChoice = scanner.nextInt();
        if (deleteChoice == -1) {
            System.out.println("放弃删除房屋信息...\n");
            return;
        }
        System.out.println("确认是否删除(Y/N)：请小心选择：");
        System.out.print("请输入你的选择(Y/N)");
        String confirm;
        do {
            confirm = scanner.next();
            if (confirm.equals("y") || confirm.equals("Y")) {
                if (houseService.Delete(deleteChoice)) {
                    System.out.println("------------删除成功------------\n");
                } else {
                    System.out.println("------------删除失败------------\n");
                }
                break;
            } else if (confirm.equals("n") || confirm.equals("N")) {
                System.out.println("放弃删除房屋信息...\n");
                break;
            } else {
                System.out.print("输入不规范，请重新输入(Y/N)：");
            }
        } while (true);
    }

    //修改房屋信息
    public void UpdateHouse() {
        System.out.println("------------修改房屋信息------------");
        System.out.print("请输入待修改的房屋的编号(-1退出)：");
        int updateID = scanner.nextInt();
        if (updateID == -1) {
            System.out.println("放弃修改房屋信息...\n");
            return;
        }
        //用 Retrieve 方法得到要修改的房屋，进行修改
        House updateHouse = houseService.Retrieve(updateID);
        if (updateHouse == null) {
            System.out.println("所选择的房屋不存在...");
            System.out.println("------------修改失败------------\n");
        } else {
            System.out.print("姓名" + "(" + updateHouse.getName() + ")：");
            updateHouse.setName(scanner.next());
            System.out.print("电话" + "(" + updateHouse.getPhone() + ")：");
            updateHouse.setPhone(scanner.next());
            System.out.print("地址" + "(" + updateHouse.getAddr() + ")：");
            updateHouse.setAddr(scanner.next());
            System.out.print("月租" + "(" + updateHouse.getRent() + ")：");
            updateHouse.setRent(scanner.nextDouble());
            System.out.print("状态" + "(" + updateHouse.getState() + ")：");
            updateHouse.setState(scanner.next());
            System.out.println("------------修改完成------------\n");
        }
    }

    //房屋列表
    public void ListHouses() {
        System.out.println("------------房屋列表------------");
        System.out.println("编号" + "\t\t" + "房主" + "\t\t" + "电话" + "\t\t" + "地址" + "\t\t"
                + "月租" + "\t\t" + "状态（未出租/已出租）");
        House[] houses = houseService.List();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("-----------房屋列表完成-----------\n");
    }
}
