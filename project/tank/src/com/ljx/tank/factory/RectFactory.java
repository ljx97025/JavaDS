package com.ljx.tank.factory;

import com.ljx.tank.Bullet;
import com.ljx.tank.Dir;
import com.ljx.tank.Group;
import com.ljx.tank.TankFrame;

/**
 * @ClassName : RectFactory
 * @Author : LT
 * @Date: 2021/9/25 21:31
 * @Description : 产品族均为矩形的 工厂类
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank() {
        return null;
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}
