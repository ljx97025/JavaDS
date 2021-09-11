package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Bullet
 * @Author : ljx
 * @Date: 2021/9/11 9:02
 * @Description : 子弹类
 */
public class Bullet {
    private int x;
    private int y;
    private Dir dir;
    private TankFrame tf;
    private boolean living = true;

    private static final int SPEFD = 15;
    private static final int WIDTH = 25;
    private static final int HEIGTH = 25;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if (!living) {
            tf.bulletList.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGTH);
        g.setColor(c);
        move();
    }


    private void move() {
        switch (dir){
            case LEFT:
                x -= SPEFD;
                break;
            case UP:
                y -= SPEFD;
                break;
            case RIGHT:
                x += SPEFD;
                break;
            case DOWN:
                y += SPEFD;
                break;
        }

        if (x<0 || y<0 || x>tf.GAME_WIDTH || y>tf.GAME_HEIGHT) {
            living = false;
        }
    }

}
