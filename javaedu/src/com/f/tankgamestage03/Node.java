package com.f.tankgamestage03;

/**
 * @author fzy
 * @date 2023/7/13 21:38
 * һ��Node�����ʾһ������̹�˵���Ϣ
 */
public class Node {
    private int x;
    private int y;
    private TankDirect tankDirect;

    public Node(int x, int y, TankDirect tankDirect) {
        this.x = x;
        this.y = y;
        this.tankDirect = tankDirect;
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

    public TankDirect getTankDirect() {
        return tankDirect;
    }

    public void setTankDirect(TankDirect tankDirect) {
        this.tankDirect = tankDirect;
    }
}
