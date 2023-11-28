package com.f.chapter10.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("小猕");
        littleMonkey.climbing();    //猴子小猕会爬树...
        littleMonkey.swimming();    //小猕通过学习学会了游泳...
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void climbing() {
        System.out.println("猴子" + this.name + "会爬树...");
    }
}

interface Fishable {
    void swimming();
}

class LittleMonkey extends Monkey implements Fishable {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "通过学习学会了游泳...");
    }
}