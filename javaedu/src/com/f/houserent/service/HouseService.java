package com.f.houserent.service;

import com.f.houserent.domain.House;

import java.util.Scanner;

/**
 * 响应 HouseView 的调用，完成对房屋信息的各种操作（增删改查）
 */
public class HouseService {

    Scanner scanner = new Scanner(System.in);
    private House[] houses;
    private static int houseID = 1;     //房屋编号，和房屋在数组中的下标没有必然的联系
    private static int occupation = 0;  //已经在数组中占有的位置数

    public HouseService(int size) {
        houses = new House[size];
    }

    //新增房源
    public boolean Create(House house) {
        if (occupation >= houses.length) {
            System.out.println("空间已满，不能再添加了...");
            return false;
        }
        houses[occupation++] = house;   //占有位置数加一
        house.setId(houseID++);         //编号加一，由系统完成
        return true;
    }

    //查找房屋
    public House Retrieve(int searchID) {
        for (int i = 0; i < occupation; i++) {
            if (searchID == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //删除房屋
    public boolean Delete(int id) {
        int index = -1;
        //找到要删除的房屋
        for (int i = 0; i < occupation; i++) {
            if (id == houses[i].getId()) {
                index = i;      //找到要删除的房屋信息在数组空间中的下标
            }
        }
        if (index == -1) {
            System.out.println("输入的 id 所对应的房屋信息不存在");
            return false;
        }
        //删除的房屋信息所在的空间应该让出来
        for (int i = index; i < occupation - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[occupation - 1] = null;  //最后刚空出来的位置应该置空
        occupation--;   //占有位置数减一
        return true;
    }

    ////修改房屋信息
    //public void Update(int updateID) {
    //}

    //房屋列表
    public House[] List() {
        return houses;
    }
}