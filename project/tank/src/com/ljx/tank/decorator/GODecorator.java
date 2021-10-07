package com.ljx.tank.decorator;

import com.ljx.tank.GameObject;

import java.awt.*;

/**
 * @ClassName : GODecorator
 * @Author : LT
 * @Date: 2021/10/6 21:50
 * @Description : 装饰器模式
 */
public abstract class GODecorator extends GameObject {

    protected GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void paint(Graphics g) {
        gameObject.paint(g);
    }
}
