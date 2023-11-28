package com.f.mhl.domain;

import java.util.Date;

/**
 * @author fzy
 * @date 2023/8/14 20:36
 * 对应于bill表的Bill类, 该Bill是一个JavaBean
 * CREATE TABLE bill(
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * billId VARCHAR(50) NOT NULL,
 * foodId INT NOT NULL,
 * foodNum INT NOT NULL,
 * price DOUBLE NOT NULL,
 * tableId INT NOT NULL,
 * `date` DATETIME NOT NULL DEFAULT NOW(),
 * state VARCHAR(50) NOT NULL DEFAULT "现金"
 * );
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer foodId;
    private Integer foodNum;
    private Double price;
    private Integer tableId;
    private Date date;
    private String state;

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer foodId, Integer foodNum, Double price, Integer tableId, Date date, String state) {
        this.id = id;
        this.billId = billId;
        this.foodId = foodId;
        this.foodNum = foodNum;
        this.price = price;
        this.tableId = tableId;
        this.date = date;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "\t\t" + foodId + "\t\t\t" + foodNum + "\t\t" + price + "\t\t" + tableId + "\t\t" + date + "\t\t" + state;
    }
}
