package com.huhusw.tftautoselectorcommon.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.huhusw.tftautoselectorcommon.Constant.*;


public class PicUtils {
    /**
     * 屏幕截图并裁剪出来五张图片
     */
    public static List<BufferedImage> screenShot() {
        try {
            Robot robot = new Robot();
            // 这里默认返回的是低分辨率的图片，也就是缩放后的图片
            // image = robot.createScreenCapture(screenRectangle);
            // 获取到系统后台生成的两张分辨率图片，这里指定的宽度和高度是压缩后的
            MultiResolutionImage multiResolutionImage = robot.createMultiResolutionScreenCapture(new Rectangle(0, 0, 2048, 1152));
            // 指定宽度和高度获取其中一张图片，这里传进去高分辨率的图片
            Image image = multiResolutionImage.getResolutionVariant(2560, 1440);
            BufferedImage screenCapture = (BufferedImage) image;
            return cutPic(screenCapture);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对图片进行截取，取到姓名的五个图片
     *
     * @param image 图片
     */
    public static List<BufferedImage> cutPic(BufferedImage image) {
        List<BufferedImage> res = new ArrayList<>();
        try {
            //参数依次为，截取起点的x坐标，y坐标，截取宽度，截取高度
            BufferedImage firstPic = image.getSubimage(FIRST_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(firstPic);
            BufferedImage secondPic = image.getSubimage(SECOND_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(secondPic);
            BufferedImage thirdPic = image.getSubimage(THIRD_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(thirdPic);
            BufferedImage fourthPic = image.getSubimage(FOURTH_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(fourthPic);
            BufferedImage fifthPic = image.getSubimage(FIFTH_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(fifthPic);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return res;
    }


    /**
     * 对图片进行截取，取到姓名的五个图片
     */
    public static List<BufferedImage> cutPic() {
        List<BufferedImage> res = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(new File("D:\\tttteeest.png"));
            //参数依次为，截取起点的x坐标，y坐标，截取宽度，截取高度
            BufferedImage firstPic = image.getSubimage(FIRST_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(firstPic);
            BufferedImage secondPic = image.getSubimage(SECOND_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(secondPic);
            BufferedImage thirdPic = image.getSubimage(THIRD_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(thirdPic);
            BufferedImage fourthPic = image.getSubimage(FOURTH_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(fourthPic);
            BufferedImage fifthPic = image.getSubimage(FIFTH_HERO_X, HERO_POSITION_Y, HERO_PIC_W, HERO_PIC_H);
            res.add(fifthPic);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return res;
    }


    /**
     * 屏幕截图
     */
    public static List<BufferedImage> cutPic123() {
        System.out.println("开始截图");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        return cutPic(image);
    }

    public static String cutPic222(String imageName, String path, String imgType) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // 这里默认返回的是低分辨率的图片，也就是缩放后的图片
        // image = robot.createScreenCapture(screenRectangle);
        // 获取到系统后台生成的两张分辨率图片，这里指定的宽度和高度是压缩后的
        MultiResolutionImage multiResolutionImage = robot.createMultiResolutionScreenCapture(new Rectangle(0, 0, 2048, 1152));
        // 指定宽度和高度获取其中一张图片，这里传进去高分辨率的图片
        Image image = multiResolutionImage.getResolutionVariant(2560, 1440);
        BufferedImage screenCapture = (BufferedImage) image;
        //首先创建一个目录
        File file = new File(path);
        if (!file.isDirectory() || !file.exists()) {
            file.mkdir();
        }
        //判断文件是否存在，存在就改名字
        String fileName = imageName + "." + imgType;
        try {
            ImageIO.write(screenCapture, imgType, new File(path + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = path + fileName;
        return filePath;
    }


    public static void cutPic3333() {
        try {
            BufferedImage pic1 = ImageIO.read(new File("D:\\1111.png"));
            System.out.println(pic1.getWidth());
            System.out.println(pic1.getHeight());
            //参数依次为，截取起点的x坐标，y坐标，截取宽度，截取高度
            BufferedImage pic2 = pic1.getSubimage(1352, 1075, 100, 20);

            //将截取的子图另行存储
            File desImage = new File("D:\\44444444.png");
            ImageIO.write(pic2, "png", desImage);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    /**
     * 获取高分辨率图片
     *
     * @return 高分辨率图片
     */
    public static BufferedImage getHighResolutionImage() {
        Robot robot = null;
        try {
            robot = new Robot();
            MultiResolutionImage multiResolutionImage = robot.createMultiResolutionScreenCapture(new Rectangle(0, 0, 2048, 1152));
            Image image = multiResolutionImage.getResolutionVariant(2560, 1440);
            BufferedImage screenCapture = (BufferedImage) image;
            return screenCapture;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
