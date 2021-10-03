package com.ljx.tank.collide;

import com.ljx.tank.Bullet;
import com.ljx.tank.Explode;
import com.ljx.tank.GameObject;
import com.ljx.tank.Tank;

/**
 * @ClassName : BulletBulletCollider
 * @Author : LT
 * @Date: 2021/10/3 15:26
 * @Description : 子弹与子弹之间的碰撞检测
 */
public class BulletBulletCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Bullet) {
            Bullet bullet1 = (Bullet) o1;
            Bullet bullet2 = (Bullet) o2;
            // 解决坦克无法连发问题
            if (bullet1.getRectB().intersects(bullet2.getRectB())){
                bullet1.die();
                bullet2.die();

                return true;
            }

        }

        return false;
    }
}
