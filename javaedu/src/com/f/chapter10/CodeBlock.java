package com.f.chapter10;

public class CodeBlock {
    public static void main(String[] args) {
        Movie movie = new Movie("���˽�̽��");
        Movie movie2 = new Movie("���˽�̽��2", 100);
    }
}

class Movie {
    private String name;
    private double price;

    {
        System.out.println("��Ӱ��ʼ...");
    }

    public Movie(String name) {
        System.out.println("��һ��������������...");
        this.name = name;
    }

    public Movie(String name, double price) {
        System.out.println("�ڶ���������������...");
        this.name = name;
        this.price = price;
    }
}