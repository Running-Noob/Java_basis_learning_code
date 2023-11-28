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
        //1. add����ӵ���Ԫ��
        list.add("hello");
        list.add(10);   //�Զ�װ�䣺list.add(Integer.valueOf(10))
        list.add(true);
        System.out.println(list);   //[hello, 10, true]

        //2. remove��ɾ��ָ��Ԫ��
        Object obj = list.remove(0);                            //ɾ������Ϊ0��Ԫ�أ������ظ�Ԫ��
        System.out.println(obj.getClass());                             //class java.lang.String
        System.out.println(obj);                                        //hello
        boolean result1 = list.remove(Integer.valueOf(10));     //ɾ��ָ��Ԫ�أ�����booleanֵ
        System.out.println("ɾ�����Ϊ��" + result1);                     //ɾ�����Ϊ��true
        System.out.println(list);   //[true]

        //3. contains������Ԫ���Ƿ����
        boolean result2 = list.contains(10);    //�ж� list ���Ƿ���Ԫ�� 10
        System.out.println(result2);            //���ڴ�ʱ list Ϊ [true]�����Խ��Ϊfalse

        //4. size����ȡԪ�صĸ���
        System.out.println(list.size());        //1

        //5. isEmpty���ж��Ƿ�Ϊ��
        System.out.println(list.isEmpty());     //false

        //6. clear�����
        list.clear();
        System.out.println(list);   //[]

        //7. addAll����Ӷ��Ԫ��
        ArrayList novels = new ArrayList();
        novels.add("���μ�");
        novels.add("��������");
        list.addAll(novels);
        System.out.println("list��" + list + " novels��" + novels);   //list��[���μ�, ��������] novels��[���μ�, ��������]

        //8. containsAll�����Ҷ��Ԫ���Ƿ񶼴���
        System.out.println(list.containsAll(novels));   //true

        //9. removeAll��ɾ�����Ԫ��
        list.add("��¥��");
        list.removeAll(novels);
        System.out.println(list);   //[��¥��]

    }
}
