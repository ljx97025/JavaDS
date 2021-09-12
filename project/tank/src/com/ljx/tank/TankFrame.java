package com.ljx.tank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : TankFrame
 * @Author : ljx
 * @Date: 2021/9/6 23:01
 * @Description : 坦克窗口
 */
public class TankFrame extends Frame {

    Tank mainTank = new Tank(200,200,Dir.LEFT,Group.GOOD,this);
    TankUnit tankUnit = new TankUnit(this,5);
    List<Bullet> bulletList = new ArrayList<>();
    static int GAME_WIDTH = 800;
    static int GAME_HEIGHT = 600;

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

    // 防止屏幕闪烁
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
        g.drawString("当前子弹数目："+bulletList.size(),30,45);
        g.drawString("敌方坦克数目："+tankUnit.getTankCount(),30,60);
        g.drawString("死亡坦克数目："+tankUnit.getDieTankCount(),30,75);
        g.setColor(c);
        mainTank.paint(g);
        tankUnit.paint(g);
        for (int i=0;i<bulletList.size();i++) {
            bulletList.get(i).paint(g);
        }
        for (int i=0;i<bulletList.size();i++){
            for (int j=0;j<tankUnit.getTankCount();j++){
                bulletList.get(i).collideWith(tankUnit.getTank(j));
            }
        }

    }
    /**
     * @Author lt
     * @Description 键盘监控
     */
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
                case KeyEvent.VK_CONTROL:
                    mainTank.fire();
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){

            if (!bl && !bu && !bd && !br) {
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
