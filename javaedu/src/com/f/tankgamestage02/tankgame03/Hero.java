package com.f.tankgamestage02.tankgame03;

import java.util.ArrayList;

/**
 * @author fzy
 * @date 2023/7/1 13:32
 */
public class Hero extends Tank {
    private ArrayList<Shot> shots = new ArrayList<>();   //����һ��shot���󣬱�ʾһ������߳�

    public Hero(int x, int y) {
        super(x, y);
    }

    public ArrayList<Shot> getShots() {
        return shots;
    }

    public void shotEnemyTank() {
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
        shots.add(shot);
    }
}
