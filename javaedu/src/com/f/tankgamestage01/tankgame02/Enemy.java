package com.f.tankgamestage01.tankgame02;

/**
 * @author fzy
 * @date 2023/7/1 16:49
 */
public class Enemy extends Tank {
    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(int x, int y, TankDirect direct) {
        super(x, y);
        this.setDirect(direct);
    }
}
