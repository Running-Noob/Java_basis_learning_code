package com.f.chapter19.tcpsocket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/14 16:32
 * �ͻ���
 */
public class SocketClient01 {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.���ӷ����(ip, �˿�)
        // ������ӳɹ������ɿͻ��˵�Socket������ͼ�ж�Ӧ����ڵ�socket��
        Socket socket = new Socket(InetAddress.getLocalHost(), port);
        //���ӷ���˳ɹ����ͻ���Socket��Socket[addr=Running-Noob/192.168.177.1,port=9999,localport=49534]
        System.out.println("���ӷ���˳ɹ����ͻ���Socket��" + socket);
        //2.������Socket����󣬾Ϳ���ͨ��socket.getOutputStream
        // �õ���Socket������������������Ȼ��������
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, server".getBytes());
        //3.�ر��������socket��������Դ�˷�
        outputStream.close();
        socket.close();
        System.out.println("�ͻ����˳�...");
    }
}
