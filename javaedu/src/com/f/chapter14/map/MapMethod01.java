package com.f.chapter14.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fzy
 * @date 2023/6/22 9:39
 */
public class MapMethod01 {
    public static void main(String[] args) {
        Map map = new HashMap();

        //1.`put(K key, V value)`���� `map` �����һ�� `k-v` ������� `key` �ظ������� `value` ���и����滻��
        map.put("num1", "��������");
        map.put("num2", "ʯͷ��");
        map.put("num2", "��¥��"); //����¥�Ρ��滻�ˡ�ʯͷ�ǡ�
        map.put("num3", "ˮ䰴�");
        map.put("num4", "���μ�");
        map.put(null, "�Ĵ�����");
        System.out.println(map);    //{null=�Ĵ�����, num1=��������, num4=���μ�, num3=ˮ䰴�, num2=��¥��} -> ע���������

        //2.`remove(Object key)`�����ݼ�ɾ��ӳ���ϵ��
        map.remove(null);
        System.out.println(map);    //{num1=��������, num4=���μ�, num3=ˮ䰴�, num2=��¥��}

        //3.`get(Object key)`�����ݼ���ȡֵ��
        System.out.println(map.get("num2"));    //��¥��

        //4.`size()`����ȡ `k-v` �Եĸ�����
        System.out.println(map.size());     //4

        //5.`isEmpty()`���ж� `map` �Ƿ�Ϊ�ա�
        System.out.println(map.isEmpty());  //false

        //6.`clear()`����� `map`��
        map.clear();
        System.out.println(map);    //{}

        //7.`containsKey(Object key)`�����Ҽ��Ƿ���ڡ�
        System.out.println(map.containsKey(null));  //false
    }
}
