package com.f.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author fzy
 * @date 2023/6/23 20:31
 */
public class Collections_Sort {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("my");
        list.add("computer");
        System.out.println(list);   //[hello, world, my, computer]

        //1.`reverse(List<?> list)`����ת `List` �е�Ԫ�ص�˳��
        Collections.reverse(list);
        System.out.println(list);   //[computer, my, world, hello]

        //2.`shuffle(List<?> list)`���� `List` ����Ԫ�ؽ����������
        Collections.shuffle(list);
        System.out.println(list);   //[computer, world, hello, my]

        //3.`sort(List<T> list)` ������Ԫ�ص���Ȼ˳���ָ�� `List` ����Ԫ�ذ���������
        Collections.sort(list);
        System.out.println(list);   //[computer, hello, my, world]

        //4.`sort(List<T> list, Comparator<? super T> c)` ��ͨ������ `Comparator` ��ָ������ķ�ʽ���� `List` ����Ԫ�ؽ�������
        //�����ԡ����ַ������ȴ�С����Ϊ��
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //������Լ���һЩУ�����
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(list);   //[my, hello, world, computer]

        //5.`swap(List<?> list, int i, int j)`���� `List` ������Ϊ `i` �� `j` �ļ���Ԫ�ضԵ�λ�á�
        Collections.swap(list, 1, 3);
        System.out.println(list);   //[my, computer, world, hello]
    }
}
