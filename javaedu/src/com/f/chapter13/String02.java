package com.f.chapter13;

public class String02 {
    public static void main(String[] args) {
        String s1 = new String("1") + new String("1");    //�����������ɡ�1����s1ָ����еĶ��󣬶��ж����value����Ϊ��11��
        s1.intern();        //��������û�С�11�������Խ�s1�ĵ�ַ��ӵ���������
        String s2 = "11";   //��Ϊ�������д��ڡ�11��������s1������s2ָ��������s1�ĵ�ַ
        System.out.println(s1 == s2);   //����true
        String s3 = s2 + "22";
    }
}
