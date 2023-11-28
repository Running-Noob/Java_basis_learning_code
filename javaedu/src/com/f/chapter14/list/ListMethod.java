package com.f.chapter14.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * @author fzy
 * @date 2023/4/30 14:13
 */
public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add(10);
        list.add(true);
        System.out.println(list);   //[hello, 10, true]

        //1. add：在index位置插入ele元素
        list.add(1, "world!");  //在索引为1的地方插入字符串"world!"
        System.out.println(list);   //[hello, world!, 10, true]

        //2. addAll：从index位置开始，插入eles所有元素
        Collection collection = new ArrayList();
        collection.add(80);
        collection.add("java");
        list.addAll(1, collection); //从索引为1的地方开始，插入collection的所有元素
        System.out.println(list);   //[hello, 80, java, world!, 10, true]

        //3. get：获取指定索引位置的元素
        System.out.println(list.get(0));    //hello

        //4. indexOf：返回obj在集合中首次出现的位置，如果没有则返回-1
        list.add("hello");
        System.out.println(list);   //[hello, 80, java, world!, 10, true, hello]
        System.out.println(list.indexOf("hello"));  //0

        //5. lastIndexOf：返回obj在当前集合中末次出现的位置，如果没有则返回-1
        System.out.println(list.lastIndexOf("hello"));  //6

        //6. remove：移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(1)); //80（类型为Integer）

        //7. set：设置指定index位置的元素为ele，相当于是替换
        System.out.println(list);   //[hello, java, world!, 10, true, hello]
        list.set(3, "三体");
        System.out.println(list);   //[hello, java, world!, 三体, true, hello]

        //8. subList：返回从fromIndex到toIndex位置的子集和，[fromIndex, toIndex)
        List subList = list.subList(1, 4);
        System.out.println(subList);    //[java, world!, 三体]
    }
}
