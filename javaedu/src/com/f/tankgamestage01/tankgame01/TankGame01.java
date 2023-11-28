package com.f.tankgamestage01.tankgame01;

import javax.swing.*;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */
public class TankGame01 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1080, 960);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
