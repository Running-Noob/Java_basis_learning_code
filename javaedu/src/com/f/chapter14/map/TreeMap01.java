package com.f.chapter14.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author fzy
 * @date 2023/6/23 10:41
 */
public class TreeMap01 {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });

        treeMap.put("d","aaa");
        treeMap.put("a","aaa");
        treeMap.put("c","aaa");
        treeMap.put("e","aaa");
        treeMap.put("f","aaa");

        treeMap.put("b","bbb");

        System.out.println(treeMap);
    }
}
