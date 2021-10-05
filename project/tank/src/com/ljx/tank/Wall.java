package com.ljx.tank;

import java.awt.*;

/**
 * @ClassName : Wall
 * @Author : LT
 * @Date: 2021/10/5 23:00
 * @Description : 墙
 */
public class Wall extends GameObject{
    private int x;
    private int y;
    private int width;
    private int height;

    Rectangle rectW = null;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectW = new Rectangle(x,y,width,height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x,y,width,height);
        g.setColor(c);
    }

    public Rectangle getRectW() {
        return rectW;
    }
}
