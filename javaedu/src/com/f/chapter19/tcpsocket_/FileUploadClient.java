//package com.f.chapter19.tcpsocket_;
//
//import java.io.*;
//import java.net.InetAddress;
//import java.net.Socket;
//
///**
// * @author fzy
// * @date 2023/7/15 13:21
// * �ļ�����Ŀͻ���
// */
//public class FileUploadClient {
//    public static void main(String[] args) throws IOException {
//        int port = 9999;
//        String srcFilePath = "C:\\Users\\1\\Doc\\�뵳���\\���鱳��.jpg";
//        //1.�õ��ͻ��˵�Socket����
//        Socket socket = new Socket(InetAddress.getLocalHost(), port);
//        //2.�õ�Socket�����������������������������ݵĴ���
//        OutputStream socketOutputStream = socket.getOutputStream();
//        InputStream socketInputStream = socket.getInputStream();
//        BufferedOutputStream socketBufferedOutputStream = new BufferedOutputStream(socketOutputStream);
//        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(socketInputStream));
//        //3.�õ�Ҫ���͵��ļ���������
//        BufferedInputStream fileBufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
//        //4.�ͻ��˽��ļ����ݷ��͸������
//        byte[] fileBytes = StreamUtils.streamToByteArray(fileBufferedInputStream);  //�ļ���Ӧ���ֽ�����
//        socketBufferedOutputStream.write(fileBytes);
//        socket.shutdownOutput();    //���ý������
//        //5.�ͻ��˴ӷ���˽��ա��յ��ļ�������Ϣ
//        String line = null;
//        while ((line = socketBufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
//        //6.�ͷ���Դ
//        socketBufferedReader.close();
//        socketBufferedOutputStream.close();
//        fileBufferedInputStream.close();
//        socket.close();
//    }
//}