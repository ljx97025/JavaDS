package com.ljx.tank;

import com.ljx.tank.factory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : TankFrame
 * @Author : ljx
 * @Date: 2021/9/6 23:01
 * @Description : 坦克窗口
 */
public class TankFrame extends Frame {

    Tank mainTank = new Tank(200,500,Dir.LEFT,Group.GOOD,this);
    public List<BaseBullet> bulletList = new ArrayList();
    public List<BaseTank> tanks = new ArrayList<>();
    public List<BaseExplode> explodes = new ArrayList();
    public static int GAME_WIDTH=1080;
    public static int GAME_HEIGHT=960;

    public GameFactory gameFactory = new DefaultFactory();

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank war");
        setVisible(true);
        addKeyListener(new KeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 防止屏幕闪动
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("剩余子弹数："+bulletList.size(),10,50);
        g.drawString("剩余敌方数："+tanks.size(),10,70);
        g.drawString("tank x,y："+mainTank.getX()+","+mainTank.getY(),10,90);
        g.setColor(c);
        mainTank.paint(g);
        for (int i=0;i<bulletList.size();i++){
            bulletList.get(i).paint(g);
        }
        for (int i=0;i<tanks.size();i++){
            tanks.get(i).setMoving(true); // 保证敌方坦克可以移动
            tanks.get(i).paint(g);
        }
        //绘制爆炸
        for (int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }

        // 子弹撞击坦克检测
        for (int i=0;i<bulletList.size();i++){
            for (int j=0;j<tanks.size();j++){
                bulletList.get(i).collideWith(tanks.get(j));
            }

        }


    }

    class KeyListener extends KeyAdapter {

        boolean bl = false;
        boolean bu = false;
        boolean br = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT :
                    bl = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    mainTank.fire();
                    break;
            }

            setMainTankDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT :
                    bl = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){

            if (!bl && !bu && !br && !bd){
                mainTank.setMoving(false);
            } else {
                mainTank.setMoving(true);
            }

            if (bl){
                mainTank.setDir(Dir.LEFT);
            }
            if (bu){
                mainTank.setDir(Dir.UP);
            }
            if (br){
                mainTank.setDir(Dir.RIGHT);
            }
            if (bd){
                mainTank.setDir(Dir.DOWN);
            }
        }

    }

}
