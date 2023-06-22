package com.huhusw.tftautoselector.keyboard;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.huhusw.tftautoselectorcommon.queue.MyBlockQueue;
import com.huhusw.tftautoselectorcommon.util.PicUtils;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 全局监听按键
 * <p>
 * https://github.com/kwhat/jnativehook
 */
public class KeyGlobalListener implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
//        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()));

        // D键监听
        if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_D) {
//            System.out.println("监听到截图事件");
            List<BufferedImage> bufferedImages = PicUtils.screenShot();
            try {
                MyBlockQueue.getInstance().put(bufferedImages);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        // 按键esc 退出键盘监听
//        if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
//            try {
//                GlobalScreen.unregisterNativeHook();
//            } catch (NativeHookException nativeHookException) {
//                nativeHookException.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new KeyGlobalListener());
    }
}
