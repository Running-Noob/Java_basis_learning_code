package com.f.tankgamestage02.tankgame05;

import javax.swing.*;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */
public class TankGame05 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame05 tankGame05 = new TankGame05();
    }

    public TankGame05() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1080, 960);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        new Thread(mp).start(); //����mp�߳�
    }
}
