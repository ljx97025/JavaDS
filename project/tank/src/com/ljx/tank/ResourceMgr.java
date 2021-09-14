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
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/GoodTank1.png"));
            tankR = ImageUtil.rotateImage(tankU,90);
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankD = ImageUtil.rotateImage(tankU,180);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/bulletU.png"));
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletD = ImageUtil.rotateImage(bulletU,180);

            for (int i=0;i<16;i++){
                exploded[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/e"+(i+1)+".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
