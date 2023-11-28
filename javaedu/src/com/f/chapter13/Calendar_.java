package com.f.chapter13;

import java.util.Calendar;

/**
 * @author fzy
 * @date 2023/4/28 17:11
 */
public class Calendar_ {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); //ͨ�� getInstance ��������ȡ Calendar ʵ��
        System.out.println(calendar);

        //��ȡ���������ĳ�������ֶ�
        System.out.println("�꣺" + calendar.get(Calendar.YEAR));
        System.out.println("�£�" + (calendar.get(Calendar.MONTH) + 1));  //Calendar.MONTH�ڷ����µ�ʱ���Ǵ�0��ʼ��ŵ�
        System.out.println("�գ�" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Сʱ��" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("���ӣ�" + calendar.get(Calendar.MINUTE));
        System.out.println("�룺" + calendar.get(Calendar.SECOND));

        //ע�⣺Calendar û��ר�ŵĸ�ʽ����������Ҫ����Ա�Լ�������
        //System.out.println("���ڵ�ʱ��Ϊ��" + calendar.get(Calendar.YEAR) + "��" + (calendar.get(Calendar.MONTH) + 1) + "��" + calendar.get(Calendar.DAY_OF_MONTH) + "��" +
        //        calendar.get(Calendar.HOUR_OF_DAY) + "ʱ" + calendar.get(Calendar.MINUTE) + "��" + calendar.get(Calendar.SECOND) + "��");
        String formatString = "%d��%d��%d��%dʱ%d��%d��";
        String time = String.format(formatString, calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        System.out.println("���ڵ�ʱ��Ϊ��" + time);
    }
}
