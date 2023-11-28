package com.f.qqclient.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fzy
 * @date 2023/7/23 14:23
 * 该类完成消息发送相关的功能
 */
public class MessageClientService {
    //向另一个在线用户发送私聊消息
    public void privateChat(String senderId, String getterId, String chatContent) {
        Message msg = new Message();
        msg.setSender(senderId);
        msg.setGetter(getterId);
        msg.setContent(chatContent);
        //设置发送时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        msg.setSendTime(sdf.format(new Date()));
        msg.setMesType(MessageType.MESSAGE_COMM_MSG);
        System.out.println(senderId + " 对 " + getterId + " 说: " + chatContent);
        try {
            ObjectOutputStream clientOOS = new ObjectOutputStream(ManageClientConnServerThread.
                    getClientConnServerThread(senderId).getSocket().getOutputStream());
            clientOOS.writeObject(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //向所有其他在线用户发送群聊消息
    public void publicChat(String senderId, String publicChatContent) {
        Message msg = new Message();
        msg.setSender(senderId);
        msg.setContent(publicChatContent);
        //设置发送时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        msg.setSendTime(sdf.format(new Date()));
        msg.setMesType(MessageType.MESSAGE_PUBLIC_MSG);
        System.out.println(senderId + " 对大家说: " + publicChatContent);
        try {
            ObjectOutputStream clientOOS = new ObjectOutputStream(ManageClientConnServerThread.
                    getClientConnServerThread(senderId).getSocket().getOutputStream());
            clientOOS.writeObject(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
