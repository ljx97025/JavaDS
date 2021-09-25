package com.ljx.tank.factory;

import com.ljx.tank.Tank;

import java.awt.*;

/**
 * @ClassName : BaseBullet
 * @Author : LT
 * @Date: 2021/9/25 21:03
 * @Description : 子弹产品基础类
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collideWith(BaseTank tank);
}
