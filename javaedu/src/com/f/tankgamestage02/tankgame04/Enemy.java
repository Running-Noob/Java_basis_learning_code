package com.f.tankgamestage02.tankgame04;

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

    @Override
    public void run() {
        while (true) {
            if (!isAlive()) {
                break;
            }
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
    }
}
