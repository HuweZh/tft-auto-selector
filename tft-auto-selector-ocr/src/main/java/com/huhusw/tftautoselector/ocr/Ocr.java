package com.huhusw.tftautoselector.ocr;

import net.sourceforge.tess4j.Tesseract;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Ocr {
    private Tesseract tesseract;

    public Ocr() {
        tesseract = new Tesseract();
        tesseract.setDatapath("D:\\workspace\\idea\\tessdata");
        tesseract.setLanguage("chi_sim");
    }

    public List<String> doOCR(List<BufferedImage> bufferedImages) {
        List<String> res = new ArrayList<>();
        try {
            for (BufferedImage image : bufferedImages) {
                String s = tesseract.doOCR(image).replace(" ", "").trim();
                res.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }


}
