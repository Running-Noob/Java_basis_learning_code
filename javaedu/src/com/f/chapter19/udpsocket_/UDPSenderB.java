package com.f.chapter19.udpsocket_;

import java.io.IOException;
import java.net.*;

/**
 * @author fzy
 * @date 2023/7/16 14:54
 */

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1.����DatagramSocket����׼����������
        int port = 9998;    //���Ͷ˺ͽ��ն˵Ķ˿ڲ�Ҫ�ظ����ö˿��Ǹ�DatagramSocket�����������ʱ�õĶ˿�
        DatagramSocket sendSocket = new DatagramSocket(port);
        //2.����Ҫ���͵����ݷ�װ�� DatagramPacket ������
        byte[] buf = "hello, ����Ի��~".getBytes();
        /*����Ҫ���͵�DatagramPacket����ʱ������Ĳ��������ǣ�
        * buf�����ݰ����ݡ�
        * offset����������ƫ������
        * length���������ݳ��ȡ�
        * address��Ŀ�ĵ�ַ��
        * port��Ŀ�Ķ˿ںš�
        * */
        DatagramPacket sendPacket = new DatagramPacket(buf, 0, buf.length, InetAddress.getLocalHost(), 9999);
        //3.�������ݱ�
        sendSocket.send(sendPacket);
        //4.���Ͷ˽��ս��ն˷��͹�������Ϣ
        byte[] receive = new byte[64 * 1024];
        DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
        sendSocket.receive(receivePacket);
        //5.�Խ��յ������ݱ����в����ȡ�����е����ݲ���ʾ
        System.out.println("���յ����ն˵Ļظ���");
        byte[] data = receivePacket.getData();
        int length = receivePacket.getLength();
        System.out.println(new String(data, 0, length));
        //System.out.println(receivePacket.getAddress()); //���շ��ĵ�ַ
        //System.out.println(receivePacket.getPort());    //���շ��Ķ˿�
        //6.�ر���Դ
        sendSocket.close();
    }
}
