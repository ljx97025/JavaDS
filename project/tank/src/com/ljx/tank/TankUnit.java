package com.ljx.tank;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @ClassName : TankUnit
 * @Author : ljx
 * @Date: 2021/9/11 0:11
 * @Description : 坦克的群组，用于管理坦克群组操作
 */
public class TankUnit {
    private ArrayList<Tank> tanks = new ArrayList();
    private int tankCount;

    public TankUnit(int tankCount) {
        this.tankCount = tankCount;
        createTanks();
    }

    public void createTanks(){
        if (this.tankCount<=0) {
            System.out.println("异常");
            return ;
        }

        for (int i=0;i<this.tankCount;i++){
            tanks.add(new Tank());
        }
    }

    public void paint(Graphics g) {
        for (int i=0;i<this.tankCount;i++){
            tanks.get(i).paint(g);
        }
    }
}
