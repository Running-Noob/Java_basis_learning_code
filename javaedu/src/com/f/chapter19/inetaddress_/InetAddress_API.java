package com.f.chapter19.inetaddress_;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author fzy
 * @date 2023/7/14 11:56
 * ��ʾ InetAddress ���ʹ��
 */
public class InetAddress_API {
    public static void main(String[] args) throws UnknownHostException {
        //1.`public static InetAddress getLocalHost()`����ȡ������ `InetAddress` ����
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);  //Running-Noob/192.168.177.1

        //2.`public static InetAddress getByName(String host)`������ָ����������/������ȡ `ip` ��ַ����
        InetAddress host1 = InetAddress.getByName("Running-Noob");
        System.out.println(host1);   //Running-Noob/192.168.177.1

        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);  //www.baidu.com/112.80.248.76

        //3.`getHostName`����ȡ `InetAddress` �����������/������
        System.out.println(host2.getHostName());    //www.baidu.com

        //4.`getHostAddress`����ȡ `InetAddress` ����ĵ�ַ��
        System.out.println("IP��ַ��" + host2.getHostAddress()); //IP��ַ��112.80.248.76
    }
}