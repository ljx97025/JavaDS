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

    private static final int BULLET_WIDTH = 25;
    private static final int BULLET_HEIGHT = 25;
    private static final int SPEFD = 20;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this(x, y, dir);
        this.dir = dir;
        this.tf = tf;
    }

    public Bullet(int x, int y, Dir dir) {
        switch (dir) {
            case LEFT:
                this.x = x-BULLET_WIDTH;
                this.y = y-BULLET_HEIGHT/2 + Tank.getTankHeight()/2;
                break;
            case RIGHT:
                this.x = x+Tank.getTankWidth();
                this.y = y-BULLET_HEIGHT/2 + Tank.getTankHeight()/2;
                break;
            case UP:
                this.x = x + Tank.getTankWidth()/2 - BULLET_WIDTH/2;
                this.y = y-BULLET_HEIGHT;
                break;
            case DOWN:
                this.x = x + Tank.getTankWidth()/2 - BULLET_WIDTH/2;
                this.y = y + Tank.getTankHeight();
                break;
        }
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bulletList.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,BULLET_WIDTH,BULLET_HEIGHT);
        g.setColor(c);
        move();
    }

    public void move(){
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
