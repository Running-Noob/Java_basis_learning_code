package com.f.qqserver.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;
import com.f.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author fzy
 * @date 2023/7/22 15:47
 * 服务端, 监听 9999 端口, 等待客户端的连接, 并保持通信
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    //用于存放合法用户，模拟数据库
    private static HashMap<String, User> validUsers = new HashMap<>();
    private static HashMap<String, ArrayList<Message>> offlineMsgDB = new HashMap<>();
    private static int port = 9999;

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));
    }

    public QQServer() {
        System.out.println("服务端在 " + port + " 端口监听...");
        Thread sendNewsThread = new Thread(new SendNewsToAllService());
        sendNewsThread.start();
        try {
            serverSocket = new ServerSocket(port);
            while (true) {  //当和某个客户端连接后，会继续监听端口
                Socket socket = serverSocket.accept();  //如果没有客户端连接，则会阻塞在这里
                ObjectInputStream serverOIS = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream serverOOS = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) serverOIS.readObject();  //读取客户端发送的User对象
                //用于回复客户端的Message对象
                Message msg = new Message();
                //验证用户是否合法
                if (validUsers.containsKey(user.getUserId())    //模拟数据库中是否包含用户
                        && validUsers.get(user.getUserId()).getPwd().equals(user.getPwd())) {   //用户名密码正确
                    msg.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    serverOOS.writeObject(msg);
                    //如果用户合法，就创建一个线程，和该客户端保持通信
                    ServerConnClientThread connThread = new ServerConnClientThread(socket, user.getUserId());
                    connThread.start();
                    //将该线程对象加入集合进行管理
                    ManageServerConnClientThread.addServerConnClientThread(user.getUserId(), connThread);
                    //检查该用户在离线时是否有收到消息
                    checkOfflineMsg(user.getUserId());
                } else {
                    msg.setMesType(MessageType.MESSAGE_LOGIN_FAILURE);
                    serverOOS.writeObject(msg);
                    socket.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            //如果服务端退出While循环，则说明服务端不再监听，因此关闭ServerSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static HashMap<String, ArrayList<Message>> getOfflineMsgDB() {
        return offlineMsgDB;
    }

    //检查该用户在离线时是否有收到消息
    public static void checkOfflineMsg(String userId) throws IOException {
        ArrayList<Message> messages = null;
        if ((messages = offlineMsgDB.get(userId)) != null) {
            for (int i = 0; i < messages.size(); i++) {
                Message msg = messages.get(i);
                Socket getterSocket = ManageServerConnClientThread.getServerConnClientThread(msg.getGetter()).getSocket();
                ObjectOutputStream getterOOS = new ObjectOutputStream(getterSocket.getOutputStream());
                getterOOS.writeObject(msg);
            }
        }
    }
}
