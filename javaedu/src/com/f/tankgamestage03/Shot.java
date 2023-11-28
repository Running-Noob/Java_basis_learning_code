package com.f.tankgamestage03;

/**
 * @author fzy
 * @date 2023/7/5 13:25
 * 射击子弹
 */
public class Shot implements Runnable {
    private int x;  //子弹x坐标
    private int y;  //子弹y坐标
    private ShotDirect shotDirect;  //子弹射击方向
    private int speed = 5;  //子弹速度
    private boolean isAlive = true; //子弹是否存在

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ShotDirect getShotDirect() {
        return shotDirect;
    }

    public void setShotDirect(ShotDirect shotDirect) {
        this.shotDirect = shotDirect;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (shotDirect) {
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
            }
            //当子弹碰到边界或击中坦克时，线程结束
            if (!((x >= 0 && x <= 1080) && (y >= 0 && y <= 960) && isAlive)) {
                isAlive = false;
                break;
            }
        }
    }
}
