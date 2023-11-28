package com.f.chapter13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fzy
 * @date 2023/4/28 19:44
 */
public class LocalDateTimeMethod {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("��ʽ��ǰ������Ϊ��" + now);
        //1. ʹ�� DateTimeFormatter �������� LocalDateTime ��ʽ��
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy��MM��dd�� HH:mm:ss");
        String formatNow = dtf.format(now);
        System.out.println("��ʽ���������Ϊ��" + formatNow);

        //2. plus �Ե�ǰ��ʱ����мӷ�
        //����890�����ʲôʱ��
        LocalDateTime future = now.plusDays(890);
        System.out.println("890����ʱ��Ϊ��" + dtf.format(future));

        //3. minus �Ե�ǰ��ʱ����м���
        //����750��Сʱǰ����ʲôʱ��
        LocalDateTime past = now.minusHours(750);
        System.out.println("750��Сʱǰ��ʱ��Ϊ��" + dtf.format(past));

        //4. isAfter ��������ʱ���Ƿ���ָ��������ʱ��֮��
        System.out.println(future.isAfter(now));    //true

        //5. isBefore ��������ʱ���Ƿ���ָ��������ʱ��֮ǰ
        System.out.println(past.isBefore(now));     //true

        //6. isEqual ��������ʱ���Ƿ��ָ��������ʱ�����
        System.out.println(now.isEqual(now));       //true
    }
}
