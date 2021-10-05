package com.ljx.tank;

import com.ljx.tank.collide.Collider;
import com.ljx.tank.collide.ColliderChain;

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
    private Collider collider = new ColliderChain();


    public GameModel(){
        int initBadTankCount = Integer.parseInt((String)PropertiesMgr.get("initBadTankCount")) ;
        for (int i=0;i<initBadTankCount;i++){
            add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }

        add(new Wall(500,500,300,50));

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

        // 碰撞检测
        for (int i=0;i<gameObjects.size();i++){
            // i+1 防止重复检测
            for (int j=i+1;j<gameObjects.size();j++){
               if(collider.collide(gameObjects.get(i),gameObjects.get(j))) {
                   break;
               }
            }

        }


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
