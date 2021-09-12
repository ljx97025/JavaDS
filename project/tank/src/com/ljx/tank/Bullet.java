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
    private static final int WIDTH = ResourceMgr.bulletL.getWidth();
    private static final int HEIGTH = ResourceMgr.bulletL.getHeight();

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this(x,y,dir);
        this.tf = tf;
    }

    public Bullet(int x, int y, Dir dir) {
        this.dir = dir;

        switch (this.dir) {
            case LEFT:
                this.x = x - Bullet.WIDTH;
                this.y = y + Tank.getHEIGTH()/2 - Bullet.HEIGTH/2;
                break;
            case UP:
                this.x = x + Tank.getWIDTH()/2 - Bullet.HEIGTH/2;
                this.y = y - Bullet.HEIGTH;
                break;
            case RIGHT:
                this.x = x + Tank.getWIDTH();
                this.y = y + Tank.getHEIGTH()/2 - Bullet.HEIGTH/2;
                break;
            case DOWN:
                this.x = x + Tank.getWIDTH()/2 - Bullet.HEIGTH/2;
                this.y = y + Tank.getHEIGTH();
                break;

        }
    }

    public void paint(Graphics g){
        if (!living) {
            tf.bulletList.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
        }
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
