package com.ljx.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName : ResourceMgr
 * @Author : LT
 * @Date: 2021/9/12 11:14
 * @Description : 资源加载
 */
public class ResourceMgr {
    public static BufferedImage tankR=null,tankL=null,tankU=null,tankD=null;
    public static BufferedImage bulletR=null,bulletL=null,bulletU=null,bulletD=null;
    public static BufferedImage[] exploded = new BufferedImage[16];


    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/tankD.gif"));

            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/bulletD.gif"));

            for (int i=0;i<16;i++){
                exploded[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
