package com.ljx.tank.strategy;

import com.ljx.tank.Tank;

/**
 * @ClassName : FireStrategy
 * @Author : LT
 * @Date: 2021/9/20 11:18
 * @Description : 子弹发射接口  策略模式
 */
public interface FireStrategy {
    void fire(Tank t);
}
