package com.f.chapter13;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author fzy
 * @date 2023/4/28 17:42
 */
public class LocalDateTime_ {
    public static void main(String[] args) {
        /*
         * 1. ʹ�� now() ���ر�ʾ��ǰ����ʱ��Ķ���
         * */
        LocalDateTime localDateTime = LocalDateTime.now();
        //LocalDate localDate = LocalDate.now();
        //LocalTime localTime = LocalTime.now();
        System.out.println(localDateTime);      //2023-04-28T19:43:26.869
        System.out.println("�꣺" + localDateTime.getYear());
        System.out.println("�£�" + localDateTime.getMonth());        //�£�APRIL
        System.out.println("�£�" + localDateTime.getMonthValue());   //�£�4
        System.out.println("�գ�" + localDateTime.getDayOfMonth());
        System.out.println("ʱ��" + localDateTime.getHour());
        System.out.println("�֣�" + localDateTime.getMinute());
        System.out.println("�룺" + localDateTime.getSecond());
    }
}
