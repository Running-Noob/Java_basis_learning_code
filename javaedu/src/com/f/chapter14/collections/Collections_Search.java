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

        //1.`max(Collection<? extends T> coll)`：根据元素的自然顺序，返回给定集合中的最大元素。
        System.out.println(Collections.max(list));  //world

        //2.`max(Collection<? extends T> coll, Comparator<? super T> comp)`：根据传入的 `Comparator` 指定的顺序，返回给定集合中的最大元素。
        //下面以”按字符串长度大小排序“为例
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));    //computer

        //3.`min(Collection<? extends T> coll)`：和 `1.` 类似。
        System.out.println(Collections.min(list));  //computer

        //4.`min(Collection<? extends T> coll, Comparator<? super T> comp)`：和 `2.` 类似。
        System.out.println(Collections.min(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));    //my

        //5.`frequency(Collection<?> c, Object o)`：返回指定集合中指定元素的出现次数。
        System.out.println(Collections.frequency(list, "world"));   //1
    }
}
