package com.f.tankgamestage01.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author fzy
 * @date 2023/7/1 14:10
 * ͨ�����̿���С���������ҵ��ƶ�
 */

//����JFrame, ���ڷ������JPanel
public class BallMove extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(600, 400);
        //addKeyListenerʹ��JFrame���ڶ�����Լ���mp��巢���ļ����¼�
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//���JPanel, ���ڽ���ͼ�����
//Graphics g ���Կ����ǻ���
//KeyListener, �Ǽ��������¼��ļ�����
class MyPanel extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }


    //���ַ����ʱ���÷����ͻᱻ����
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //��ĳ��������ʱ���÷����ͻᱻ����
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char) e.getKeyCode() + "������...");
        //�����û����µĲ�ͬ��(��������)��������С����ƶ�
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        //���»��ƣ�ˢ��֮ǰ��֡
        this.repaint();
    }

    //��ĳ�����ɿ�ʱ���÷����ͻᱻ����
    @Override
    public void keyReleased(KeyEvent e) {

    }
}