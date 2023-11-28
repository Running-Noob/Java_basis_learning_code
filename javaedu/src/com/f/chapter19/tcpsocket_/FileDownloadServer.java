package com.f.chapter19.tcpsocket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/15 13:22
 * �ļ�����ķ����
 */
public class FileDownloadServer {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        String savePath = "file\\copy.jpg"; //�ļ������λ��
        //1.�õ�����˵�Socket����
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("��������� " + port + " �˿ڼ���...");
        Socket socket = serverSocket.accept();
        //2.�õ�Socket�����������������������������ݵĴ���
        InputStream socketInputStream = socket.getInputStream();
        OutputStream socketOutputStream = socket.getOutputStream();
        BufferedInputStream socketBufferedInputStream = new BufferedInputStream(socketInputStream);
        BufferedWriter socketBufferedWriter = new BufferedWriter(new OutputStreamWriter(socketOutputStream));
        //3.�õ�Ҫ������ļ��������
        BufferedOutputStream fileBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(savePath));
        //4.����˴ӿͻ��˽������ݣ���������д�뵽�����ļ���
        byte[] fileBytes = StreamUtils.streamToByteArray(socketBufferedInputStream);    //�ļ���Ӧ���ֽ�����
        fileBufferedOutputStream.write(fileBytes);
        //5.����˽���Ϣ���͸��ͻ���
        socketBufferedWriter.write("�յ�ͼƬ...");
        //���û��flush������д������ͨ��������socketBufferedWriter.close();ʱ�ᱨ�쳣��
        // Cannot send after socket shutdown: socket write error
        // ��Ϊ���ݻ���û��д�뵽����ͨ����
        socketBufferedWriter.flush();
        socket.shutdownOutput();    //���ý������
        //6.�ͷ���Դ
        socketBufferedWriter.close();
        fileBufferedOutputStream.close();
        socketBufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}