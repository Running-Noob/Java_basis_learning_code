package com.f.qqcommon;

import java.io.Serializable;

/**
 * @author fzy
 * @date 2023/7/18 20:32
 * 表示客户端和服务端通信时的消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sender;      //发送者
    private String getter;      //接收者
    private String content;     //消息内容
    private String sendTime;    //发送时间
    private String mesType;     //消息类型
    //进行扩展, 增加和文件相关的成员变量
    private byte[] fileBytes;   //文件内容
    private int fileLen;        //文件大小
    private String srcFilePath; //文件源路径
    private String destFilePath;    //文件目的路径

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getSrcFilePath() {
        return srcFilePath;
    }

    public void setSrcFilePath(String srcFilePath) {
        this.srcFilePath = srcFilePath;
    }

    public String getDestFilePath() {
        return destFilePath;
    }

    public void setDestFilePath(String destFilePath) {
        this.destFilePath = destFilePath;
    }
}
