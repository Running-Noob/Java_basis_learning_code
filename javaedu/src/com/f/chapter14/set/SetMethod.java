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
        //Setû���ظ�Ԫ�أ���ʹ�ظ�����ˣ�Ҳֻ��һ��
        System.out.println(set);    //[null, 10, hello, true]

        //Set�ı���
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);    //����Ϊ��null, 10, hello, true��Ҳ˵����ȡ��˳�򲻻�ı�
        }
    }
}
