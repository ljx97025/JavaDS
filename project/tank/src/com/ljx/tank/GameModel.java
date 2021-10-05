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

    Tank mainTank = null;
    private List<GameObject> gameObjects = new ArrayList<>();
    private Collider collider = new ColliderChain();
    // 改造为单例模式，
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    private GameModel(){
    }

    public static GameModel getInstance(){
        return INSTANCE;
    }
    // 解决tank与GameModel循环创建问题
    private void init() {
        mainTank = new Tank(200,500,Dir.UP,Group.GOOD,false);
        int initBadTankCount = Integer.parseInt((String)PropertiesMgr.get("initBadTankCount")) ;
        for (int i=0;i<initBadTankCount;i++){
            new Tank(50+i*80,200,Dir.DOWN,Group.BAD);
        }

        new Wall(500,500,300,50);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);

        g.drawString("tank x,y："+mainTank.getX()+","+mainTank.getY(),10,90);
        g.setColor(c);
//        mainTank.paint(g); // 防止二次绘制玩家坦克，
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
