package com.f.qqclient.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/18 22:20
 */
public class ClientConnServerThread extends Thread {
    //该线程需要持有Socket
    private Socket socket = null;
    //和socket相关联的对象输入流
    ObjectInputStream ois = null;

    public ClientConnServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //线程需要在后台和服务端通信，等待接收服务端的消息，所以需要不断循环
        while (true) {
            try {
                //System.out.println("\n客户端线程等待读取从服务端发送的消息...");
                ois = new ObjectInputStream(socket.getInputStream());
                //如果服务端没有发送消息过来，那么线程会阻塞在这里
                Message msg = (Message) ois.readObject();
                switch (msg.getMesType()) {
                    //如果读取到的Message的类型为MESSAGE_RET_ONLINE_USERS
                    case MessageType.MESSAGE_RET_ONLINE_USERS:
                        //规定返回的在线用户列表形式为 "用户1 用户2 用户3 用户4 ......"
                        String[] onlineUsers = msg.getContent().split(" ");
                        System.out.println("\n========当前在线用户列表========");
                        for (int i = 0; i < onlineUsers.length; i++) {
                            System.out.println("用户: " + onlineUsers[i]);
                        }
                        break;
                    case MessageType.MESSAGE_COMM_MSG:
                        System.out.println("\n" + msg.getSender() + " 对您说: " +
                                msg.getContent() + ", 发送时间为 " + msg.getSendTime());
                        break;
                    case MessageType.MESSAGE_PUBLIC_MSG:
                        System.out.println("\n" + msg.getSender() + " 对大家说: " +
                                msg.getContent() + ", 发送时间为 " + msg.getSendTime());
                        break;
                    case MessageType.MESSAGE_FILE_SEND:
                        System.out.println("\n" + msg.getSender() + " 向您发送文件, 文件保存路径为" + msg.getDestFilePath());
                        BufferedOutputStream clientBOS = new BufferedOutputStream(new FileOutputStream(msg.getDestFilePath()));
                        clientBOS.write(msg.getFileBytes());
                        System.out.println("文件保存成功...");
                        break;
                    case MessageType.MESSAGE_NEWS_SEND:
                        System.out.println("\n" + msg.getSender() + " 向大家发送下列消息: " + msg.getContent()
                                + ", 发送时间为 " + msg.getSendTime());
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
