package com.ljx.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName : TankFrame
 * @Author : ljx
 * @Date: 2021/9/6 23:01
 * @Description : 坦克窗口
 */
public class TankFrame extends Frame {

    int x=200;
    int y=200;

    Dir dir = Dir.LEFT;
    private static final int SPEFD = 10;
    public TankFrame(){
        setSize(800,600);
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

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
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


        // 使用 if 或 switch 均不会出现按双键，斜着走的情况，这是由于dir只能有一个值
//        if (dir == Dir.LEFT) x -= SPEFD;
//        if (dir == Dir.UP)   y -= SPEFD;
//        if (dir == Dir.RIGHT) x += SPEFD;
//        if (dir == Dir.DOWN) y += SPEFD;

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
            if (bl){
//                x -= SPEFD;
                dir = Dir.LEFT;
            }
            if (bu){
//                y -= SPEFD;
                dir = Dir.UP;
            }
            if (br){
//                x += SPEFD;
                dir = Dir.RIGHT;
            }
            if (bd){
//                y += SPEFD;
                dir = Dir.DOWN;
            }
        }

    }


}
