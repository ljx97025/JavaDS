package com.ljx.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName : ResourceMrg
 * @Author : LT
 * @Date: 2021/9/12 20:59
 * @Description : 资源加载
 */
public class ResourceMgr {
    public static BufferedImage tankL=null,tankU=null,tankR=null,tankD=null;
    public static BufferedImage bulletL=null,bulletU=null,bulletR=null,bulletD=null;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankR.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankD.gif"));

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletR.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletD.gif"));

            for (int i=0;i<16;i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
