package com.ljx.test;

import com.ljx.tank.Dir;
import com.ljx.tank.ResourceMgr;
import org.junit.Assert;
import org.junit.Test;
import sun.security.util.ResourcesMgr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName : Tanktest
 * @Author : ljx
 * @Date: 2021/9/11 0:35
 * @Description : 坦克测试
 */
public class Tanktest {

    @Test
    public void testDir(){
        System.out.println(Dir.LEFT);
        System.out.println(Dir.UP);
        System.out.println(Dir.RIGHT);
        System.out.println(Dir.DOWN);
        System.out.println(10/3);
    }
    @Test
    public void addImage() throws IOException {
        BufferedImage tankL = ImageIO.read(Tanktest.class.getClassLoader().getResourceAsStream("com/images/tankL.gif"));
        Assert.assertNotNull(ResourceMgr.explodes[0]);
    }
}
