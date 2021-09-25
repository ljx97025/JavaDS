package com.ljx.tank.factory;

import com.ljx.tank.*;
import com.ljx.tank.strategy.DefaultFireStrategy;
import com.ljx.tank.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @ClassName : BaseTank
 * @Author : LT
 * @Date: 2021/9/25 21:02
 * @Description : 坦克产品基础类
 */
public abstract class BaseTank {

    protected int x; // 横坐标
    protected int y; // 纵坐标
    protected Group group; // 敌我分类标签
    protected boolean moving; // 坦克移动标志
    protected TankFrame tf = null;
    protected Dir dir; // 方向
    public Rectangle rectT = new Rectangle();

    // 抽象类可以有构造函数，但是不能new
    public BaseTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.tf = tf;
        this.dir = dir;
    }

    public abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void die();

    public Group getGroup() {
        return group;
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

    public TankFrame getTf() {
        return tf;
    }
}
