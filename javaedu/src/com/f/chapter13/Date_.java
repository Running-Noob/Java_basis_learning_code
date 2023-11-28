package com.f.chapter13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fzy
 * @date 2023/4/28 16:41
 */
public class Date_ {
    public static void main(String[] args) throws ParseException {
        /*
         * 1. 这里的 Date 类是在 java.util 包下
         * 2. 获取当前系统时间
         * 3. 默认输出的日期格式是国外的方式，需要对格式进行转换
         * */
        Date date1 = new Date();
        System.out.println("当前日期为：" + date1);   //默认输出的日期格式是国外的方式：当前日期为：Fri Apr 28 16:51:47 CST 2023

        /*
         * 1. 创建 SimpleDateFormat 对象，可以指定相应的格式
         * 2. 这里的格式使用的字母是规定好的，不能乱写
         * */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String date1Format = sdf.format(date1);
        System.out.println("当前日期为：" + date1Format); //经过格式化后的日期格式：当前日期为：2023年04月28日 16:51:47

        /*
         * 1. 可以把一个格式化的 String 转换为对应的 Date
         * 2. 转换后得到的 Date 仍然是国外的日期格式，如果希望指定输出格式，仍然需要使用 SimpleDateFormat
         * */
        String s = "2023年04月28日 16:51:47";
        Date parse = sdf.parse(s);
        System.out.println(parse);  //Fri Apr 28 16:51:47 CST 2023
    }
}
