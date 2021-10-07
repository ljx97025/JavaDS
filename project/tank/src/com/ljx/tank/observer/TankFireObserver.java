package com.ljx.tank.observer;

/**
 * @ClassName : TankFireObserver
 * @Author : LT
 * @Date: 2021/10/7 10:29
 * @Description : 坦克发射子弹的观察者接口
 */
public interface TankFireObserver {
    void actionOnFire(TankFireEvent e);
}
