package com.huhusw.tftautoselector.pic;

import com.huhusw.tftautoselector.ocr.Ocr;
import com.huhusw.tftautoselectorcommon.util.PicUtils;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 图片的处理
 */
public class Pic {

    public static void main(String[] args) {
        List<BufferedImage> bufferedImages = PicUtils.cutPic();
        Ocr ocr = new Ocr();
        List<String> strings = ocr.doOCR(bufferedImages);
        for (String s : strings) {
            System.out.println(s);
        }
    }


}
