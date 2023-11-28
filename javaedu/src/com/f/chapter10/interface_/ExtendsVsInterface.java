package com.f.chapter10.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("С�");
        littleMonkey.climbing();    //����С⨻�����...
        littleMonkey.swimming();    //С�ͨ��ѧϰѧ������Ӿ...
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
        System.out.println("����" + this.name + "������...");
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
        System.out.println(getName() + "ͨ��ѧϰѧ������Ӿ...");
    }
}