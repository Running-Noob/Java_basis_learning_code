package com.f.houserent;

import com.f.houserent.view.HouseView;

/**
 * 应用入口
 */
public class HouseRentApp {
    public static void main(String[] args) {
        new HouseView().mainMenu();
        System.out.println("您退出了房屋出租系统...");
    }
}
