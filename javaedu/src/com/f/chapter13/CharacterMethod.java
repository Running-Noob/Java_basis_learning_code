package com.f.chapter13;

public class CharacterMethod {
    public static void main(String[] args) {
        System.out.println(Character.isDigit('1')); //�ж��ǲ�������
        System.out.println(Character.isLetter('a')); //�ж��ǲ�����ĸ
        System.out.println(Character.isUpperCase('A')); //�ж��ǲ��Ǵ�д
        System.out.println(Character.isLowerCase('a')); //�ж��ǲ���Сд
        System.out.println(Character.isWhitespace(' '));    //�ж��ǲ��ǿո�

        System.out.println(Character.toUpperCase('a')); //ת��Ϊ��д
        System.out.println(Character.toLowerCase('A')); //ת��ΪСд
    }
}
