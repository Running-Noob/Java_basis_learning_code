package com.f.chapter14.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author fzy
 * @date 2023/6/22 20:31
 */
public class HashMapSourceCode {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        for (int i = 0; i < 12; i++) {
            hashMap.put(new A(1), "hello");
        }
        System.out.println(hashMap);
    }
}

class A {
    private int i;

    public A(int i) {
        this.i = i;
    }


    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }
}
