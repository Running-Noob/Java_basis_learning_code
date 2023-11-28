package com.f.chapter13;

import java.math.BigInteger;

/**
 * @author fzy
 * @date 2023/4/27 21:03
 */
public class BigInteger_ {
    public static void main(String[] args) {
        BigInteger bigInteger1 = new BigInteger("12345678987654321");
        BigInteger bigInteger2 = new BigInteger("98765432123456789");
        BigInteger add = bigInteger1.add(bigInteger2);  //¼Ó
        BigInteger substract = bigInteger1.subtract(bigInteger2);  //¼õ
        BigInteger multiply = bigInteger1.multiply(bigInteger2);  //³Ë
        BigInteger divide = bigInteger1.divide(bigInteger2);  //³ý
        System.out.println(add);
        System.out.println(substract);
        System.out.println(multiply);
        System.out.println(divide);
    }
}