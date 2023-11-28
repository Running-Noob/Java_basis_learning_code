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
        //1. toString 返回数组的字符串形式
        int[] arr = {1, 2, 3, 5, 8};
        System.out.println(Arrays.toString(arr));   //[1, 2, 3, 5, 8]

        //2. sort 排序(默认排序和定制排序)
        Integer[] integers1 = {-1, 30, 2, 59, -10};
        Integer[] integers2 = {-1, 30, 2, 59, -10};
        //默认排序
        Arrays.sort(integers1);
        System.out.println(Arrays.toString(integers1)); //[-10, -1, 2, 30, 59]
        //定制排序
        /*
         * 这里体现了接口编程的方式，看源码可以发现：
         *   Arrays.sort(T[] a, Comparator<? super T> c) 会调用
         *   TimSort.sort(a, 0, a.length, c, null, 0, 0); 然后进一步调用
         *   binarySort(a, lo, hi, lo + initRunLen, c); 二叉树排序，该方法会使用到我们重写的 compare 方法
         *       if (c.compare(pivot, a[mid]) < 0) 由此来实现定制排序
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

        //3. binarySearch 二分查找，要求必须排好序
        //      如果没找到，返回的是 return -(low + 1);  // key not found.
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);  //3

        //4. copyOf 数组元素的复制
        /*
         * 1. 从 arr 数组中，拷贝指定个数个元素到 newArr 数组中
         * 2. 如果拷贝的长度大于 arr.length，就在新数组的后面增加0(对于int数组来说),null(对于对象数组来说),false(对于boolean数组来说)
         * 3. 如果拷贝的长度小于 0，就抛出 NegativeArraySizeException 异常
         * */
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr));    //[1, 2, 3, 5, 8, 0]
        Integer[] newIntegers = Arrays.copyOf(integers1, integers1.length + 1);
        System.out.println(Arrays.toString(newIntegers));   //[-10, -1, 2, 30, 59, null]

        //5. fill 数组元素填充
        Arrays.fill(arr, 100);  //使用 100 去填充 arr 数组，可以理解为替换所有原来的元素
        System.out.println(Arrays.toString(arr));   //[100, 100, 100, 100, 100]

        //6. equals 比较两个数组元素内容是否完全一致
        //如果 integers1 和 integers2 数组的元素一样，则返回true，否则返回false
        boolean equals = Arrays.equals(integers1, integers2);
        System.out.println(equals);     //false

        //7. asList 将一组值转换为List集合
        List intList = Arrays.asList(1, 2, -3, 7, 8);
        System.out.println(intList);    //[1, 2, -3, 7, 8]
    }
}
