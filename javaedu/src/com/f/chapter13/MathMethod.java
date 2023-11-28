package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/26 14:18
 */
public class MathMethod {
    public static void main(String[] args) {
        //1. abs 求绝对值
        double abs = Math.abs(-5.1);
        System.out.println(abs);        //5.1
        //2. pow 求幂
        double pow = Math.pow(1.1, 3);
        System.out.println(pow);        //1.1^3
        //3. ceil 向上取整，返回 >= 该参数的最小整数
        double ceil = Math.ceil(-5.001);
        System.out.println(ceil);       //-5.0
        //4. floor 向下取整，返回 <= 该参数的最大整数
        double floor = Math.floor(-5.001);
        System.out.println(floor);      //-6.0
        //5. round 四舍五入 -> Math.floor(参数+0.5)
        long round = Math.round(-5.4);
        System.out.println(round);      //-5
        //6. sqrt 开方
        double sqrt = Math.sqrt(10);
        System.out.println(sqrt);       //根号10
        //7. random 求随机数，返回的是 [0,1) 之间的一个随机小数
        double random = Math.random();
        System.out.println(random);
        //8. max 求最大值
        double max = Math.max(-1.1, -2.3);
        System.out.println(max);        //-1.1
        //9. min 求最小值
        double min = Math.min(-1.1, -2.3);
        System.out.println(min);        //-2.3
    }
}
