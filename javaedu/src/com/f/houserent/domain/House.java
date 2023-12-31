package com.f.houserent.domain;

/**
 * House 的一个对象表示一个房屋信息
 */
public class House {
    private int id;
    private String name;
    private String phone;
    private String addr;
    private double rent;
    private String state;

    public House() {
    }

    public House(int id, String name, String phone, String addr, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t" + phone +
                "\t\t" + addr +
                "\t" + rent +
                "\t" + state;
    }
}
