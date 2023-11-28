package com.f.tankgamestage03;

/**
 * @author fzy
 * @date 2023/7/5 20:57
 */
public class Bomb {
    private int x;
    private int y;
    private int lifeTime = 9;
    private boolean isAlive = true;

    public Bomb(int x, int y) {
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

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void lifeDown() {
        lifeTime--;
        if (lifeTime < 0) {
            isAlive = false;
        }
    }
}
