package com.f.chapter10.abstract_;

public class AbstractDetail {
    public static void main(String[] args) {
        Manager m1 = new Manager("王总", "10001", 12000, 10000);
        CommonEmployee ce1 = new CommonEmployee("小王", "11111", 5000);
        m1.work();
        ce1.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + getName() + " 工作中...");
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    public void work() {
        System.out.println("普通员工 " + getName() + " 工作中...");
    }
}