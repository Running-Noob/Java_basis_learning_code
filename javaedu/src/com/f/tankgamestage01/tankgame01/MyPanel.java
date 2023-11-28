package com.f.tankgamestage01.tankgame01;

import javax.swing.*;
import java.awt.*;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */
public class MyPanel extends JPanel {
    Hero hero;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBackGround(g, 1080, 960);
        drawTank(hero.getX(), hero.getY(), g, TankType.HERO, TankDirect.UP);
        drawTank(hero.getX() + 100, hero.getY(), g, TankType.Enemy, TankDirect.UP);
    }

    /**
     * ���Ʊ���
     * @param width  �����Ŀ��
     * @param height �����ĸ߶�
     */
    public void drawBackGround(Graphics g, int width, int height) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);
    }

    /**
     * ����̹��
     * @param x      ̹�˵����ϽǺ�����
     * @param y      ̹�˵����Ͻ�������
     * @param g      ����
     * @param type   ̹�˵�����
     * @param direct ̹�˵ķ���
     */
    public void drawTank(int x, int y, Graphics g, TankType type, TankDirect direct) {
        switch (type) {
            case HERO:
                g.setColor(Color.cyan);
                break;
            case Enemy:
                g.setColor(Color.yellow);
                break;
        }

        switch (direct) {
            case UP:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
        }
    }
}
