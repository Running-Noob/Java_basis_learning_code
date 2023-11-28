package com.f.chapter19.udpsocket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author fzy
 * @date 2023/7/16 14:54
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.����һ��DatagramSocket����׼���� 9999 �˿ڽ�������
        int port = 9999;
        DatagramSocket receiveSocket = new DatagramSocket(port);
        //2.����һ��DatagramPacket����׼����������
        // UDP���ݱ��Ĵ�С������64K��
        byte[] buf = new byte[64 * 1024];
        /*�����������ݱ���DatagramPacket����ʱ������Ĳ��������ǣ�
        * buf - ���ڱ��洫�����ݱ��Ļ�������
        * length - Ҫ��ȡ���ֽ�����
        * */
        //��Ϊ��֪���Է����͹��������ݱ��Ĵ�С�����Դ����length����Ϊbuf.length
        DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
        //3.���ý��շ�������ͨ�����紫���DatagramPacket������䵽receivePacket��ȥ
        System.out.println("���ն�A�ȴ���������...");
        receiveSocket.receive(receivePacket);
        //4.��receivePacket���в����ȡ�����ݲ���ʾ
        int length = receivePacket.getLength();    //ʵ�ʽ��յ������ݳ���
        byte[] data = receivePacket.getData();     //���յ�������
        System.out.println(new String(buf, 0, length));
        //System.out.println(receivePacket.getAddress()); //���ͷ��ĵ�ַ
        //System.out.println(receivePacket.getPort());    //���ͷ��Ķ˿�
        //5.���ն����Ͷ˻ظ���Ϣ
        byte[] response = "�õģ������".getBytes();
        //receivePacket�к��з��Ͷ˵�IP��ַ�Ͷ˿ں�
        DatagramPacket sendPacket = new DatagramPacket(response, 0, response.length, receivePacket.getAddress(), receivePacket.getPort());
        receiveSocket.send(sendPacket);
        //6.�ر���Դ
        receiveSocket.close();
    }
}
