package com.f.chapter13;

/**
 * @author fzy
 * @date 2023/4/26 14:18
 */
public class MathMethod {
    public static void main(String[] args) {
        //1. abs �����ֵ
        double abs = Math.abs(-5.1);
        System.out.println(abs);        //5.1
        //2. pow ����
        double pow = Math.pow(1.1, 3);
        System.out.println(pow);        //1.1^3
        //3. ceil ����ȡ�������� >= �ò�������С����
        double ceil = Math.ceil(-5.001);
        System.out.println(ceil);       //-5.0
        //4. floor ����ȡ�������� <= �ò������������
        double floor = Math.floor(-5.001);
        System.out.println(floor);      //-6.0
        //5. round �������� -> Math.floor(����+0.5)
        long round = Math.round(-5.4);
        System.out.println(round);      //-5
        //6. sqrt ����
        double sqrt = Math.sqrt(10);
        System.out.println(sqrt);       //����10
        //7. random ������������ص��� [0,1) ֮���һ�����С��
        double random = Math.random();
        System.out.println(random);
        //8. max �����ֵ
        double max = Math.max(-1.1, -2.3);
        System.out.println(max);        //-1.1
        //9. min ����Сֵ
        double min = Math.min(-1.1, -2.3);
        System.out.println(min);        //-2.3
    }
}
