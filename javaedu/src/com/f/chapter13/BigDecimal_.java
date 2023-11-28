package com.f.chapter13;

import java.math.BigDecimal;

/**
 * @author fzy
 * @date 2023/4/27 21:23
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("1.234567890987654321");
        BigDecimal bigDecimal2 = new BigDecimal("0.345678909876543212");
        BigDecimal add = bigDecimal1.add(bigDecimal2);  //��
        BigDecimal subtract = bigDecimal1.subtract(bigDecimal2);    //��
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);    //��
        //BigDecimal divide = bigDecimal1.divide(bigDecimal2);    //���������׳��쳣��Non-terminating decimal expansion; no exact representable decimal result.ԭ���ǳ�����
        BigDecimal divide = bigDecimal1.divide(bigDecimal2, BigDecimal.ROUND_CEILING);    //�ڵ���divide����ʱ��ָ�����ȼ���
        System.out.println(add);
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(divide);
    }
}
