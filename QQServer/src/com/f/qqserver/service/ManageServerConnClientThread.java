package com.f.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author fzy
 * @date 2023/7/22 16:16
 * 该类用于管理服务端和客户端通信的线程
 */
public class ManageServerConnClientThread {
    private static HashMap<String, ServerConnClientThread> hm = new HashMap<>();

    public static void addServerConnClientThread(String userId, ServerConnClientThread connThread) {
        hm.put(userId, connThread);
    }

    public static void removeServerConnClientThread(String userId) {
        hm.remove(userId);
    }

    public static ServerConnClientThread getServerConnClientThread(String userId) {
        return hm.get(userId);
    }

    //返回用户列表
    public static String getOnlineUsers() {
        Set<String> onlineUsers = hm.keySet();
        StringBuffer sb = new StringBuffer();
        Iterator iterator = onlineUsers.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
