package com.f.mhl.domain;

/**
 * @author fzy
 * @date 2023/8/14 15:38
 * 对应于dining_table表的DiningTable类, 该DiningTable是一个JavaBean
 * CREATE TABLE dining_table(
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * state VARCHAR(50) NOT NULL DEFAULT "空闲",
 * orderName VARCHAR(50) NOT NULL DEFAULT "",
 * orderTel VARCHAR(20) NOT NULL
 * );
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }
}
