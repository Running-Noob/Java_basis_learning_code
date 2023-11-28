package com.f.chapter19.tcpsocket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/16 18:22
 */
public class MusicUploadServer {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.��������˵�Socket����
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("��������� " + port + " �˿ڼ���...");
        Socket socket = serverSocket.accept();
        //2.�����ͷ����Socket��������������������
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedOutputStream socketBufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        //3.���������ļ�������
        BufferedInputStream fileBufferedInputStream = null;
        //4.��ȡ�ͻ�����Ҫ����������
        String line = socketBufferedReader.readLine();
        String srcFilePath = "C:\\Users\\1\\Code Project\\Java project\\file\\" + line + ".mp3";
        File file = new File(srcFilePath);
        //5.������Ӧ�����֣���������ʾ��Ϣ
        if (file.exists()) {
            fileBufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] fileBytes = StreamUtils.streamToByteArray(fileBufferedInputStream);
            socketBufferedOutputStream.write(fileBytes);
        } else {
            fileBufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\1\\Code Project\\Java project\\file\\default.mp3"));
            byte[] fileBytes = StreamUtils.streamToByteArray(fileBufferedInputStream);
            socketBufferedOutputStream.write(fileBytes);
        }
        //6.�ͷ���Դ
        socketBufferedOutputStream.close();
        fileBufferedInputStream.close();
        socketBufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
