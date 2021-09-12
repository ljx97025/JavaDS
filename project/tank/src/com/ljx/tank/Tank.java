package com.ljx.tank;

import jdk.nashorn.internal.ir.ReturnNode;
import sun.security.util.ResourcesMgr;

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
    private boolean living = true;
    private Group group;
    private Explode exploded = new Explode();
    private static final int TANK_WIDTH = ResourceMgr.tankD.getWidth();
    private static final int TANK_HEIGHT = ResourceMgr.tankD.getHeight();
    private static final int SPEFD = 10;



    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank(Group group, TankFrame tf) {
        this.tf = tf;
        this.group = group;
        Random xr = new Random();
        Random yr = new Random();
        this.x = xr.nextInt(TankFrame.GAME_WIDTH);
        this.y = yr.nextInt(TankFrame.GAME_HEIGHT);

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
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }

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
        isBound();
    }


    /**
     * @Author lt
     * @Description 坦克越界处理,title边框大小为获取，y初始值无法确定
     * @Param
     * @return
     **/
    private void isBound() {
        if (x < 0) {
            x = 0;
        }
        if (x > TankFrame.GAME_WIDTH -TANK_WIDTH) {
            x = TankFrame.GAME_WIDTH -TANK_WIDTH;
        }
        if (y < 30) {
            y = 30;
        }
        if (y > TankFrame.GAME_HEIGHT - TANK_HEIGHT) {
            y = TankFrame.GAME_HEIGHT - TANK_HEIGHT;
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
        tf.bulletList.add(new Bullet(x,y,dir,group,tf));
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

    public Group getGroup() {
        return group;
    }

    public boolean isLiving() {
        return living;
    }

    public void die() {
        living = false;
    }

    public Explode getExploded() {
        return exploded;
    }

    public void tankExploded(Graphics g) {
        exploded.setX(x);
        exploded.setY(y);
        exploded.paint(g);
    }
}
