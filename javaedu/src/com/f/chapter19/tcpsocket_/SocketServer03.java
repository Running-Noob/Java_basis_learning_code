package com.f.chapter19.tcpsocket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/14 20:39
 */
public class SocketServer03 {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.���� 9999 �˿ڣ�����������пͻ������� 9999 �˿ڣ�
        // �ͽ�������˵� Socket ����
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        //2.������Socket������������������������
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        //3.��TCP�ֽ������ת��ΪTCP�ַ������
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "gbk"));
        //4.��ȡ�ͻ��˷��͵���Ϣ
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //5.������Ϣ���ͻ��ˣ������ý������
        bufferedWriter.write("hello, client");
        bufferedWriter.newLine();
        bufferedWriter.flush(); //���ʹ�õ����ַ�����̣�����Ҫ�ֶ�ˢ�£��������ݲ���д������ͨ��
        socket.shutdownOutput();    //���ý������
        //6.�ͷ���Դ����򿪵��ȹرգ�
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
