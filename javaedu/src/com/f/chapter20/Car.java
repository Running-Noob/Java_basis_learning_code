package com.f.chapter20;

/**
 * @author fzy
 * @date 2023/7/24 19:50
 */
public class Car {
    public String brand = "宝马";
    protected double price = 500000;
    String color = "red";
    private double speed = 50;

    public Car() {
    }

    protected Car(String brand) {
    }

    Car(String brand, double price) {
    }

    private Car(String brand, double price, String color) {
    }

    public void m1() {

    }

    protected void m2() {

    }

    void m3() {

    }

    private void m4() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }
}
