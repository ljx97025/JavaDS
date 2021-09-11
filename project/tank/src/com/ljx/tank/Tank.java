package com.ljx.tank;

import jdk.nashorn.internal.ir.ReturnNode;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName : Tank
 * @Author : ljx
 * @Date: 2021/9/10 23:48
 * @Description : 坦克类
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir ;
    private TankFrame tf=null;
    private boolean moving = false;

    private static final int TANK_WIDTH = 50;
    private static final int TANK_HEIGHT = 50;
    private static final int SPEFD = 10;



    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank() {
        Random xr = new Random();
        Random yr = new Random();
        this.x = xr.nextInt(800);
        this.y = yr.nextInt(600);

        switch((x+y)%4){
            case 0:
                this.dir = Dir.LEFT;
                break;
            case 1:
                this.dir = Dir.UP;
                break;
            case 2:
                this.dir = Dir.RIGHT;
                break;
            case 3:
                this.dir = Dir.DOWN;
                break;
        }

    }



    public void paint(Graphics g){
        g.fillRect(x,y,TANK_WIDTH,TANK_HEIGHT);
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
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
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEFD() {
        return SPEFD;
    }

    public void fire(){
        tf.bulletList.add(new Bullet(x,y,dir,tf));
    }

    public boolean isMoving() {
        return moving;
    }

    public static int getTankWidth() {
        return TANK_WIDTH;
    }

    public static int getTankHeight() {
        return TANK_HEIGHT;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
