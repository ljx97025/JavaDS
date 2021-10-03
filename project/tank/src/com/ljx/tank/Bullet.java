package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Bullet
 * @Author : ljx
 * @Date: 2021/9/11 9:02
 * @Description : 子弹类
 */
public class Bullet extends GameObject{
    private int x;
    private int y;
    private Dir dir;
    private Group group;
    private GameModel gm;
    private boolean living = true;
    Rectangle rectB = new Rectangle();
    private static final int SPEFD = 15;
    private static final int WIDTH = ResourceMgr.bulletL.getWidth();
    private static final int HEIGTH = ResourceMgr.bulletL.getHeight();

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGTH() {
        return HEIGTH;
    }

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this(x,y,dir);
        this.gm = gm;
        this.group = group;
        rectB.x = this.x;
        rectB.y = this.y;
        rectB.width = WIDTH;
        rectB.height = HEIGTH;
        gm.add(this); // 创建一个子弹，自动加入子弹队列
    }

    public Bullet(int x, int y, Dir dir) {
        this.dir = dir;

        switch (this.dir) {
            case LEFT:
                this.x = x - Bullet.WIDTH;
                this.y = y + Tank.getHEIGTH()/2 - Bullet.HEIGTH/2;
                break;
            case UP:
                this.x = x + Tank.getWIDTH()/2 - Bullet.HEIGTH/2;
                this.y = y - Bullet.HEIGTH;
                break;
            case RIGHT:
                this.x = x + Tank.getWIDTH();
                this.y = y + Tank.getHEIGTH()/2 - Bullet.HEIGTH/2;
                break;
            case DOWN:
                this.x = x + Tank.getWIDTH()/2 - Bullet.HEIGTH/2;
                this.y = y + Tank.getHEIGTH();
                break;

        }
    }

    public void paint(Graphics g){
        if (!living) {
            gm.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
        }
        move();
    }


    private void move() {
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

        if (x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) {
            living = false;
        }

        rectB.x = x;
        rectB.y = y;

    }
//
//    /**
//     * @Author lt
//     * @Description 子弹与坦克的碰撞检测
//     * @Param tank
//     * @return
//     */
//    public void collideWith(Tank tank) {
//        // 分别绘制子弹与坦克的矩形 每调用一次创建两个对象，会导致创建对象越来越多
//        // 为解决该问题，将rect放置 tank bullet中作为属性
////        Rectangle rectB = new Rectangle(this.x, this.y, WIDTH, HEIGTH);
////        Rectangle rectT = new Rectangle(tank.getX(), tank.getY(), Tank.getWIDTH(), Tank.getHEIGTH());
//        // 检查子弹与坦克矩形是否交叉，交叉则子弹与坦克均消失
//        if (rectB.intersects(tank.rectT)){
//            this.die();
//            // 如果子弹是自己的或者是队友则，伤害无效
//            if (this.group == tank.getGroup()) {
//                return ;
//            }
//            tank.die();
//            int ex = tank.getX() + Tank.getWIDTH()/2 - Explode.getWIDTH()/2;
//            int ey = tank.getY() + Tank.getHEIGTH()/2 - Explode.getHEIGTH()/2;
//            gm.add(new Explode(ex,ey,gm));
//        }
//    }

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public Rectangle getRectB() {
        return rectB;
    }
}
