package com.huhusw.tftautoselectoraggregation;

import com.huhusw.tftautoselector.ocr.Ocr;
import com.huhusw.tftautoselector.screen.Screen;
import com.huhusw.tftautoselectoraggregation.thread.MyRunnable;
import com.huhusw.tftautoselectorcommon.queue.MyBlockQueue;
import org.springframework.util.CollectionUtils;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.*;

public class MainTest {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 20;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws InterruptedException {
        // 界面
        Screen screen = new Screen();
        // ocr处理类
        Ocr ocr = new Ocr();
        // 保存不重复的英雄
        CopyOnWriteArraySet<String> heroes = new CopyOnWriteArraySet<>();
        BlockingQueue<List<BufferedImage>> myBlockQueue = MyBlockQueue.getInstance();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        while (true) {
            List<BufferedImage> picOfHeroes = myBlockQueue.take();
            if (!CollectionUtils.isEmpty(picOfHeroes)) {
                MyRunnable myRunnable = new MyRunnable(heroes, picOfHeroes);
                executor.execute(myRunnable);
            }
        }
    }
}
