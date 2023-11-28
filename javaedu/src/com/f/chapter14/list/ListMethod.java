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

        //1. add����indexλ�ò���eleԪ��
        list.add(1, "world!");  //������Ϊ1�ĵط������ַ���"world!"
        System.out.println(list);   //[hello, world!, 10, true]

        //2. addAll����indexλ�ÿ�ʼ������eles����Ԫ��
        Collection collection = new ArrayList();
        collection.add(80);
        collection.add("java");
        list.addAll(1, collection); //������Ϊ1�ĵط���ʼ������collection������Ԫ��
        System.out.println(list);   //[hello, 80, java, world!, 10, true]

        //3. get����ȡָ������λ�õ�Ԫ��
        System.out.println(list.get(0));    //hello

        //4. indexOf������obj�ڼ������״γ��ֵ�λ�ã����û���򷵻�-1
        list.add("hello");
        System.out.println(list);   //[hello, 80, java, world!, 10, true, hello]
        System.out.println(list.indexOf("hello"));  //0

        //5. lastIndexOf������obj�ڵ�ǰ������ĩ�γ��ֵ�λ�ã����û���򷵻�-1
        System.out.println(list.lastIndexOf("hello"));  //6

        //6. remove���Ƴ�ָ��indexλ�õ�Ԫ�أ������ش�Ԫ��
        System.out.println(list.remove(1)); //80������ΪInteger��

        //7. set������ָ��indexλ�õ�Ԫ��Ϊele���൱�����滻
        System.out.println(list);   //[hello, java, world!, 10, true, hello]
        list.set(3, "����");
        System.out.println(list);   //[hello, java, world!, ����, true, hello]

        //8. subList�����ش�fromIndex��toIndexλ�õ��Ӽ��ͣ�[fromIndex, toIndex)
        List subList = list.subList(1, 4);
        System.out.println(subList);    //[java, world!, ����]
    }
}
