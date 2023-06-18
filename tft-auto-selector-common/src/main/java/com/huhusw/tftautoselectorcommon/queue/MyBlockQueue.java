package com.huhusw.tftautoselectorcommon.queue;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyBlockQueue {
    private static BlockingQueue<List<BufferedImage>> myBlockQueue = new ArrayBlockingQueue<>(100);

    private MyBlockQueue() {}

    public static BlockingQueue<List<BufferedImage>> getInstance() {
        return myBlockQueue;
    }
}
