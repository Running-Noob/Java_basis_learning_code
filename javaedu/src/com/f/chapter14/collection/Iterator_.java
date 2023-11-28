package com.f.chapter14.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fzy
 * @date 2023/4/29 16:32
 */
public class Iterator_ {
    public static void main(String[] args) {
        List books = new ArrayList();
        books.add(new Book("��������", 9.9));
        books.add(new Book("���μ�", 19.9));
        books.add(new Book("ˮ䰴�", 29.9));
        Iterator iterator = books.iterator();   //�õ����϶�Ӧ�ĵ�����iterator
        while (iterator.hasNext()) {    //�ж��Ƿ���Ԫ��
            Object obj = iterator.next();   //������һ��Ԫ�أ�����Ϊ Object
            System.out.println(obj);
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
