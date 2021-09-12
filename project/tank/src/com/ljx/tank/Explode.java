package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Explode
 * @Author : LT
 * @Date: 2021/9/12 22:33
 * @Description : 爆炸
 */
public class Explode {

    private int x;
    private int y;
    private boolean living = true;

    private int step=0;

    public int getStep() {
        return step;
    }

    public Explode() {
    }

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void paint(Graphics g){
        if (step>=ResourceMgr.explodes.length){
            living = false;
            return;
        }
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
