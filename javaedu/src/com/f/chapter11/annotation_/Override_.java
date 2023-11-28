package com.f.chapter11.annotation_;

public class Override_ {
}

class Father {
    public void fly() {
        System.out.println("Father's fly...");
    }
}

class Son extends Father {
    @Override
    public void fly() {
        System.out.println("Son's fly...");
    }

}