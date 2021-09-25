package com.ljx.tank;

/**
 * @ClassName : Main
 * @Author : ljx
 * @Date: 2021/9/6 23:00
 * @Description : 主程序
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
       TankFrame tankFrame =  new TankFrame();
       int initBadTankCount = Integer.parseInt((String)PropertiesMgr.get("initBadTankCount")) ;
       for (int i=0;i<initBadTankCount;i++){
           tankFrame.tanks.add(tankFrame.gameFactory.createTank(50+i*80,200,Dir.DOWN,Group.BAD,tankFrame));
       }
       while (true){
           Thread.sleep(50);
           tankFrame.repaint();
       }
    }
}
