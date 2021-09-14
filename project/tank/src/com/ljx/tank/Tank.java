package com.ljx.tank;

import java.awt.*;
import java.util.Random;

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
    private boolean living = true;
    private TankFrame tf = null;
    private Group group; // 敌我分类标签

    private Random random = new Random();

    private static final int SPEFD = 10; // 坦克移动速度
    private static final int WIDTH = ResourceMgr.tankL.getWidth();
    private static final int HEIGTH = ResourceMgr.tankL.getHeight();

    public Tank(int x, int y, Dir dir, Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }


    public void paint(Graphics g){
        if (!living) {
            tf.tanks.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
        }

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

        if (group==Group.BAD && random.nextInt(100)>90){
            fire();
        }

        if (group==Group.BAD && random.nextInt(100)>95){
            randomDir();
        }

    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }

    public Group getGroup() {
        return group;
    }

    /**
     * 发射子弹
     */
    public void fire() {
        tf.bulletList.add(new Bullet(x,y,dir,Group.GOOD,tf));
    }

    public void die() {
        this.living = false;
    }
}
