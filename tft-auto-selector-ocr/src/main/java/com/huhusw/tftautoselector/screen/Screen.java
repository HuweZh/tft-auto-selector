package com.huhusw.tftautoselector.screen;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.huhusw.tftautoselector.keyboard.KeyGlobalListener;
import com.huhusw.tftautoselectorcommon.Constant;
import com.huhusw.tftautoselectorcommon.queue.MyBlockQueue;
import com.huhusw.tftautoselectorcommon.util.PicUtils;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Screen extends JFrame {

    public static void main(String[] args) {
        JFrame jFrame = new Screen();

    }

    /**
     * 内容面板
     */
    private JPanel panel;

    /**
     * 按钮
     */
    private JButton button;

    /**
     * 费用选择框
     */
    private JComboBox<String> costSelector;

    /**
     * 英雄选择框
     */
    private JComboBox<String> heroSelector;


    /**
     * 选择的英雄
     */
    private String heroName;

    /**
     * 按键监听事件的开关
     */
    private boolean flag;

    /**
     * 按键事件的代码
     */
    private static final int SHORTCUT = 1;

    public Screen() {

        panel = new JPanel();
        // 窗体标题
        setTitle("自动选择卡牌");
        // 设置为使用显示在最上层
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 150);

        // 设置内容面板
        setContentPane(panel);

        costSelector = new JComboBox<>();
        this.setCostInfo();
        panel.add(costSelector);

        heroSelector = new JComboBox<>();
        this.setHeroInfo(null);
        panel.add(heroSelector);

        button = new JButton("自动选择");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GlobalScreen.registerNativeHook();
                        }
                        catch (NativeHookException ex) {
                            System.err.println("There was a problem registering the native hook.");
                            System.err.println(ex.getMessage());

                            System.exit(1);
                        }
                        GlobalScreen.addNativeKeyListener(new KeyGlobalListener());
                    }
                }).start();
            }
        });
        panel.add(button);

        setVisible(true);
    }

    /**
     * 英雄信息
     *
     * @param costType 费用类型
     */
    private void setHeroInfo(String costType) {
        heroSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heroName = (String) heroSelector.getEditor().getItem();
            }
        });
        List<String> heroNames = new ArrayList<>();
        if (!StringUtils.hasLength(costType)) {
            for (List<String> heroes : Constant.COST_TO_ALL_HERO.values()) {
                heroNames.addAll(heroes);
            }
            this.fillHeroInfo(heroNames);
            return;
        }

        switch (costType) {
            case Constant.COST_FIVE:
                this.fillHeroInfo(Constant.COST_TO_ALL_HERO.get(Constant.COST_FIVE));
                break;
            case Constant.COST_FOUR:
                this.fillHeroInfo(Constant.COST_TO_ALL_HERO.get(Constant.COST_FOUR));
                break;
            case Constant.COST_THREE:
                this.fillHeroInfo(Constant.COST_TO_ALL_HERO.get(Constant.COST_THREE));
                break;
            case Constant.COST_TWO:
                this.fillHeroInfo(Constant.COST_TO_ALL_HERO.get(Constant.COST_TWO));
                break;
            case Constant.COST_ONE:
                this.fillHeroInfo(Constant.COST_TO_ALL_HERO.get(Constant.COST_ONE));
                break;
            default:
        }
    }

    /**
     * 填充英雄选择框的英雄信息
     *
     * @param heroes 英雄名称
     */
    private void fillHeroInfo(List<String> heroes) {
        for (String hero : heroes) {
            heroSelector.addItem(hero);
        }
    }

    /**
     * 设置费用下拉框
     */
    private void setCostInfo() {
        costSelector.addItem(Constant.COST_ONE);
        costSelector.addItem(Constant.COST_TWO);
        costSelector.addItem(Constant.COST_THREE);
        costSelector.addItem(Constant.COST_FOUR);
        costSelector.addItem(Constant.COST_FIVE);
        costSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 清除所有的item
                heroSelector.removeAllItems();
                // 添加新的item
                if (costSelector.getEditor().getItem().equals(Constant.COST_FIVE)) {
                    setHeroInfo(Constant.COST_FIVE);
                } else if (costSelector.getEditor().getItem().equals(Constant.COST_FOUR)) {
                    setHeroInfo(Constant.COST_FOUR);
                } else if (costSelector.getEditor().getItem().equals(Constant.COST_THREE)) {
                    setHeroInfo(Constant.COST_THREE);
                } else if (costSelector.getEditor().getItem().equals(Constant.COST_TWO)) {
                    setHeroInfo(Constant.COST_TWO);
                } else if (costSelector.getEditor().getItem().equals(Constant.COST_ONE)) {
                    setHeroInfo(Constant.COST_ONE);
                } else {
                    setHeroInfo(null);
                }
            }
        });
    }
}
