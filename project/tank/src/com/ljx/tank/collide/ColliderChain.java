package com.ljx.tank.collide;

import com.ljx.tank.GameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : ColliderChain
 * @Author : LT
 * @Date: 2021/10/3 14:55
 * @Description : 碰撞检测链 将多个碰撞检测组合，依次检测
 */
public class ColliderChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTanKCollider());
        add(new TankTankCollider());
        add(new BulletBulletCollider());
    }

    /**
     * @Author lt
     * @Description 碰撞检测链 （责任链模式）
     * @Param o1
     * @param: o2
     * @return 规定 当两个物体碰撞后消失则返回true,否则返回false
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        boolean sign = false;
        for (Iterator<Collider> it = colliders.iterator(); it.hasNext(); ) {
            Collider collider = (Collider) it.next();
            sign = collider.collide(o1,o2);
            if (sign) {
                break;
            }
        }
        return sign;
    }

    public void add(Collider collider) {
        colliders.add(collider);
    }

    public void remove(Collider collider) {
        colliders.remove(collider);
    }
}
