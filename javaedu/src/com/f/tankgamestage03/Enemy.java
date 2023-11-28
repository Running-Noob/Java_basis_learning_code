package com.f.tankgamestage03;

import java.util.Vector;

/**
 * @author fzy
 * @date 2023/7/1 16:49
 */
public class Enemy extends Tank implements Runnable {

    private int step = 10;  //̹����һ�����������˶��Ĵ���
    private Vector<Enemy> enemies = new Vector<>();

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(int x, int y, TankDirect direct) {
        super(x, y);
        this.setDirect(direct);
    }

    public Vector<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(Vector<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void enemyTankMove() {
        //����̹�˵ķ����������ƶ�
        switch (getDirect()) {
            case UP:
                //forѭ�����ڱ�֤̹���˶��ĺ�����
                for (int i = 0; i < step; i++) {
                    if (getY() > 0 && !isTouchEnemy()) {
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
                    if (getY() + 60 < 960 && !isTouchEnemy()) {
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
                    if (getX() > 0 && !isTouchEnemy()) {
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
                    if (getX() + 60 < 1080 && !isTouchEnemy()) {
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

    //��д�������жϸ�̹���Ƿ�������̹�˷�����ײ
    public boolean isTouchEnemy() {
        switch (this.getDirect()) {
            case UP:
            case DOWN:
                for (Enemy enemy : enemies) {
                    if (enemy.equals(this)) {
                        continue;
                    }
                    if (enemy.getDirect() == TankDirect.UP || enemy.getDirect() == TankDirect.DOWN) {
                        //����̹�˵ĺ����귶Χ��[enemy.getX(), enemy.getX() + 40]
                        //����̹�˵������귶Χ��[enemy.getY(), enemy.getY() + 60]
                        if ((this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 40)
                                || (this.getX() + 40 >= enemy.getX() && this.getX() + 40 <= enemy.getX() + 40)) {
                            if ((this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 60)
                                    || (this.getY() + 60 >= enemy.getY() && this.getY() + 60 <= enemy.getY() + 60)) {
                                return true;
                            }
                        }
                    }
                    if (enemy.getDirect() == TankDirect.LEFT || enemy.getDirect() == TankDirect.RIGHT) {
                        //����̹�˵ĺ����귶Χ��[enemy.getX(), enemy.getX() + 60]
                        //����̹�˵������귶Χ��[enemy.getY(), enemy.getY() + 40]
                        if ((this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 60)
                                || (this.getX() + 40 >= enemy.getX() && this.getX() + 40 <= enemy.getX() + 60)) {
                            if ((this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 40)
                                    || (this.getY() + 60 >= enemy.getY() && this.getY() + 60 <= enemy.getY() + 40)) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case LEFT:
            case RIGHT:
                for (Enemy enemy : enemies) {
                    if (enemy.equals(this)) {
                        continue;
                    }
                    if (enemy.getDirect() == TankDirect.UP || enemy.getDirect() == TankDirect.DOWN) {
                        //����̹�˵ĺ����귶Χ��[enemy.getX(), enemy.getX() + 40]
                        //����̹�˵������귶Χ��[enemy.getY(), enemy.getY() + 60]
                        if ((this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 60)
                                || (this.getY() + 40 >= enemy.getY() && this.getY() + 40 <= enemy.getY() + 60)) {
                            if ((this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 40)
                                    || (this.getX() + 60 >= enemy.getX() && this.getX() + 60 <= enemy.getX() + 40)) {
                                return true;
                            }
                        }
                    }
                    if (enemy.getDirect() == TankDirect.LEFT || enemy.getDirect() == TankDirect.RIGHT) {
                        //����̹�˵ĺ����귶Χ��[enemy.getX(), enemy.getX() + 60]
                        //����̹�˵������귶Χ��[enemy.getY(), enemy.getY() + 40]
                        if ((this.getY() >= enemy.getY() && this.getY() <= enemy.getY() + 40)
                                || (this.getY() + 40 >= enemy.getY() && this.getY() + 40 <= enemy.getY() + 40)) {
                            if ((this.getX() >= enemy.getX() && this.getX() <= enemy.getX() + 60)
                                    || (this.getX() + 60 >= enemy.getX() && this.getX() + 60 <= enemy.getX() + 60)) {
                                return true;
                            }
                        }
                    }
                }
        }
        return false;
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
