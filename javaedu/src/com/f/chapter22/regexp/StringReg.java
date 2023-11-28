package com.f.chapter22.regexp;

/**
 * @author fzy
 * @date 2023/8/18 15:28
 * String类中使用正则表达式
 * 替换、分割、匹配
 */
public class StringReg {
    public static void main(String[] args) {
        //1.替换
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。";
        //使用正则表达式将 JDK1.3、JDK1.4 替换为 JDK
        String regExp = "JDK1\\.[34]";
        String newContent = content.replaceAll(regExp, "JDK");
        System.out.println(newContent);

        //2.分割
        content = "hello#abc-jack12smith~北京";
        //使用正则表达式按照 #、-、~、数字 来进行分割
        regExp = "#|-|~|\\d+";
        String[] split = content.split(regExp);
        for (String substring : split) {
            System.out.println("分割: " + substring);
        }

        //3.匹配
        String phone = "13988888888";
        //使用正则表达式判断手机号是否为 138、139 开头
        regExp = "13[89]\\d{8}";
        System.out.println("手机号是否为 138、139 开头: " + phone.matches(regExp));
    }
}