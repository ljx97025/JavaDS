package com.ljx.tank.collide;

import com.ljx.tank.Bullet;
import com.ljx.tank.GameObject;
import com.ljx.tank.Wall;

/**
 * @ClassName : BulletWallCollider
 * @Author : LT
 * @Date: 2021/10/5 23:07
 * @Description : 子弹与墙的碰撞检测
 */
public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Wall) {

            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.getRectB().intersects(wall.getRectW())) {
                bullet.die();
                return true;
            }

        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            collide(o2,o1);
        }

        return false;

    }
}
