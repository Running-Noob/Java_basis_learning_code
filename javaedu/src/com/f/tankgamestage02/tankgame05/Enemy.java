package com.f.tankgamestage02.tankgame05;

/**
 * @author fzy
 * @date 2023/7/1 16:49
 */
public class Enemy extends Tank implements Runnable {

    private int step = 10;  //̹����һ�����������˶��Ĵ���

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(int x, int y, TankDirect direct) {
        super(x, y);
        this.setDirect(direct);
    }

    public void enemyTankMove() {
        //����̹�˵ķ����������ƶ�
        switch (getDirect()) {
            case UP:
                //forѭ�����ڱ�֤̹���˶��ĺ�����
                for (int i = 0; i < step; i++) {
                    if (getY() > 0) {
                        moveUp();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < step; i++) {
                    if (getY() + 60 < 960) {
                        moveDown();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i < step; i++) {
                    if (getX() > 0) {
                        moveLeft();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < step; i++) {
                    if (getX() + 60 < 1080) {
                        moveRight();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
        //Ȼ������ظı�̹�˵ķ���
        int ran = (int) (Math.random() * 4 + 1);
        switch (ran) {
            case 1:
                setDirect(TankDirect.UP);
                break;
            case 2:
                setDirect(TankDirect.DOWN);
                break;
            case 3:
                setDirect(TankDirect.LEFT);
                break;
            case 4:
                setDirect(TankDirect.RIGHT);
        }
    }

    public void enemyTankShot() {
        if (getShots().size() >= 5) {   //������෢������ӵ�
            return;
        }
        Shot shot = null;
        switch (getDirect()) {
            case UP:
                shot = new Shot(getX() + 20, getY());
                shot.setShotDirect(ShotDirect.UP);
                break;
            case DOWN:
                shot = new Shot(getX() + 20, getY() + 60);
                shot.setShotDirect(ShotDirect.DOWN);
                break;
            case LEFT:
                shot = new Shot(getX(), getY() + 20);
                shot.setShotDirect(ShotDirect.LEFT);
                break;
            case RIGHT:
                shot = new Shot(getX() + 60, getY() + 20);
                shot.setShotDirect(ShotDirect.RIGHT);
        }
        Thread shotThread = new Thread(shot);
        shotThread.start();
        getShots().add(shot);
    }

    @Override
    public void run() {
        while (true) {
            if (!isAlive()) {
                break;
            }
            enemyTankMove();
            enemyTankShot();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
