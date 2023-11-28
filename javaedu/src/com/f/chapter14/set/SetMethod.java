package com.f.chapter14.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author fzy
 * @date 2023/5/2 12:35
 */
public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        System.out.println(set.add("hello"));   //true
        System.out.println(set.add("hello"));   //false
        set.add(10);
        set.add(10);
        set.add(true);
        set.add(null);
        //Set没有重复元素，即使重复添加了，也只有一个
        System.out.println(set);    //[null, 10, hello, true]

        //Set的遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);    //依次为：null, 10, hello, true。也说明了取出顺序不会改变
        }
    }
}
