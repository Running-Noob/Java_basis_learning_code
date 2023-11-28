package com.f.chapter13;

import java.util.Calendar;

/**
 * @author fzy
 * @date 2023/4/28 17:11
 */
public class Calendar_ {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); //通过 getInstance 方法来获取 Calendar 实例
        System.out.println(calendar);

        //获取日历对象的某个日历字段
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        System.out.println("月：" + (calendar.get(Calendar.MONTH) + 1));  //Calendar.MONTH在返回月的时候，是从0开始编号的
        System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分钟：" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));

        //注意：Calendar 没有专门的格式化方法，需要程序员自己组合输出
        //System.out.println("现在的时间为：" + calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日" +
        //        calendar.get(Calendar.HOUR_OF_DAY) + "时" + calendar.get(Calendar.MINUTE) + "分" + calendar.get(Calendar.SECOND) + "秒");
        String formatString = "%d年%d月%d日%d时%d分%d秒";
        String time = String.format(formatString, calendar.get(Calendar.YEAR), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        System.out.println("现在的时间为：" + time);
    }
}
