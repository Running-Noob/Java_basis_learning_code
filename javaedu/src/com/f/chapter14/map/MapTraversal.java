package com.f.chapter14.map;

import java.util.*;

/**
 * @author fzy
 * @date 2023/6/22 10:50
 */
public class MapTraversal {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("num1", "��������");
        map.put("num2", "ʯͷ��");
        map.put("num2", "��¥��"); //����¥�Ρ��滻�ˡ�ʯͷ�ǡ�
        map.put("num3", "ˮ䰴�");
        map.put("num4", "���μ�");
        map.put(null, "�Ĵ�����");

        //1.��ȡ�����е� Key����ͨ�� Key ȡ����Ӧ�� Value (��ǿfor)
        System.out.println("---------��һ�ַ�ʽ---------");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }

        //2.��ȡ�����е� Key����ͨ�� Key ȡ����Ӧ�� Value (������iterator)
        System.out.println("---------�ڶ��ַ�ʽ---------");
        Iterator keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            System.out.println(key + " - " + map.get(key));
        }

        //3.ֻȡ�����е� Value (��ǿfor)
        System.out.println("---------�����ַ�ʽ---------");
        Collection values = map.values();
        for (Object val : values) {
            System.out.println(val);
        }

        //4.ֻȡ�����е� Value (������iterator)
        System.out.println("---------�����ַ�ʽ---------");
        Iterator valIterator = values.iterator();
        while (valIterator.hasNext()) {
            Object val = valIterator.next();
            System.out.println(val);
        }

        //5.ͨ�� EntrySet ����ȡ k-v (��ǿfor)
        System.out.println("---------�����ַ�ʽ---------");
        Set entrySet = map.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        //6.ͨ�� EntrySet ����ȡ k-v (������iterator)
        System.out.println("---------�����ַ�ʽ---------");
        Iterator entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) entryIterator.next();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
