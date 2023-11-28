package com.f.tankgamestage02.tankgame04;

/**
 * @author fzy
 * @date 2023/7/5 13:25
 * ����ӵ�
 */
public class Shot implements Runnable {
    private int x;  //�ӵ�x����
    private int y;  //�ӵ�y����
    private ShotDirect shotDirect;  //�ӵ��������
    private int speed = 5;  //�ӵ��ٶ�
    private boolean isAlive = true;

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
            //���ӵ������߽�����̹��ʱ���߳̽���
            if (!((x >= 0 && x <= 1080) && (y >= 0 && y <= 960) && isAlive)) {
                isAlive = false;
                break;
            }
        }
    }
}
