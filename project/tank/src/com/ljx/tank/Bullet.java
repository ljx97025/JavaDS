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
    private Group group;
    private static final int BULLET_WIDTH = ResourceMgr.bulletD.getWidth();
    private static final int BULLET_HEIGHT = ResourceMgr.bulletD.getHeight();
    private static final int SPEFD = 15;

    public Bullet(int x, int y, Dir dir, Group group,TankFrame tf) {
        this(x, y, dir);
        this.group = group;
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

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }



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

    /**
     * @Author lt
     * @Description 坦克与子弹碰撞检测
     * @Param tank
     * @return 
     */
    public boolean collideWith(Tank tank) {

        if (this.group == tank.getGroup()) {
            return false;
        }

        Rectangle rectB = new Rectangle(x,y,BULLET_WIDTH,BULLET_HEIGHT);
        Rectangle rectT = new Rectangle(tank.getX(),tank.getY(),Tank.getTankWidth(),Tank.getTankHeight());

        if (rectB.intersects(rectT)){
            this.die();
            tank.die();
            return true;
        }
        return false;
    }

    private void die() {
        living = false;
    }
}
