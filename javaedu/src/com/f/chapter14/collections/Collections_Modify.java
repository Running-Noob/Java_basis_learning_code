package com.f.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fzy
 * @date 2023/6/23 21:15
 */
public class Collections_Modify {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("my");
        list.add("computer");
        System.out.println(list);   //[hello, world, my, computer]

        //1.`copy(List<? super T> dest, List<? extends T> src)`：将 `src` 中的内容复制到 `dest` 中。
        List newList = new ArrayList();
        //Collections.copy 函数在进行拷贝之前，会对 src 和 dest 的长度进行判断，如果 src 的长度大于 dest，
        // 就抛出 IndexOutOfBoundsException: Source does not fit in dest 异常
        for (int i = 0; i < list.size(); i++) {
            newList.add("");    //为了使得 dest 的长度不小于 src 的长度
        }
        Collections.copy(newList, list);
        System.out.println(newList);    //[hello, world, my, computer]

        //2.`replaceAll(List<T> list, T oldVal, T newVal)`：使用 `newVal` 替换 `List` 对象的所有 `oldVal`。
        Collections.replaceAll(list, "hello", "hi");
        System.out.println(list);   //[hi, world, my, computer]
    }
}
