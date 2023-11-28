package com.f.chapter19.tcpsocket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/14 20:39
 */
public class SocketServer02 {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.���� 9999 �˿ڣ�����������пͻ������� 9999 �˿ڣ�
        // �ͽ�������˵� Socket ����
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        //2.������Socket������������������������
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        //3.��ȡ�ͻ��˷��͵���Ϣ
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        //4.������Ϣ���ͻ��ˣ������ý������
        outputStream.write("hello, client".getBytes());
        socket.shutdownOutput();    //���ý������
        //5.�ͷ���Դ
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
