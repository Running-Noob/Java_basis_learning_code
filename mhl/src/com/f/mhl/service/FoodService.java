package com.f.mhl.service;

import com.f.mhl.dao.FoodDAO;
import com.f.mhl.domain.Food;

import java.util.List;

/**
 * @author fzy
 * @date 2023/8/14 19:46
 * 处理Menu相关业务逻辑的类
 */
public class FoodService {
    private FoodDAO foodDAO = new FoodDAO();

    //返回菜单上所有食品的信息
    public List<Food> listMenuFoods() {
        return foodDAO.queryMulti("SELECT * FROM food", Food.class);
    }

    //根据菜品id，查询对应的菜品的信息
    public Food getFoodById(Integer id) {
        return foodDAO.querySingle("SELECT * FROM food WHERE id = ?", Food.class, id);
    }
}
