package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : GameObject
 * @Author : LT
 * @Date: 2021/10/3 10:34
 * @Description : 游戏中对像abstract类
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected Rectangle rect;

    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getRect() {
        return rect;
    }
}
