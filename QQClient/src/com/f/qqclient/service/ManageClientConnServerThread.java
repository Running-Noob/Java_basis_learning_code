package com.f.qqclient.service;

import java.util.HashMap;

/**
 * @author fzy
 * @date 2023/7/22 11:50
 * 该类管理客户端连接到服务端的线程
 */
public class ManageClientConnServerThread {
    //把客户端的多个线程放入到 hm 中, key 是用户 Id, value 是一个 ClientConnServerThread 线程
    private static HashMap<String, ClientConnServerThread> hm = new HashMap<>();

    //将某个线程加入集合
    public static void addClientConnServerThread(String uerId, ClientConnServerThread connThread) {
        hm.put(uerId, connThread);
    }

    //将某个线程移除
    public static void removeClientConnServerThread(String userId) {
        hm.remove(userId);
    }

    //通过 uerId, 从集合中取出对应线程
    public static ClientConnServerThread getClientConnServerThread(String userId) {
        return hm.get(userId);
    }
}
