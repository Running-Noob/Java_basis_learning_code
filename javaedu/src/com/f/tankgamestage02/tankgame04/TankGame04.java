package com.f.tankgamestage02.tankgame04;

import javax.swing.*;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */
public class TankGame04 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame04 tankGame04 = new TankGame04();
    }

    public TankGame04() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1080, 960);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        new Thread(mp).start(); //����mp�߳�
    }
}
