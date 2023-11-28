package com.f.qqframe;

import com.f.qqserver.service.QQServer;

/**
 * @author fzy
 * @date 2023/7/22 16:43
 * 该类创建一个QQServer对象，相当于启动了QQ服务端
 */
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}
