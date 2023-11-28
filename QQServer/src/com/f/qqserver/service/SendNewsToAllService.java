package com.f.qqserver.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author fzy
 * @date 2023/7/23 18:55
 * 服务端向全体在线用户推送消息服务
 */
public class SendNewsToAllService implements Runnable {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.print("请输入服务器要推送的消息[输入 \"exit\" 表示退出推送新闻服务]: ");
            String news = scanner.nextLine();
            if (news.equals("exit")) {
                break;
            }
            Message msg = new Message();
            msg.setSender("服务器");
            msg.setMesType(MessageType.MESSAGE_NEWS_SEND);
            msg.setContent(news);
            //设置发送时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            msg.setSendTime(sdf.format(new Date()));
            System.out.println("服务器要向所有在线用户发送消息...");
            String[] onlineUsers = ManageServerConnClientThread.getOnlineUsers().split(" ");
            for (int i = 0; i < onlineUsers.length; i++) {
                Socket gettersSocket = ManageServerConnClientThread.getServerConnClientThread(onlineUsers[i]).
                        getSocket();
                ObjectOutputStream gettersOOS = null;
                try {
                    gettersOOS = new ObjectOutputStream(gettersSocket.getOutputStream());
                    gettersOOS.writeObject(msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
