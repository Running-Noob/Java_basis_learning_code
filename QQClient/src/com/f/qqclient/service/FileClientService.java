package com.f.qqclient.service;

import com.f.qqcommon.Message;
import com.f.qqcommon.MessageType;
import com.f.qqutils.StreamUtils;

import java.io.*;


/**
 * @author fzy
 * @date 2023/7/23 15:54
 * 该类完成文件发送相关的功能
 */
public class FileClientService {
    /**
     * @param senderId 文件发送方
     * @param getterId 文件接收方
     * @param src      文件发送路径
     * @param dest     文件接受路径
     */
    public boolean sendFile(String senderId, String getterId, String src, String dest) throws IOException {
        //1.从磁盘读取文件
        File file = new File(src);
        if (!file.exists()) {
            System.out.println(src + " 路径的文件不存在, 请重试...");
            return false;
        }
        BufferedInputStream fileBIS = new BufferedInputStream(new FileInputStream(file));
        byte[] fileBytes = StreamUtils.streamToByteArray(fileBIS);
        //2.将文件封装到 Message 对象中, 进行发送
        Message msg = new Message();
        msg.setSender(senderId);
        msg.setGetter(getterId);
        msg.setFileBytes(fileBytes);
        msg.setSrcFilePath(src);
        msg.setDestFilePath(dest);
        msg.setMesType(MessageType.MESSAGE_FILE_SEND);
        ObjectOutputStream clientOOS = new ObjectOutputStream(ManageClientConnServerThread.
                getClientConnServerThread(senderId).getSocket().getOutputStream());
        clientOOS.writeObject(msg);
        return true;
    }
}
