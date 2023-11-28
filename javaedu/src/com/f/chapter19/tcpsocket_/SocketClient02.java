package com.f.chapter19.tcpsocket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/14 20:39
 */
public class SocketClient02 {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.�����ͻ��˵�Socket����
        Socket socket = new Socket(InetAddress.getLocalHost(), port);
        //2.������Socket������������������������
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        //3.������Ϣ������ˣ������ý������
        outputStream.write("hello, server".getBytes());
        socket.shutdownOutput();    //���ý������
        //4.��ȡ����˷��͵���Ϣ
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        //5.�ͷ���Դ
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
