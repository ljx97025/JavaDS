package com.ljx.tank.collide;

import com.ljx.tank.Bullet;
import com.ljx.tank.Explode;
import com.ljx.tank.GameObject;
import com.ljx.tank.Tank;

/**
 * @ClassName : TankTankCollider
 * @Author : LT
 * @Date: 2021/10/3 14:36
 * @Description : 坦克与坦克间碰撞检测
 */
public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;

            if (tank1.getRectT().intersects(tank2.getRectT())){
                tank1.setMoving(false);
                tank2.setMoving(false);
                // 增加 坦克碰撞后可以自由移动，1. 复位到上一时刻位置，2. 换方向寻找
            }

        }

        return false; // 坦克之间相撞后，均需要进行下一步碰撞检测
    }
}
