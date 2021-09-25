package com.ljx.tank.factory;

import com.ljx.tank.*;
import com.ljx.tank.strategy.DefaultFireStrategy;
import com.ljx.tank.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @ClassName : RectTank
 * @Author : LT
 * @Date: 2021/9/25 21:59
 * @Description : 矩形坦克
 */
public class RectTank extends BaseTank{
    private boolean living = true;
    private TankFrame tf = null;

    FireStrategy fireStrategy = DefaultFireStrategy.getInstance(); // 子弹发射策略
    private Random random = new Random();

    private static final int SPEFD = 10; // 坦克移动速度
    private static final int WIDTH = 60;
    private static final int HEIGTH = 60;



    public RectTank(int x, int y, Dir dir, Group group,TankFrame tf) {
        super(x, y,dir,group,tf);

        rectT.x = x;
        rectT.y = y;
        rectT.width = WIDTH;
        rectT.height = HEIGTH;

        String fireStrategryName = null;
        if (group == Group.GOOD){
            fireStrategryName = (String)PropertiesMgr.get("goodTankFireStrategy");
        } else {
            fireStrategryName = (String)PropertiesMgr.get("badTankFireStrategy");
        }
        try {
            Class strategyClass = Class.forName(fireStrategryName);
            Method getInstance =  strategyClass.getMethod("getInstance",null);
            fireStrategy = (FireStrategy) getInstance.invoke(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        if (!living) {
            tf.tanks.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x,y,WIDTH,HEIGTH);
        g.setColor(c);

        move();
    }

    private void move() {
        // 如果moving为空，直接返回，不移动
        if (! moving){
            return;
        }
        switch (dir){
            case LEFT:
                x -= SPEFD;
                break;
            case UP:
                y -= SPEFD;
                break;
            case RIGHT:
                x += SPEFD;
                break;
            case DOWN:
                y += SPEFD;
                break;
        }

        if (group==Group.BAD && random.nextInt(100)>95){
            fire();
        }

        if (group==Group.BAD && random.nextInt(100)>90){
            randomDir();
        }

        boundChecked();

        rectT.x = x;
        rectT.y = y;

    }

    /**
     * @Author lt
     * @Description 边界检测
     * @Param
     * @return
     */
    private void boundChecked() {
        if (x < 2) {
            x = 2;
        }
        if (y < 32){
            y = 32;
        }
        if (x > (TankFrame.GAME_WIDTH-WIDTH-2)) {
            x = TankFrame.GAME_WIDTH-WIDTH -2;
        }
        if (y > (TankFrame.GAME_HEIGHT-HEIGTH-2)) {
            y = TankFrame.GAME_HEIGHT-HEIGTH -2;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }


    /**
     * 发射子弹
     */
    @Override
    public void fire() {
//        tf.bulletList.add(new Bullet(x,y,dir,group,tf));
        fireStrategy.fire(this);
    }
    @Override
    public void die() {
        this.living = false;
    }
}
