package com.ljx.tank.decorator;

import com.ljx.tank.GameModel;
import com.ljx.tank.GameObject;

import java.awt.*;

/**
 * @ClassName : RectDecorator
 * @Author : LT
 * @Date: 2021/10/6 21:51
 * @Description : 装饰器模式 实现矩形
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        /*
         * 当子弹不再队列中，则不再绘制，这是由于new Bullet时分别将其放在队列与装饰器中。
         * 当队列中子弹消失时，装饰器中子弹未消失，子弹仍会绘制，但是x,y不会再变化，则方框出现
         */
        if (!GameModel.getInstance().contains(gameObject)) {
            return;
        }
    // bug子弹消失，方框不消失;子弹打击左侧边界，子弹消失，方框不消失，其它侧不存在该种情况
        gameObject.paint(g);
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(gameObject.getX(),gameObject.getY(),(int)gameObject.getRect().getWidth(),(int)gameObject.getRect().getHeight());
        g.setColor(color);
    }
}
