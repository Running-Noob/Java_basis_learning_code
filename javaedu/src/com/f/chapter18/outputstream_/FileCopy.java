//package com.f.chapter18.outputstream_;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
///**
// * @author fzy
// * @date 2023/7/10 20:57
// * ʹ��FileInputStream��FileOutputStream���ļ����и���
// */
//public class FileCopy {
//    public static void main(String[] args) {
//        String srcFilePath = "C:\\Users\\1\\Doc\\�뵳���\\���鱳��.jpg";
//        String destFilePath = "C:\\Users\\1\\Doc\\�뵳���\\���鱳��-copy.jpg";
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//        int readLen = 0;
//        byte[] buf = new byte[1024];    //��ȡ������
//        try {
//            if (new File(srcFilePath).exists()) {
//                fileInputStream = new FileInputStream(srcFilePath); //�ļ�������
//            } else {
//                System.out.println("Ҫ���Ƶ��ļ������ڣ�");
//                return;
//            }
//            fileOutputStream = new FileOutputStream(destFilePath);  //�ļ������
//            while ((readLen = fileInputStream.read(buf)) != -1) {
//                fileOutputStream.write(buf, 0, readLen);
//            }
//            System.out.println("�ļ����Ƴɹ���");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                fileInputStream.close();
//                fileOutputStream.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
