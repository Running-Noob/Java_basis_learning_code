package com.f.tankgamestage01.tankgame01;

/**
 * @author fzy
 * @date 2023/7/1 13:30
 */
public class Tank {
    private int x;  //̹�˵����ϽǺ�����
    private int y;  //̹�˵����Ͻ�������

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
}
