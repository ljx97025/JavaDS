package com.ljx.tank.strategy;

import com.ljx.tank.Bullet;
import com.ljx.tank.GameModel;
import com.ljx.tank.GameObject;
import com.ljx.tank.Tank;
import com.ljx.tank.decorator.RectDecorator;

/**
 * @ClassName : DefaultFireStrategy
 * @Author : LT
 * @Date: 2021/9/20 20:14
 * @Description : 默认子弹发射策略  单例模式+策略模式
 */
public class DefaultFireStrategy implements FireStrategy{

    private static DefaultFireStrategy defaultFireStrategy = new DefaultFireStrategy();

    private DefaultFireStrategy(){}
    public static DefaultFireStrategy getInstance(){
        return defaultFireStrategy;
    }
    @Override
    public void fire(Tank t) {
//        new Bullet(t.getX(), t.getY(), t.getDir(),t.getGroup());
        GameModel.getInstance().add(new RectDecorator(new Bullet(t.getX(), t.getY(), t.getDir(),t.getGroup())));
    }
}
