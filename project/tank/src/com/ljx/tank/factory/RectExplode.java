package com.ljx.tank.factory;

import com.ljx.tank.ResourceMgr;
import com.ljx.tank.TankFrame;

import java.awt.*;

/**
 * @ClassName : RectExplode
 * @Author : LT
 * @Date: 2021/9/25 21:15
 * @Description : 矩形爆炸类
 */
public class RectExplode extends BaseExplode{
    private int x;
    private int y;
    private TankFrame tf;
    private boolean living = true;

    private int step=0;


    private static final int WIDTH = 60;
    private static final int HEIGTH = 60;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        step++;
        g.setColor(c);
        // 当爆炸结束时，移除该爆炸对象
        if (step >= 6){
            tf.explodes.remove(this);
            step = 0;
        }
    }
}
