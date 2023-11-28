package com.f.tankgamestage01.tankgame02;

import javax.swing.*;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */
public class TankGame02 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame02 tankGame02 = new TankGame02();
    }

    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1080, 960);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
