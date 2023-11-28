package com.f.chapter18.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author fzy
 * @date 2023/7/8 14:41
 * ��ʾFileOutputStream��ʹ�ã��ֽ������������ --> �ļ���
 */
@SuppressWarnings({"all"})
public class FileOutputStream01 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Desktop\\java\\file\\hello.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //true��ʾ��д��ʱ��������ļ�ĩβ��Ĭ��Ϊfalse
            fileOutputStream = new FileOutputStream(filePath);
            //fileOutputStream = new FileOutputStream(filePath, true);
            //1.`public void write(int b)`����ָ�����ֽ�д����ļ��������
            fileOutputStream.write('a');
            //2.`public void write(byte b[])`���� `b.length` ���ֽڴ�ָ�����ֽ�����д����ļ��������
            String str = "hello!";
            fileOutputStream.write(str.getBytes());     //getBytes()�����ַ���ת��Ϊ�ַ�����
            //3.`public void write(byte b[], int off, int len)`���� `len` ���ֽڴ�λ��ƫ���� `off` ��ָ���ֽ�����д����ļ��������
            fileOutputStream.write(str.getBytes(), 0, str.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
