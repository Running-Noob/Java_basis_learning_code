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
         * 1. ����� Date ������ java.util ����
         * 2. ��ȡ��ǰϵͳʱ��
         * 3. Ĭ����������ڸ�ʽ�ǹ���ķ�ʽ����Ҫ�Ը�ʽ����ת��
         * */
        Date date1 = new Date();
        System.out.println("��ǰ����Ϊ��" + date1);   //Ĭ����������ڸ�ʽ�ǹ���ķ�ʽ����ǰ����Ϊ��Fri Apr 28 16:51:47 CST 2023

        /*
         * 1. ���� SimpleDateFormat ���󣬿���ָ����Ӧ�ĸ�ʽ
         * 2. ����ĸ�ʽʹ�õ���ĸ�ǹ涨�õģ�������д
         * */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        String date1Format = sdf.format(date1);
        System.out.println("��ǰ����Ϊ��" + date1Format); //������ʽ��������ڸ�ʽ����ǰ����Ϊ��2023��04��28�� 16:51:47

        /*
         * 1. ���԰�һ����ʽ���� String ת��Ϊ��Ӧ�� Date
         * 2. ת����õ��� Date ��Ȼ�ǹ�������ڸ�ʽ�����ϣ��ָ�������ʽ����Ȼ��Ҫʹ�� SimpleDateFormat
         * */
        String s = "2023��04��28�� 16:51:47";
        Date parse = sdf.parse(s);
        System.out.println(parse);  //Fri Apr 28 16:51:47 CST 2023
    }
}
