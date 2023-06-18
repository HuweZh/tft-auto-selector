package com.huhusw.tftautoselector.ocr;

import net.sourceforge.tess4j.Tesseract;

import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("D:\\workspace\\idea\\tessdata");
        tesseract.setLanguage("chi_sim");
        try {
            String s = tesseract.doOCR(new File("C:\\Users\\huhusw\\Pictures\\3.jpg"));
            System.out.println(s);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
