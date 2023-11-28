package com.f.qqclient.view;

import com.f.qqclient.service.FileClientService;
import com.f.qqclient.service.MessageClientService;
import com.f.qqclient.service.UserClientService;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author fzy
 * @date 2023/7/18 20:55
 * 客户端的菜单界面
 */
public class QQView {
    Scanner scanner = new Scanner(System.in);
    private boolean loop = true;
    private String key = "";
    private UserClientService userClientService = new UserClientService();  //用于登录服务器或注册用户
    private MessageClientService messageClientService = new MessageClientService(); //用于私聊或群发消息
    private FileClientService fileClientService = new FileClientService();  //用于文件传输服务

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new QQView().mainMenu();
        System.exit(0);
    }

    //显示主菜单
    public void mainMenu() throws IOException, ClassNotFoundException {
        while (loop) {
            System.out.println("========欢迎登录网络通信系统========");
            System.out.println("\t\t 1.登陆系统");
            System.out.println("\t\t 9.退出系统");
            System.out.print("请输入你的选择: ");
            key = scanner.nextLine();
            switch (key) {
                case "1":
                    System.out.print("请输入用户名: ");
                    String userId = scanner.nextLine();
                    System.out.print("请输入密 码: ");
                    String pwd = scanner.nextLine();
                    //将用户对象发送给服务器，判断用户对象是否合法
                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("========欢迎 " + userId + " 用户!========");
                        while (loop) {
                            System.out.println("========网络通信系统二级菜单(用户 " + userId + " )========");
                            System.out.println("\t\t 1.显示在线用户列表");
                            System.out.println("\t\t 2.群发消息");
                            System.out.println("\t\t 3.私聊消息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择: ");
                            key = scanner.nextLine();
                            switch (key) {
                                case "1":
                                    userClientService.onlineUsersList();
                                    break;
                                case "2":
                                    System.out.print("请输入想要对大家说的话: ");
                                    String publicChatContent = scanner.nextLine();
                                    messageClientService.publicChat(userId, publicChatContent);
                                    break;
                                case "3":
                                    System.out.print("请输入想要聊天的用户(在线): ");
                                    String getterId = scanner.nextLine();
                                    System.out.print("请输入想说的话: ");
                                    String chatContent = scanner.nextLine();
                                    messageClientService.privateChat(userId, getterId, chatContent);
                                    break;
                                case "4":
                                    System.out.print("请输入您想把文件发送给的用户(在线): ");
                                    String fileGetterId = scanner.nextLine();
                                    System.out.print("请输入发送的文件的完整路径: ");
                                    String src = scanner.nextLine();
                                    System.out.print("请输入发送的文件到对方的路径: ");
                                    String dest = scanner.nextLine();
                                    if (fileClientService.sendFile(userId, fileGetterId, src, dest)) {
                                        System.out.println("您要发送给 " + fileGetterId + " 用户的文件已发送...");
                                    }
                                    break;
                                case "9":
                                    systemExit();
                                    break;
                            }
                        }
                    } else {
                        System.out.println("用户名/密码不正确, 请重新选择: ");
                    }
                    break;
                case "9":
                    loop = false;
                    System.out.println("已经退出系统...");
                    break;
            }
        }
    }

    public void systemExit() throws IOException {
        userClientService.logout();
        loop = false;
    }
}
