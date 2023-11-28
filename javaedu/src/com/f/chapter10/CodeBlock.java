package com.f.chapter10;

public class CodeBlock {
    public static void main(String[] args) {
        Movie movie = new Movie("唐人街探案");
        Movie movie2 = new Movie("唐人街探案2", 100);
    }
}

class Movie {
    private String name;
    private double price;

    {
        System.out.println("电影开始...");
    }

    public Movie(String name) {
        System.out.println("第一个构造器被调用...");
        this.name = name;
    }

    public Movie(String name, double price) {
        System.out.println("第二个构造器被调用...");
        this.name = name;
        this.price = price;
    }
}