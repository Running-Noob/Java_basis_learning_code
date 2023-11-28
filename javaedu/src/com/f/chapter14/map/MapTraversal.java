package com.f.chapter14.map;

import java.util.*;

/**
 * @author fzy
 * @date 2023/6/22 10:50
 */
public class MapTraversal {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("num1", "三国演义");
        map.put("num2", "石头记");
        map.put("num2", "红楼梦"); //“红楼梦”替换了“石头记”
        map.put("num3", "水浒传");
        map.put("num4", "西游记");
        map.put(null, "四大名著");

        //1.先取出所有的 Key，再通过 Key 取出对应的 Value (增强for)
        System.out.println("---------第一种方式---------");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }

        //2.先取出所有的 Key，再通过 Key 取出对应的 Value (迭代器iterator)
        System.out.println("---------第二种方式---------");
        Iterator keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            System.out.println(key + " - " + map.get(key));
        }

        //3.只取出所有的 Value (增强for)
        System.out.println("---------第三种方式---------");
        Collection values = map.values();
        for (Object val : values) {
            System.out.println(val);
        }

        //4.只取出所有的 Value (迭代器iterator)
        System.out.println("---------第四种方式---------");
        Iterator valIterator = values.iterator();
        while (valIterator.hasNext()) {
            Object val = valIterator.next();
            System.out.println(val);
        }

        //5.通过 EntrySet 来获取 k-v (增强for)
        System.out.println("---------第五种方式---------");
        Set entrySet = map.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        //6.通过 EntrySet 来获取 k-v (迭代器iterator)
        System.out.println("---------第六种方式---------");
        Iterator entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) entryIterator.next();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
