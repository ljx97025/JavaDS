package com.ljx.tank;

import com.ljx.tank.strategy.DefaultFireStrategy;
import com.ljx.tank.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @ClassName : Tank
 * @Author : ljx
 * @Date: 2021/9/10 23:48
 * @Description : 坦克类
 */
public class Tank extends GameObject{
    private int x; // 横坐标
    private int y; // 纵坐标
    private Dir dir; // 方向
    private boolean moving = true; // 坦克移动标志
    private boolean living = true;
    private GameModel gm = null;
    private Group group; // 敌我分类标签
    FireStrategy fireStrategy = DefaultFireStrategy.getInstance(); // 子弹发射策略
    private Random random = new Random();

    private static final int SPEFD = 10; // 坦克移动速度
    private static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    private static final int HEIGTH = ResourceMgr.goodTankU.getHeight();

    Rectangle rectT = new Rectangle();
    // 记录上一时刻坦克位置
    private int oldx;
    private int oldy;

    // 解决玩者坦克初始是静止的
    public Tank(int x, int y, Dir dir, Group group,GameModel gm, boolean mv){
        this(x,y,dir,group,gm);
        this.moving = mv;
    }

    public Tank(int x, int y, Dir dir, Group group,GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

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


    public void paint(Graphics g){
        if (!living) {
            gm.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(group==Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(group==Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(group==Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
                break;
            case UP:
                g.drawImage(group==Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
        }
        //记录上一时刻位置
        oldx = x;
        oldy = y;
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
        if (x > (TankFrame.GAME_WIDTH-Tank.WIDTH-2)) {
            x = TankFrame.GAME_WIDTH-Tank.WIDTH -2;
        }
        if (y > (TankFrame.GAME_HEIGHT-Tank.HEIGTH-2)) {
            y = TankFrame.GAME_HEIGHT-Tank.HEIGTH -2;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }

    public Group getGroup() {
        return group;
    }

    public GameModel getGm() {
        return gm;
    }

    /**
     * 发射子弹
     */
    public void fire() {
//        tf.bulletList.add(new Bullet(x,y,dir,group,tf));
        fireStrategy.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public Rectangle getRectT() {
        return rectT;
    }
    /*
     * @Author lt
     * @Description 恢复坦克上一时刻位置
     * @Param
     * @return
     */
//    public void resetXY() {
//        x = oldx;
//        y = oldy;
//        setMoving(true);
//    }
//
//    /*
//     * @Author lt
//     * @Description tank停止运动
//     * @Param
//     * @return
//     */
//    public void stop() {
//        setMoving(false);
//    }

    /*
     * @Author lt
     * @Description 恢复坦克上一时刻位置
     * @Param
     * @return
     */
    public void back() {
        x = oldx;
        y = oldy;
    }
}
