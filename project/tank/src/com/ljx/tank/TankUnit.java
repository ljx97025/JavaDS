package com.ljx.tank;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName : TankUnit
 * @Author : ljx
 * @Date: 2021/9/11 0:11
 * @Description : 坦克的群组，用于管理坦克群组操作
 */
public class TankUnit {
    private ArrayList<Tank> tanks = new ArrayList();
    private int tankCount;
    private TankFrame tf = null;

    public TankUnit(TankFrame tf, int tankCount) {
        this.tf = tf;
        this.tankCount = tankCount;
        createTanks();
    }

    public void createTanks(){
        if (this.tankCount<=0) {
            System.out.println("异常");
            return ;
        }

        for (int i=0;i<this.tankCount;i++){
            tanks.add(new Tank(tf));
        }
    }

    public void paint(Graphics g) {
        Tank tank = null;
        for (int i=0;i<this.tankCount;i++){
            tank = tanks.get(i);
            randomDir(tank);
            tank.fire();
            tank.paint(g);
        }
    }

    public void randomDir(Tank tank) {
        tank.setMoving(true);
        int randomNum = new Random().nextInt(4);
        switch(randomNum % 4){
            case 0:
                tank.setDir(Dir.LEFT);
                break;
            case 1:
                tank.setDir(Dir.UP);
                break;
            case 2:
                tank.setDir(Dir.RIGHT);
                break;
            case 3:
                tank.setDir(Dir.DOWN);
                break;
        }
    }
}
