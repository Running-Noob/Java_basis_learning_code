package com.f.chapter14.set;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author fzy
 * @date 2023/6/23 9:57
 */
public class TreeSet01 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1-(Integer)o2;  //ÉýÐò(Ä¬ÈÏ)
                //return ((String)o2).compareTo((String)o1);  //½µÐò
            }
        });
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(1);
        System.out.println(treeSet);
    }
}
