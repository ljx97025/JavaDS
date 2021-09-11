package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Tank
 * @Author : ljx
 * @Date: 2021/9/10 23:48
 * @Description : 坦克类
 */
public class Tank {
    private int x; // 横坐标
    private int y; // 纵坐标
    private Dir dir; // 方向
    private boolean moving; // 坦克移动标志
    private static final int SPEFD = 10; // 坦克移动速度

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public void paint(Graphics g){

        g.fillRect(x,y,50,50);
        move();
    }

    private void move() {
        // 如果moving为空，直接返回，不移动
        if (! moving){
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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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

}
