package com.f.chapter14.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fzy
 * @date 2023/4/29 14:28
 */
public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        //1. add：添加单个元素
        list.add("hello");
        list.add(10);   //自动装箱：list.add(Integer.valueOf(10))
        list.add(true);
        System.out.println(list);   //[hello, 10, true]

        //2. remove：删除指定元素
        Object obj = list.remove(0);                            //删除索引为0的元素，并返回该元素
        System.out.println(obj.getClass());                             //class java.lang.String
        System.out.println(obj);                                        //hello
        boolean result1 = list.remove(Integer.valueOf(10));     //删除指定元素，返回boolean值
        System.out.println("删除结果为：" + result1);                     //删除结果为：true
        System.out.println(list);   //[true]

        //3. contains：查找元素是否存在
        boolean result2 = list.contains(10);    //判断 list 中是否含有元素 10
        System.out.println(result2);            //由于此时 list 为 [true]，所以结果为false

        //4. size：获取元素的个数
        System.out.println(list.size());        //1

        //5. isEmpty：判断是否为空
        System.out.println(list.isEmpty());     //false

        //6. clear：清空
        list.clear();
        System.out.println(list);   //[]

        //7. addAll：添加多个元素
        ArrayList novels = new ArrayList();
        novels.add("西游记");
        novels.add("三国演义");
        list.addAll(novels);
        System.out.println("list：" + list + " novels：" + novels);   //list：[西游记, 三国演义] novels：[西游记, 三国演义]

        //8. containsAll：查找多个元素是否都存在
        System.out.println(list.containsAll(novels));   //true

        //9. removeAll：删除多个元素
        list.add("红楼梦");
        list.removeAll(novels);
        System.out.println(list);   //[红楼梦]

    }
}
