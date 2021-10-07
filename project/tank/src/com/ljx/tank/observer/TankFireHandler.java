package com.ljx.tank.observer;

import com.ljx.tank.Tank;

/**
 * @ClassName : TankFireHandler
 * @Author : LT
 * @Date: 2021/10/7 10:29
 * @Description : 坦克发射子弹观察者实现类
 */
public class TankFireHandler implements TankFireObserver{

    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank tank = e.getSource();
        tank.fire();
    }
}
