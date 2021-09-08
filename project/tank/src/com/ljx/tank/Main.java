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
       while (true){
           Thread.sleep(50);
           tankFrame.repaint();
       }
    }
}
