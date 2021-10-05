package com.ljx.tank.collide;

import com.ljx.tank.GameObject;
import com.ljx.tank.Tank;
import com.ljx.tank.Wall;

/**
 * @ClassName : TankWallCollider
 * @Author : LT
 * @Date: 2021/10/5 23:18
 * @Description : 坦克与墙的碰撞检测
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Tank && o2 instanceof Wall) {

            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.getRectT().intersects(wall.getRectW())) {
                tank.back();
            }
        }

        return false;
    }
}
