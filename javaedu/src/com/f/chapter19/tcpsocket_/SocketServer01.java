package com.f.chapter19.tcpsocket_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/14 16:32
 * �����
 */
public class SocketServer01 {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.�ڱ����� 9999 �˿ڼ������ȴ�����
        // ����Ҫ�󱾻�û�����������ڼ���9999���������쳣
        // serverSocket����ͨ�� accept() ���ض�� Socket ����[����ж���ͻ������ӷ�����]
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("������� " + port + " �˿ڽ��м������ȴ�����...");
        //2.��û�пͻ������� 9999 �˿�ʱ��������������ȴ����ӡ�
        // ����пͻ������ӣ���᷵��һ�� Socket ���󣬸ö����Ƿ���˵� Socket ������ͼ�ж�Ӧ�̿��ڵ�socket��
        Socket socket = serverSocket.accept();
        //�пͻ������� 9999 �˿ڣ������socket��Socket[addr=/192.168.177.1,port=49534,localport=9999]
        System.out.println("�пͻ������� " + port + " �˿ڣ������socket��" + socket);
        //3.���пͻ������� 9999 �˿ں󣬷����ͨ�� socket.getInputStream()
        // ��ȡ�ͻ���д�뵽����ͨ�������ݣ�Ȼ�����˶����ݽ��������ʾ
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        System.out.println("��ȡ�ͻ��˵��������£�");
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }
        System.out.println();
        System.out.println("��ȡ���...");
        //4.�ر�������socket��serverSocket��������Դ�˷�
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("������˳�...");
    }
}
