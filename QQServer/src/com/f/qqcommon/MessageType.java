package com.f.qqcommon;

/**
 * @author fzy
 * @date 2023/7/18 20:44
 * 消息类型
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1";     //表示登陆成功
    String MESSAGE_LOGIN_FAILURE = "2";     //表示登录失败
    String MESSAGE_COMM_MSG = "3";          //普通消息包
    String MESSAGE_GET_ONLINE_USERS = "4";  //要求返回在线用户列表
    String MESSAGE_RET_ONLINE_USERS = "5";  //返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6";       //客户端请求退出
    String MESSAGE_PUBLIC_MSG = "7";        //群发消息包
    String MESSAGE_FILE_SEND = "8";         //发送文件
    String MESSAGE_NEWS_SEND = "9";         //服务端推送消息
}