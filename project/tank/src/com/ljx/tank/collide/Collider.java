package com.ljx.tank.collide;

import com.ljx.tank.GameObject;

/**
 * @ClassName : Collider
 * @Author : LT
 * @Date: 2021/10/3 14:09
 * @Description : 碰撞检测接口
 */
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
