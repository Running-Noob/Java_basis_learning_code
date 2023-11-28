package com.f.tankgamestage02.tankgame04;

import java.util.Vector;

/**
 * @author fzy
 * @date 2023/7/1 13:30
 */
public class Tank {
    private int x;  //̹�˵����ϽǺ�����
    private int y;  //̹�˵����Ͻ�������
    private TankDirect direct = TankDirect.UP;  //̹�˵ķ���
    private int speed = 10;  //̹�˵��ƶ��ٶ�

    private boolean isAlive = true;

    private Vector<Shot> shots = new Vector<>();   //����Shot���󼯺ϣ�ÿ��Shot�����ʾһ������߳�

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TankDirect getDirect() {
        return direct;
    }

    public void setDirect(TankDirect direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }
}
