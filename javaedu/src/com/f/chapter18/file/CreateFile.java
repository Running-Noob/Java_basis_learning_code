package com.f.chapter18.file;

import java.io.File;
import java.io.IOException;

/**
 * @author fzy
 * @date 2023/7/7 14:45
 * ��ʾ�����ļ�
 */
public class CreateFile {
    public static void main(String[] args) {
        createFile01();
        createFile02();
        createFile03();
    }

    //1.`new File(String pathname)`������·������һ�� `File` ����
    public static void createFile01() {
        String filePath = "C:\\Users\\1\\Desktop\\java\\file\\1.txt";   //·��
        //����ֻ����Java�������½�һ��File���󣬻�û���ڴ�����ʵ�ʴ�����Ӧ���ļ�
        File file = new File(filePath);
        try {
            file.createNewFile();   //���ļ��ڴ�����ʵ�ʴ�������
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("��һ�ַ�ʽ�����ļ��ɹ�...");
    }

    //2.`new File(File parent, String child)`������ ����Ŀ¼�ļ�+��·���� ������
    public static void createFile02() {
        File parentFile = new File("C:\\Users\\1\\Desktop\\java\\file\\");  //��Ŀ¼�ļ�
        String childPath = "2.txt"; //��·��
        File file = new File(parentFile, childPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("�ڶ��ַ�ʽ�����ļ��ɹ�...");
    }

    //3.`new File(String parent, String child)`������ ����Ŀ¼+��·���� ������
    public static void createFile03() {
        String parentPath = "C:\\Users\\1\\Desktop\\java\\file\\";  //��Ŀ¼
        String childPath = "3.txt"; //��·��
        File file = new File(parentPath, childPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("�����ַ�ʽ�����ļ��ɹ�...");
    }
}
