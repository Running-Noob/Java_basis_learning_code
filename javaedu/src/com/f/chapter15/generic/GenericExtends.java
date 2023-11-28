package com.f.chapter15.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fzy
 * @date 2023/6/30 13:33
 */
public class GenericExtends {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //`List<?>`����ʾ֧�����ⷺ�����͡�
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA>����ʾ֧�� `AA` ���Լ� `AA` ������ࡣ
        // ��ϣ�������list�еĶ��������Ϊ `AA` ��� `AA` �������
        //printCollection2(list1);    //�����
        //printCollection2(list2);    //�����
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);

        //List<? super AA>����ʾ֧�� `AA` ���Լ� `AA` ��ĸ��࣬������ֱ�Ӹ��ࡣ
        // ��ϣ�������list�еĶ��������Ϊ `AA` ��� `AA` ��ĸ��࣬������ֱ�Ӹ���
        printCollection3(list1);
        //printCollection3(list2);    //�����
        printCollection3(list3);
        //printCollection3(list4);    //�����
        //printCollection3(list5);    //�����
    }

    //`<?>`����ʾ֧�����ⷺ�����͡�
    public static void printCollection1(List<?> c) {
        for (Object obj : c) {
            System.out.println(obj);
        }
    }

    //`<? extends A>`����ʾ֧�� `A` ���Լ� `A` ������࣬�涨�˷��͵����ޡ�
    public static void printCollection2(List<? extends AA> c) {
        for (AA aa : c) {
            System.out.println(aa);
        }
    }

    //`<? super A>` ����ʾ֧�� `A` ���Լ� `A` ��ĸ��࣬������ֱ�Ӹ��࣬�涨�˷��͵����ޡ�
    public static void printCollection3(List<? super AA> c) {
        for (Object obj : c) {
            System.out.println(obj);
        }
    }
}

class AA {

}

class BB extends AA {

}

class CC extends BB {

}