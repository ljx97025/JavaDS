package com.ljx.tank.strategy;

import com.ljx.tank.Bullet;
import com.ljx.tank.Dir;
import com.ljx.tank.Tank;

/**
 * @ClassName : FourDirFireStrategy
 * @Author : LT
 * @Date: 2021/9/20 20:44
 * @Description : 四个方向发射子弹 单例模式+策略模式
 */
public class FourDirFireStrategy implements FireStrategy{

    private static FourDirFireStrategy fourDirFireStrategy = new FourDirFireStrategy();

    private FourDirFireStrategy(){}

    public static FourDirFireStrategy getInstance(){
        return fourDirFireStrategy;
    }

    @Override
    public void fire(Tank t) {
        new Bullet(t.getX(), t.getY(), Dir.DOWN,t.getGroup(),t.getGm());
        new Bullet(t.getX(), t.getY(), Dir.LEFT,t.getGroup(),t.getGm());
        new Bullet(t.getX(), t.getY(), Dir.UP,t.getGroup(),t.getGm());
        new Bullet(t.getX(), t.getY(), Dir.RIGHT,t.getGroup(),t.getGm());
    }
}
