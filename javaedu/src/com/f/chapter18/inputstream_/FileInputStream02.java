package com.f.chapter18.inputstream_;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author fzy
 * @date 2023/7/8 14:23
 */

public class FileInputStream02 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\hello.txt";
        byte[] buf = new byte[8];   //һ�ζ�ȡ8���ֽ�
        FileInputStream fileInputStream = null;
        int readLen = 0;    //��ȡ���ֽ���
        int cnt = 0;        //��ȡ�Ĵ���
        try {
            fileInputStream = new FileInputStream(filePath);
            //�����ȡ������read(byte[] b) ���ص���ʵ�ʶ�ȡ���ֽ���
            //����ﵽ�ļ���ĩβ���򷵻� -1
            while ((readLen = fileInputStream.read(buf)) != -1) {
                cnt++;
                System.out.println("��ζ�ȡ���ֽ��� = " + readLen);
                System.out.println(new String(buf, 0, readLen));
            }
            System.out.println("����ȡ�� " + cnt + " ��");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
