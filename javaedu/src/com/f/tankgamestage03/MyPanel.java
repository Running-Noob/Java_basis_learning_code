package com.f.tankgamestage03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
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
    int enemyNum = 6;   //����̹�˵�����
    Vector<Node> nodes = new Vector<>();    //���ڻָ�����̹�˵�����ͷ���

    Vector<Bomb> bombs = new Vector<>();    //���ڴ��ը�������ӵ�����̹��ʱ���ͼ���һ��Bomb����
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String choice) {
        hero = new Hero(540, 800);
        if (choice.equals("1")) {
            for (int i = 0; i < enemyNum; i++) {
                Enemy enemy = new Enemy((i + 1) * 100, 0, TankDirect.DOWN);
                enemies.add(enemy);
                new Thread(enemy).start();
                ////��Enemy�������һ���ӵ�
                //Shot shot = new Shot(enemy.getX() + 20, enemy.getY() + 60);
                //shot.setShotDirect(ShotDirect.DOWN);
                //enemy.getShots().add(shot);
                //new Thread(shot).start();
            }
        } else if (choice.equals("2")) {
            try {
                nodes = Recorder.loadRecord();
            } catch (IOException e) {
                System.out.println("��δ������һ����Ϸ�����ȿ�ʼ����Ϸ��");
                System.exit(0);
            }
            enemyNum = enemyNum - Recorder.getDestoryEnemyNum();    //ʣ��̹������
            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                Enemy enemy = new Enemy(node.getX(), node.getY(), node.getTankDirect());
                enemies.add(enemy);
                new Thread(enemy).start();
            }
        } else {
            System.out.println("��������...");
            System.out.println("�˳�...");
            System.exit(0);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).setEnemies(enemies);
        }
        Recorder.setEnemies(enemies);
        //image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.jpg"));
        //image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.jpg"));
        //image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.jpg"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBackGround(g, 1080, 960);
        //�����Լ���̹��
        if (hero.isAlive()) {
            drawTank(hero.getX(), hero.getY(), g, TankType.HERO, hero.getDirect());
        }
        //�������˵�̹�˼�������ӵ�
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.isAlive()) {
                drawTank(enemy.getX(), enemy.getY(), g, TankType.Enemy, enemy.getDirect());
            } else {
                enemies.remove(i);  //���̹�˱������ˣ���Ҫ�Ӽ�����ɾ��
            }
            drawTankShots(enemy, g, TankType.Enemy);
        }
        //�����Լ�̹�˷�����ӵ�
        drawTankShots(hero, g, TankType.HERO);
        //̹�˱����к�ı�ըЧ��
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);   //ȡ��ը��
            if (bomb.isAlive()) {
                //���ݵ�ǰ���bomb��lifeTime��������Ӧ��ͼƬ
                if (bomb.getLifeTime() > 6) {
                    g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
                } else if (bomb.getLifeTime() > 3) {
                    g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
                } else {
                    g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
                }
            } else {
                bombs.remove(i);
            }
            bomb.lifeDown();
        }
        //��ʾ���ٵз�̹�˵���Ϣ
        showInfo(g);
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

    public void drawTankShots(Tank tank, Graphics g, TankType tankType) {
        switch (tankType) {
            case HERO:
                g.setColor(Color.orange);
                break;
            case Enemy:
                g.setColor(Color.GREEN);
        }
        if (!(tank.getShots().isEmpty())) {
            for (int i = 0; i < tank.getShots().size(); i++) {
                Shot shot = tank.getShots().get(i);
                if (shot.isAlive()) {
                    g.drawRect(shot.getX(), shot.getY(), 1, 1);
                } else {
                    tank.getShots().remove(i);
                }
            }
        }
    }

    //��д�������ж��ӵ��Ƿ����̹��
    public boolean hitTank(Shot shot, Tank tank) {
        if (!tank.isAlive()) {
            return false;
        }
        switch (tank.getDirect()) {
            case UP:
            case DOWN:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40 &&
                        shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60) {
                    shot.setAlive(false);
                    tank.setAlive(false);
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    return true;
                }
            case LEFT:
            case RIGHT:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60 &&
                        shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40) {
                    shot.setAlive(false);
                    tank.setAlive(false);
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    return true;
                }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!hero.isAlive()) {
            return;
        }
        if ((char) e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(TankDirect.UP);  //�޸�̹�˵ķ���
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if ((char) e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(TankDirect.DOWN);
            if (hero.getY() + 60 < 960) {
                hero.moveDown();
            }
        } else if ((char) e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(TankDirect.LEFT);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        } else if ((char) e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(TankDirect.RIGHT);
            if (hero.getX() + 60 < 1080) {
                hero.moveRight();
            }
        }
        //����û����µ���J������Ҫ�ҷ�̹�˷����ӵ�
        if ((char) e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //�ж��ҷ��ӵ��Ƿ���е���̹��
            for (Shot shot : hero.getShots()) {
                for (Enemy enemyTank : enemies) {
                    if (hitTank(shot, enemyTank)) {
                        Recorder.addDestoryEnemyNum();
                    }
                }
            }
            //�жϵз��ӵ��Ƿ�����ҷ�̹��
            for (Enemy enemy : enemies) {
                for (Shot shot : enemy.getShots()) {
                    hitTank(shot, hero);
                }
            }

            //ÿ��50ms���ػ�һ��
            this.repaint();
        }
    }

    //��д��������ʾ�ҷ����ٵз�̹�˵���Ϣ
    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("����", Font.BOLD, 25));
        g.drawString("���ۼƻ��ٵз�̹�ˣ�", 1100, 40);
        drawTank(1120, 70, g, TankType.Enemy, TankDirect.UP);
        g.setColor(Color.black);
        g.drawString(" X " + Recorder.getDestoryEnemyNum() + "", 1180, 110);
    }
}