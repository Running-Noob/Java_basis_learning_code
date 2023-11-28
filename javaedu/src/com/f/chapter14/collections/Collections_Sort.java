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

        //1.`reverse(List<?> list)`：反转 `List` 中的元素的顺序。
        Collections.reverse(list);
        System.out.println(list);   //[computer, my, world, hello]

        //2.`shuffle(List<?> list)`：对 `List` 集合元素进行随机排序。
        Collections.shuffle(list);
        System.out.println(list);   //[computer, world, hello, my]

        //3.`sort(List<T> list)` ：根据元素的自然顺序对指定 `List` 集合元素按升序排序。
        Collections.sort(list);
        System.out.println(list);   //[computer, hello, my, world]

        //4.`sort(List<T> list, Comparator<? super T> c)` ：通过传入 `Comparator` 来指定排序的方式，对 `List` 集合元素进行排序。
        //下面以”按字符串长度大小排序“为例
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //这里可以加入一些校验代码
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(list);   //[my, hello, world, computer]

        //5.`swap(List<?> list, int i, int j)`：将 `List` 中索引为 `i` 和 `j` 的集合元素对调位置。
        Collections.swap(list, 1, 3);
        System.out.println(list);   //[my, computer, world, hello]
    }
}
