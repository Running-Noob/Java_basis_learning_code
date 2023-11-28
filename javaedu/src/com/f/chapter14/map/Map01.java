package com.f.chapter14.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fzy
 * @date 2023/6/21 14:50
 */
public class Map01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("num1", "java");
        map.put("num2", "go");
        map.put("num1", "python");
        map.put("num3", "php");
        map.put(1, "hello");
        map.put(2, "world");
        Set set = map.entrySet();
        System.out.println(set.getClass()); //class java.util.HashMap$EntrySet
        for (Object obj : set) {
            //System.out.println(obj.getClass()); //class java.util.HashMap$Node
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}