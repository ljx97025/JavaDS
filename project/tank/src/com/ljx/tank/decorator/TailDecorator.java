package com.ljx.tank.decorator;

import com.ljx.tank.GameModel;
import com.ljx.tank.GameObject;

import java.awt.*;

/**
 * @ClassName : TailDecorator
 * @Author : LT
 * @Date: 2021/10/6 21:52
 * @Description : 装饰器模式 实现线段
 */
public class TailDecorator extends GODecorator {


    public TailDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        if (!GameModel.getInstance().contains(gameObject)) {
            return;
        }
        gameObject.paint(g);
        Color color = g.getColor();
        g.setColor(Color.GREEN);
        g.drawLine(gameObject.getX(),gameObject.getY(),gameObject.getX()+(int)gameObject.getRect().getWidth(),gameObject.getY()+(int)gameObject.getRect().getHeight());
        g.setColor(color);
    }
}
