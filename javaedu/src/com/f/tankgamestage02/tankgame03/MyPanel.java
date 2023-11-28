package com.f.tankgamestage02.tankgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author fzy
 * @date 2023/7/1 13:28
 */

//Ϊ����MyPanel��ͣ���ػ��ӵ�����Ҫ��MyPanelʵ��Runnable�ӿڣ�����һ���߳�ʹ��
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //�����Լ���̹��
    Hero hero;
    //������˵�̹�ˣ����뵽Vector(��ΪҪ�漰���߳�)
    Vector<Enemy> enemies = new Vector<>();
    int enemyNum = 3;   //����̹�˵�����

    public MyPanel() {
        hero = new Hero(540, 800);
        for (int i = 0; i < enemyNum; i++) {
            Enemy enemy = new Enemy((i + 1) * 100, 0, TankDirect.DOWN);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBackGround(g, 1080, 960);
        //�����Լ���̹��
        drawTank(hero.getX(), hero.getY(), g, TankType.HERO, hero.getDirect());
        //�������˵�̹��
        for (Enemy enemy : enemies) {
            drawTank(enemy.getX(), enemy.getY(), g, TankType.Enemy, enemy.getDirect());
        }
        //����Hero������������ӵ�
        if (!(hero.getShots().isEmpty())) {
            for (Shot shot : hero.getShots()) {
                if (shot.isAlive()) {
                    g.setColor(Color.orange);
                    g.drawRect(shot.getX(), shot.getY(), 1, 1);
                } else {
                    hero.getShots().remove(shot);
                }
            }
        }
    }

    /**
     * ���Ʊ���
     *
     * @param width  �����Ŀ��
     * @param height �����ĸ߶�
     */
    public void drawBackGround(Graphics g, int width, int height) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);
    }

    /**
     * ����̹��
     *
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
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case LEFT:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            case RIGHT:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((char) e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(TankDirect.UP);  //�޸�̹�˵ķ���
            hero.moveUp();
        } else if ((char) e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(TankDirect.DOWN);
            hero.moveDown();
        } else if ((char) e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(TankDirect.LEFT);
            hero.moveLeft();
        } else if ((char) e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(TankDirect.RIGHT);
            hero.moveRight();
        }
        //����û����µ���J������Ҫ�Լ���̹�˷����ӵ�
        if ((char) e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //ÿ��100ms���ػ�һ��
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }
    }
}
