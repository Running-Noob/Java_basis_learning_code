package com.f.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author fzy
 * @date 2023/6/23 20:51
 */
public class Collections_Search {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("my");
        list.add("computer");
        System.out.println(list);   //[hello, world, my, computer]

        //1.`max(Collection<? extends T> coll)`������Ԫ�ص���Ȼ˳�򣬷��ظ��������е����Ԫ�ء�
        System.out.println(Collections.max(list));  //world

        //2.`max(Collection<? extends T> coll, Comparator<? super T> comp)`�����ݴ���� `Comparator` ָ����˳�򣬷��ظ��������е����Ԫ�ء�
        //�����ԡ����ַ������ȴ�С����Ϊ��
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));    //computer

        //3.`min(Collection<? extends T> coll)`���� `1.` ���ơ�
        System.out.println(Collections.min(list));  //computer

        //4.`min(Collection<? extends T> coll, Comparator<? super T> comp)`���� `2.` ���ơ�
        System.out.println(Collections.min(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));    //my

        //5.`frequency(Collection<?> c, Object o)`������ָ��������ָ��Ԫ�صĳ��ִ�����
        System.out.println(Collections.frequency(list, "world"));   //1
    }
}
