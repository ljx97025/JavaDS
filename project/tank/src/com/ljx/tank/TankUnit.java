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

    private Random random = new Random();

    public TankUnit(TankFrame tf, int tankCount) {
        this.tf = tf;
        this.tankCount = tankCount;
        createTanks();
    }

    public int getTankCount() {
        return tankCount;
    }

    public Tank getTank(int index) {
        return tanks.get(index);
    }

    public void createTanks(){
        if (this.tankCount<=0) {
            System.out.println("异常");
            return ;
        }

        for (int i=0;i<this.tankCount;i++){
            tanks.add(new Tank(Group.BAD,tf));
        }
    }

    public void paint(Graphics g) {
        Tank tank = null;
        for (int i=0;i<this.tankCount;i++){
            tank = tanks.get(i);
            if (random.nextInt(10)>8){
                randomDir(tank);
            }
            if (random.nextInt(8)>5){
                tank.fire();
            }
            tank.paint(g);
        }
        removeTank();
    }

    public void removeTank(){
        for (int i=0;i<this.tankCount;i++){
            if (!tanks.get(i).isLiving()){
                tanks.remove(i);
            }
        }
        // 重置坦克数量，防止越界
        this.tankCount = tanks.size();
    }

    /** 
     * @Author lt
     * @Description  坦克随机方向确定
     * @Param tank
     * @return 
     */
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
