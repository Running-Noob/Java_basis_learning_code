//package com.f.chapter18.outputstream_;
//
//import java.io.*;
//
///**
// * @author fzy
// * @date 2023/7/11 16:18
// * ʹ��BufferedInputStream��BufferedOutputStream���ļ����и���
// */
//public class FileCopy02 {
//    public static void main(String[] args) {
//        String srcFilePath = "C:\\Users\\1\\Doc\\�뵳���\\���鱳��.jpg";
//        String destFilePath = "C:\\Users\\1\\Doc\\�뵳���\\���鱳��-copy.jpg";
//        BufferedInputStream bufferedInputStream = null;
//        BufferedOutputStream bufferedOutputStream = null;
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//
//        try {
//            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
//            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
//
//            while ((readLen = bufferedInputStream.read(buf)) != -1) {
//                bufferedOutputStream.write(buf, 0, readLen);
//            }
//
//            System.out.println("�����ɹ���");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                bufferedInputStream.close();
//                bufferedOutputStream.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
