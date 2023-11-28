package com.f.chapter22.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fzy
 * @date 2023/8/15 19:08
 * 正则表达式快速入门例子
 */
public class RegExp01 {
    public static void main(String[] args) {
        //要处理的字符串文本
        String content = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，" +
                "急需一种软件技术来开发一种程序，这种程序可以通过网络传播并且能够跨平台运行。" +
                "于是，世界各大IT企业为此纷纷投入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，" +
                "并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，" +
                "特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。" +
                "Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet" +
                "（Applet是一种将小程序嵌入到网页中进行执行的技术），并将Oak更名为Java。" +
                "5月23日，Sun公司在Sun world会议上正式发布Java和HotJava浏览器。" +
                "IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软等各大公司都纷纷停止了自己的相关开发项目，" +
                "竞相购买了Java使用许可证，并为自己的产品开发了相应的Java平台。";
        //1.先创建一个Pattern对象, 即模式对象, 可以理解为就是一个正则表达式对象, 传入的参数为正则表达式
        Pattern pattern = Pattern.compile("[a-zA-Z]+"); //要匹配英文单词
        //2.创建一个匹配器对象, 传入要处理的字符串
        //  matcher 匹配器按照 pattern(模式/样式) 到 content 文本中去匹配。
        Matcher matcher = pattern.matcher(content);
        //3.开始循环匹配
        while (matcher.find()) {    //如果找到就返回 true，否则返回 false。
            //匹配到的内容可以通过 matcher.group 得到
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
