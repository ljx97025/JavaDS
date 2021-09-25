package com.ljx.tank.factory;

import com.ljx.tank.*;

/**
 * @ClassName : DefaultFactory
 * @Author : LT
 * @Date: 2021/9/25 21:04
 * @Description : 默认的产品族的工厂类，继承于GameFactory
 */
public class DefaultFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group,TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}
