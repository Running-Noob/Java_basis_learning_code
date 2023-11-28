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
         * 1. 使用 now() 返回表示当前日期时间的对象
         * */
        LocalDateTime localDateTime = LocalDateTime.now();
        //LocalDate localDate = LocalDate.now();
        //LocalTime localTime = LocalTime.now();
        System.out.println(localDateTime);      //2023-04-28T19:43:26.869
        System.out.println("年：" + localDateTime.getYear());
        System.out.println("月：" + localDateTime.getMonth());        //月：APRIL
        System.out.println("月：" + localDateTime.getMonthValue());   //月：4
        System.out.println("日：" + localDateTime.getDayOfMonth());
        System.out.println("时：" + localDateTime.getHour());
        System.out.println("分：" + localDateTime.getMinute());
        System.out.println("秒：" + localDateTime.getSecond());
    }
}
