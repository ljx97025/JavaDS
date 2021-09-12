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
    private TankFrame tf = null;
    private static final int SPEFD = 10; // 坦克移动速度

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g){

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

    /**
     * 发射子弹
     */
    public void fire() {
        int bx = x + ResourceMgr.tankL.getWidth()/2 - Bullet.getWIDTH()/2;
        int by = y + ResourceMgr.tankL.getHeight()/2 - Bullet.getHEIGTH()/2;
        tf.bulletList.add(new Bullet(bx,by,dir,tf));
    }
}
