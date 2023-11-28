package com.f.chapter19.tcpsocket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author fzy
 * @date 2023/7/16 18:22
 */
public class MusicDownloadClient {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        //1.�����ͻ���Socket����
        Socket socket = new Socket(InetAddress.getLocalHost(), port);
        //2.�����Ϳͻ���Socket��������������������
        BufferedWriter socketBufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedInputStream socketBufferedInputStream = new BufferedInputStream(socket.getInputStream());
        //3.���������ļ������
        String musicName = null;
        Scanner myscanner = new Scanner(System.in);
        System.out.println("����������Ҫ���������ƣ�");
        musicName = myscanner.next();
        String destFilePath = "C:\\Users\\1\\Code Project\\Java project\\file2\\" + musicName + ".mp3";
        BufferedOutputStream fileBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        //4.������Ҫ���ص���������
        socketBufferedWriter.write(musicName);
        socketBufferedWriter.flush();
        socket.shutdownOutput();
        //5.��ȡ����˷��͹���������
        byte[] fileBytes = StreamUtils.streamToByteArray(socketBufferedInputStream);
        fileBufferedOutputStream.write(fileBytes);
        //6.�ͷ���Դ
        fileBufferedOutputStream.close();
        socketBufferedWriter.close();
        socketBufferedInputStream.close();
        socket.close();
    }
}
