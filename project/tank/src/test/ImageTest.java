package test;

import com.ljx.tank.ResourceMgr;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @ClassName : ImageTest
 * @Author : LT
 * @Date: 2021/9/12 11:20
 * @Description : 资源加载测试
 */
public class ImageTest {

    @Test
    public void tankImageTest() {
        try {
            BufferedImage tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/ljx/images/tankL.gif"));
            Assert.assertNotNull(tankL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ResourceMgrTest(){
        Assert.assertNotNull(ResourceMgr.tankU);

    }
}
