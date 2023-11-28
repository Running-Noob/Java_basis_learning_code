package com.f.chapter14.set;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author fzy
 * @date 2023/5/3 12:41
 */
public class HashSetSourceCode {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("go");
        hashSet.add("java");
        System.out.println("hashSet = " + hashSet);
    }
}