package com.ljx.tank.observer;

import com.ljx.tank.Tank;

/**
 * @ClassName : TankFireEvent
 * @Author : LT
 * @Date: 2021/10/7 10:30
 * @Description : 坦克发射子弹 事件类
 */
public class TankFireEvent {
    Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    public Tank getSource() {
        return tank;
    }
}
