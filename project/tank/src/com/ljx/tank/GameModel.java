package com.ljx.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : GameModel
 * @Author : LT
 * @Date: 2021/10/3 10:39
 * @Description : Model
 */
public class GameModel {
    Tank mainTank = new Tank(200,500,Dir.UP,Group.GOOD,this,false);

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameModel(){
        int initBadTankCount = Integer.parseInt((String)PropertiesMgr.get("initBadTankCount")) ;
        for (int i=0;i<initBadTankCount;i++){
            add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }

    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);

        g.drawString("tank x,y："+mainTank.getX()+","+mainTank.getY(),10,90);
        g.setColor(c);
        mainTank.paint(g);
        for (int i=0;i<gameObjects.size();i++){
            gameObjects.get(i).paint(g);
        }
//        for (int i=0;i<tanks.size();i++){
//            tanks.get(i).setMoving(true); // 保证敌方坦克可以移动
//            tanks.get(i).paint(g);
//        }
//        //绘制爆炸
//        for (int i=0;i<explodes.size();i++){
//            explodes.get(i).paint(g);
//        }

//        // 子弹撞击坦克检测
//        for (int i=0;i<bulletList.size();i++){
//            for (int j=0;j<tanks.size();j++){
//                bulletList.get(i).collideWith(tanks.get(j));
//            }
//
//        }


    }

    public void remove(GameObject go) {
        gameObjects.remove(go);
    }

    public void add(GameObject go) {
        gameObjects.add(go);
    }

    public Tank getMainTank() {
        return mainTank;
    }
}
