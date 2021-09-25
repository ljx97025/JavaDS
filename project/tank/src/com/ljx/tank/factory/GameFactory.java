package com.ljx.tank.factory;

import com.ljx.tank.Dir;
import com.ljx.tank.Group;
import com.ljx.tank.TankFrame;

/**
 * @ClassName : GameFactory
 * @Author : LT
 * @Date: 2021/9/25 21:00
 * @Description : 抽象工厂
 */
public abstract class GameFactory {
    public abstract BaseTank createTank();
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
