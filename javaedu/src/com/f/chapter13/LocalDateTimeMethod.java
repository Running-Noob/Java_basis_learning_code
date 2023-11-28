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
        System.out.println("格式化前的日期为：" + now);
        //1. 使用 DateTimeFormatter 对象来对 LocalDateTime 格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String formatNow = dtf.format(now);
        System.out.println("格式化后的日期为：" + formatNow);

        //2. plus 对当前的时间进行加法
        //看看890天后，是什么时间
        LocalDateTime future = now.plusDays(890);
        System.out.println("890天后的时间为：" + dtf.format(future));

        //3. minus 对当前的时间进行减法
        //看看750个小时前，是什么时间
        LocalDateTime past = now.minusHours(750);
        System.out.println("750个小时前的时间为：" + dtf.format(past));

        //4. isAfter 检查此日期时间是否在指定的日期时间之后
        System.out.println(future.isAfter(now));    //true

        //5. isBefore 检查此日期时间是否在指定的日期时间之前
        System.out.println(past.isBefore(now));     //true

        //6. isEqual 检查此日期时间是否和指定的日期时间相等
        System.out.println(now.isEqual(now));       //true
    }
}
