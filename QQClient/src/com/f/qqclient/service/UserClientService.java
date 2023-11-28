package com.f.qqclient.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;
import com.f.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author fzy
 * @date 2023/7/18 21:55
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {
    private User user = new User();
    private Socket socket = null;

    //根据 userId 和 pwd, 到服务端验证用户是否合法
    public boolean checkUser(String userId, String pwd) throws IOException, ClassNotFoundException {
        boolean connResult = false;
        user.setUserId(userId);
        user.setPwd(pwd);
        //连接到服务端，发送User对象
        socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
        ObjectOutputStream clientOOS = new ObjectOutputStream(socket.getOutputStream());
        clientOOS.writeObject(user);    //发送user对象给服务端
        //读取从服务端回送的Message对象
        ObjectInputStream clientOIS = new ObjectInputStream(socket.getInputStream());
        Message responseMsg = (Message) clientOIS.readObject();
        if (responseMsg.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
            //如果登录成功, 创建一个和服务端保持通信的线程
            ClientConnServerThread connThread = new ClientConnServerThread(socket);
            //启动客户端的线程
            connThread.start();
            //由于一个客户端可能会有多个socket(专门用于聊天的、专门用于发送文件的、等...), 所以将线程放入集合中管理
            ManageClientConnServerThread.addClientConnServerThread(userId, connThread);
            connResult = true;
        } else if (responseMsg.getMesType().equals(MessageType.MESSAGE_LOGIN_FAILURE)) {
            //如果登录失败, 就不能启动客户端和服务端通信的线程, 关闭 socket
            System.out.println("登陆失败,socket关闭...");
            socket.close();
        }
        return connResult;
    }

    //向服务端请求在线用户列表
    public void onlineUsersList() throws IOException {
        //客户端向服务端发送一个Message对象，该对象类型为MessageType.MESSAGE_GET_ONLINE_USERS
        Message msg = new Message();
        msg.setMesType(MessageType.MESSAGE_GET_ONLINE_USERS);
        msg.setSender(user.getUserId());
        ObjectOutputStream clientOOS = new ObjectOutputStream(socket.getOutputStream());
        clientOOS.writeObject(msg);    //发送Message对象给服务端, 请求在线用户列表
    }

    //向服务端发送退出系统的消息
    public void logout() throws IOException {
        Message msg = new Message();
        msg.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        msg.setSender(user.getUserId());
        ObjectOutputStream clientOOS = new ObjectOutputStream(socket.getOutputStream());
        clientOOS.writeObject(msg);    //发送Message对象给服务端, 表示线程结束退出
        ManageClientConnServerThread.removeClientConnServerThread(user.getUserId());
        System.out.println(user.getUserId() + " 退出系统...");
    }
}
