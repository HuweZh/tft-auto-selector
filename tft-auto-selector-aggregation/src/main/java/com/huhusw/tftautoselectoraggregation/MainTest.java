package com.huhusw.tftautoselectoraggregation;

import com.huhusw.tftautoselector.ocr.Ocr;
import com.huhusw.tftautoselector.screen.Screen;
import com.huhusw.tftautoselectorcommon.queue.MyBlockQueue;
import org.springframework.util.CollectionUtils;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        // 界面
        Screen screen = new Screen();
        // ocr处理类
        Ocr ocr = new Ocr();
        // 保存不重复的英雄
        Set<String> heroes = new HashSet<>();

        BlockingQueue<List<BufferedImage>> myBlockQueue = MyBlockQueue.getInstance();

        while (true) {
            List<BufferedImage> picOfHeroes = myBlockQueue.take();
            if (!CollectionUtils.isEmpty(picOfHeroes)) {
                List<String> strings = ocr.doOCR(picOfHeroes);
                for (String s : strings) {
                    if (!heroes.contains(s)) {
                        System.out.println(s);
                        heroes.add(s);
                    }
                }
            }
        }
    }
}
