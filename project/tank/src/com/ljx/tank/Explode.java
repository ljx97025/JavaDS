package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Explode
 * @Author : LT
 * @Date: 2021/9/12 17:48
 * @Description : 爆炸
 */
public class Explode extends GameObject{

    private int x;
    private int y;
    private GameModel gm;
    private boolean living = true;

    private int step=0;


    private static final int WIDTH = ResourceMgr.exploded[0].getWidth();
    private static final int HEIGTH = ResourceMgr.exploded[0].getHeight();

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.exploded[step++],x,y,null);
        // 当爆炸结束时，移除该爆炸对象
        if (step >= ResourceMgr.exploded.length){
            gm.remove(this);
            step = 0;
        }
    }


}
