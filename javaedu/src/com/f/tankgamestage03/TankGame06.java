package com.f.tankgamestage03;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */
public class TankGame06 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        System.out.println("��ѡ��1.��ʼ����Ϸ��2.�����Ͼ���Ϸ");
        Scanner scanner = new Scanner(System.in);
        TankGame06 tankGame06 = new TankGame06(scanner.next());
    }

    public TankGame06(String choice) {
        mp = new MyPanel(choice);
        this.add(mp);
        //this.setSize(1080, 960);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   //�������
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.keepRecord();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });
        new Thread(mp).start(); //����mp�߳�
    }
}
