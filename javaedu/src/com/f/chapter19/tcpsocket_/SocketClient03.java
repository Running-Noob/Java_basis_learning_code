package com.f.chapter19.tcpsocket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/14 20:39
 */
public class SocketClient03 {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.�����ͻ��˵�Socket����
        Socket socket = new Socket(InetAddress.getLocalHost(), port);
        //2.������Socket������������������������
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        //3.��TCP�ֽ������ת��ΪTCP�ַ������
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "gbk"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
        //4.������Ϣ������ˣ������ý������
        bufferedWriter.write("hello, server");
        bufferedWriter.newLine();
        bufferedWriter.flush(); //���ʹ�õ����ַ�����̣�����Ҫ�ֶ�ˢ�£��������ݲ���д������ͨ��
        socket.shutdownOutput();    //���ý������
        //5.��ȡ����˷��͵���Ϣ
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //6.�ͷ���Դ����򿪵��ȹرգ�
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
