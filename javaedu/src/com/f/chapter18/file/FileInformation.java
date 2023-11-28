package com.f.chapter18.file;

import java.io.File;

/**
 * @author fzy
 * @date 2023/7/8 12:36
 */
public class FileInformation {
    public static void main(String[] args) {
        //����Java�����д����ļ�����
        File file = new File("C:\\Users\\1\\Desktop\\java\\file\\1.txt");
        //1.getName()����ȡ�ļ�������
        System.out.println("�ļ����� = " + file.getName());
        //2.getAbsolutePath()����ȡ�ļ��ľ���·��
        System.out.println("�ļ��ľ���·�� = " + file.getAbsolutePath());
        //3.getParent()����ȡ�ļ��ĸ���Ŀ¼
        System.out.println("�ļ��ĸ���Ŀ¼ = " + file.getParent());
        //4.length()����ȡ�ļ��Ĵ�С(���ֽ�Ϊ��λ)
        System.out.println("�ļ����ֽڳ���Ϊ = " + file.length());
        //5.exists()���ж��ļ��Ƿ����
        System.out.println("�ļ��Ƿ���ڣ� -> " + file.exists());
        //6.isFile()���ж��Ƿ�Ϊ�ļ�
        System.out.println("�Ƿ����ļ��� -> " + file.isFile());
        //7.isDirectory()���ж��Ƿ�Ϊ�ļ���Ŀ¼
        System.out.println("�Ƿ����ļ���Ŀ¼�� -> " + file.isDirectory());
    }
}
