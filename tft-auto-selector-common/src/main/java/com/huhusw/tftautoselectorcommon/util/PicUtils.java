package com.huhusw.tftautoselectorcommon.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class PicUtils {
    /**
     * 屏幕截图
     */
    public static BufferedImage screenShot() {
        System.out.println("开始截图");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = null;
        BufferedImage image = null;
        try {
            robot = new Robot();
            image = robot.createScreenCapture(screenRectangle);
            cutPic(image);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 对图片进行截取，取到姓名的五个图片
     *
     * @param image 图片
     */
    public static List<BufferedImage> cutPic(BufferedImage image) {
        try {
            int width = image.getWidth();
            int height = image.getHeight();
            //参数依次为，截取起点的x坐标，y坐标，截取宽度，截取高度
            BufferedImage pic2 = image.getSubimage(100, height / 10, 100, 10);

            File desImage = new File("D:/subjavaPic1.png");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return null;
    }


    /**
     * 对图片进行截取，取到姓名的五个图片
     */
    public static List<BufferedImage> cutPic() {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\1.png"));
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println(width);
            System.out.println(height);
            //参数依次为，截取起点的x坐标，y坐标，截取宽度，截取高度
            BufferedImage pic2 = image.getSubimage(1720, 1390, 150, 30);

            File desImage = new File("D:\\subjavaPic1.png");
            ImageIO.write(pic2, "png", desImage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
