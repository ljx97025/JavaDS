package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Bullet
 * @Author : ljx
 * @Date: 2021/9/11 21:37
 * @Description : 子弹类
 */
public class Bullet {
    private int x;
    private int y;
    private Dir dir;
    private boolean living = true;
    private TankFrame tf=null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        if (!living) {
            tf.bulletList.remove(this);
        }
        g.fillOval(x,y,25,25);
        if (x<0 || y<0 || x>tf.GAME_WIDTH || y<tf.GAME_HEIGHT) {
            living = false;
        }
    }

    public void move(){

    }
}
