package com.huhusw.tftautoselectoraggregation.thread;

import com.huhusw.tftautoselector.ocr.Ocr;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class MyRunnable implements Runnable {

    private CopyOnWriteArraySet<String> heroes;

    private List<BufferedImage> picOfHeroes;

    private Ocr ocr;

    public MyRunnable(CopyOnWriteArraySet<String> heroes, List<BufferedImage> picOfHeroes) {
        this.heroes = heroes;
        this.picOfHeroes = picOfHeroes;
        ocr = new Ocr();
    }

    @Override
    public void run() {
        List<String> strings = ocr.doOCR(picOfHeroes);
        for (String s : strings) {
            if (!heroes.contains(s)) {
                System.out.println(s);
                heroes.add(s);
            }
        }
    }
}
