package com.ljx.tank.collide;

import com.ljx.tank.*;

/**
 * @ClassName : BulletTanKCollider
 * @Author : LT
 * @Date: 2021/10/3 14:19
 * @Description : 子弹与坦克之间的碰撞检测
 */
public class BulletTanKCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Bullet) {
            Tank tank = (Tank) o1;
            Bullet bullet = (Bullet) o2;

            if (bullet.getRect().intersects(tank.getRect())){
                bullet.die();
                // 如果子弹是自己的或者是队友则，伤害无效
                if (bullet.getGroup() == tank.getGroup()) {
                    return false;
                }
                tank.die();
                int ex = tank.getX() + Tank.getWIDTH()/2 - Explode.getWIDTH()/2;
                int ey = tank.getY() + Tank.getHEIGTH()/2 - Explode.getHEIGTH()/2;
                GameModel.getInstance().add(new Explode(ex,ey));
                return true;
            }

        } else if (o1 instanceof Bullet && o2 instanceof Tank) {
            collide(o2,o1);
        }

        return false;
    }
}
