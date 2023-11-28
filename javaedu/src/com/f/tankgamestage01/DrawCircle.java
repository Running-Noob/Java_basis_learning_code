package com.f.tankgamestage01;

import javax.swing.*;
import java.awt.*;

/**
 * @author fzy
 * @date 2023/6/30 21:41
 */
public class DrawCircle extends JFrame {
    public static void main(String[] args) {
        new DrawCircle();
        new DrawCircle();
    }

    public DrawCircle() {
        this.add(new MyPanel());
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(100, 100, 100, 100);
    }
}