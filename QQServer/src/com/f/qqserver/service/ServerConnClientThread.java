package com.f.qqserver.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author fzy
 * @date 2023/7/22 16:00
 * 该类的一个对象和某个客户端用户保持通信
 */
public class ServerConnClientThread extends Thread {
    private Socket socket = null;
    private String userId;  //连接到服务端的用户Id
    ObjectInputStream ois = null;
    private boolean loop = true;        //控制线程循环执行的布尔变量

    public ServerConnClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() { //这里线程处于run状态，可以发送/接收消息
        while (loop) {
            try {
                System.out.println("服务端和客户端 " + userId + " 保持通信, 等待读取数据...");
                ois = new ObjectInputStream(socket.getInputStream());
                //如果客户端没有发送消息过来，那么线程会阻塞在这里
                Message msg = (Message) ois.readObject();
                switch (msg.getMesType()) {
                    case MessageType.MESSAGE_GET_ONLINE_USERS:
                        System.out.println(msg.getSender() + " 要拉取在线用户列表...");
                        Message response = new Message();
                        response.setMesType(MessageType.MESSAGE_RET_ONLINE_USERS);
                        response.setContent(ManageServerConnClientThread.getOnlineUsers());
                        response.setGetter(msg.getSender());
                        ObjectOutputStream serverOOS = new ObjectOutputStream(socket.getOutputStream());
                        serverOOS.writeObject(response);
                        break;
                    case MessageType.MESSAGE_COMM_MSG:
                        System.out.println(msg.getSender() + " 要给 " + msg.getGetter() + " 发送私聊消息...");
                        ServerConnClientThread serverConnClientThread = ManageServerConnClientThread.
                                getServerConnClientThread(msg.getGetter());
                        if (serverConnClientThread != null) {   //用户在线
                            Socket getterSocket = serverConnClientThread.getSocket();
                            ObjectOutputStream getterOOS = new ObjectOutputStream(getterSocket.getOutputStream());
                            getterOOS.writeObject(msg);
                        } else {    //用户离线
                            System.out.println("用户 " + msg.getGetter() + " 离线, 将消息暂存...");
                            if (QQServer.getOfflineMsgDB().get(msg.getGetter()) == null) {
                                ArrayList<Message> messages = new ArrayList<>();
                                messages.add(msg);
                                QQServer.getOfflineMsgDB().put(msg.getGetter(), messages);
                            } else {
                                QQServer.getOfflineMsgDB().get(msg.getGetter()).add(msg);
                            }
                        }
                        break;
                    case MessageType.MESSAGE_PUBLIC_MSG:
                        System.out.println(msg.getSender() + " 要给大家发送群发消息...");
                        String[] onlineUsers = ManageServerConnClientThread.getOnlineUsers().split(" ");
                        for (int i = 0; i < onlineUsers.length; i++) {
                            if (onlineUsers[i].equals(msg.getSender())) {
                                continue;
                            }
                            Socket gettersSocket = ManageServerConnClientThread.getServerConnClientThread(onlineUsers[i]).
                                    getSocket();
                            ObjectOutputStream gettersOOS = new ObjectOutputStream(gettersSocket.getOutputStream());
                            gettersOOS.writeObject(msg);
                        }
                        break;
                    case MessageType.MESSAGE_FILE_SEND:
                        System.out.println(msg.getSender() + " 要给 " + msg.getGetter() + " 发送文件...");
                        Socket fileGetterSocket = ManageServerConnClientThread.getServerConnClientThread(msg.getGetter()).
                                getSocket();
                        ObjectOutputStream fileGetterOOS = new ObjectOutputStream(fileGetterSocket.getOutputStream());
                        fileGetterOOS.writeObject(msg);
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        System.out.println("用户 " + msg.getSender() + " 退出, 关闭相关线程...");
                        socket.close();
                        ManageServerConnClientThread.removeServerConnClientThread(msg.getSender());
                        loop = false;
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
