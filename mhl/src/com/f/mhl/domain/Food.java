package com.f.mhl.domain;

/**
 * @author fzy
 * @date 2023/8/14 19:43
 * 对应于food表的Food类, 该Food是一个JavaBean
 * CREATE TABLE food(
 * id int PRIMARY KEY auto_increment,
 * `name` VARCHAR(50) UNIQUE NOT NULL,
 * type VARCHAR(50) NOT NULL DEFAULT "",
 * price DOUBLE NOT NULL DEFAULT 0
 * );
 */
public class Food {
    private Integer id;
    private String name;
    private String type;
    private Double price;

    public Food() {
    }

    public Food(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + name + "\t\t" + type + "\t\t" + price;
    }
}
