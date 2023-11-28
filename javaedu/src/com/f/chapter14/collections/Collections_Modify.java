package com.f.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fzy
 * @date 2023/6/23 21:15
 */
public class Collections_Modify {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("my");
        list.add("computer");
        System.out.println(list);   //[hello, world, my, computer]

        //1.`copy(List<? super T> dest, List<? extends T> src)`���� `src` �е����ݸ��Ƶ� `dest` �С�
        List newList = new ArrayList();
        //Collections.copy �����ڽ��п���֮ǰ����� src �� dest �ĳ��Ƚ����жϣ���� src �ĳ��ȴ��� dest��
        // ���׳� IndexOutOfBoundsException: Source does not fit in dest �쳣
        for (int i = 0; i < list.size(); i++) {
            newList.add("");    //Ϊ��ʹ�� dest �ĳ��Ȳ�С�� src �ĳ���
        }
        Collections.copy(newList, list);
        System.out.println(newList);    //[hello, world, my, computer]

        //2.`replaceAll(List<T> list, T oldVal, T newVal)`��ʹ�� `newVal` �滻 `List` ��������� `oldVal`��
        Collections.replaceAll(list, "hello", "hi");
        System.out.println(list);   //[hi, world, my, computer]
    }
}
