package com.f.chapter13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author fzy
 * @date 2023/4/26 14:54
 */
public class ArraysMethod {
    public static void main(String[] args) {
        //1. toString ����������ַ�����ʽ
        int[] arr = {1, 2, 3, 5, 8};
        System.out.println(Arrays.toString(arr));   //[1, 2, 3, 5, 8]

        //2. sort ����(Ĭ������Ͷ�������)
        Integer[] integers1 = {-1, 30, 2, 59, -10};
        Integer[] integers2 = {-1, 30, 2, 59, -10};
        //Ĭ������
        Arrays.sort(integers1);
        System.out.println(Arrays.toString(integers1)); //[-10, -1, 2, 30, 59]
        //��������
        /*
         * ���������˽ӿڱ�̵ķ�ʽ����Դ����Է��֣�
         *   Arrays.sort(T[] a, Comparator<? super T> c) �����
         *   TimSort.sort(a, 0, a.length, c, null, 0, 0); Ȼ���һ������
         *   binarySort(a, lo, hi, lo + initRunLen, c); ���������򣬸÷�����ʹ�õ�������д�� compare ����
         *       if (c.compare(pivot, a[mid]) < 0) �ɴ���ʵ�ֶ�������
         * */
        Arrays.sort(integers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(integers2)); //[59, 30, 2, -1, -10]
        Arrays.sort(integers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        //3. binarySearch ���ֲ��ң�Ҫ������ź���
        //      ���û�ҵ������ص��� return -(low + 1);  // key not found.
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);  //3

        //4. copyOf ����Ԫ�صĸ���
        /*
         * 1. �� arr �����У�����ָ��������Ԫ�ص� newArr ������
         * 2. ��������ĳ��ȴ��� arr.length������������ĺ�������0(����int������˵),null(���ڶ���������˵),false(����boolean������˵)
         * 3. ��������ĳ���С�� 0�����׳� NegativeArraySizeException �쳣
         * */
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr));    //[1, 2, 3, 5, 8, 0]
        Integer[] newIntegers = Arrays.copyOf(integers1, integers1.length + 1);
        System.out.println(Arrays.toString(newIntegers));   //[-10, -1, 2, 30, 59, null]

        //5. fill ����Ԫ�����
        Arrays.fill(arr, 100);  //ʹ�� 100 ȥ��� arr ���飬�������Ϊ�滻����ԭ����Ԫ��
        System.out.println(Arrays.toString(arr));   //[100, 100, 100, 100, 100]

        //6. equals �Ƚ���������Ԫ�������Ƿ���ȫһ��
        //��� integers1 �� integers2 �����Ԫ��һ�����򷵻�true�����򷵻�false
        boolean equals = Arrays.equals(integers1, integers2);
        System.out.println(equals);     //false

        //7. asList ��һ��ֵת��ΪList����
        List intList = Arrays.asList(1, 2, -3, 7, 8);
        System.out.println(intList);    //[1, 2, -3, 7, 8]
    }
}
