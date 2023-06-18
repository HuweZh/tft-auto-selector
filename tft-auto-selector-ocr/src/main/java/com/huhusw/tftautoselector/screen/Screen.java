package com.huhusw.tftautoselector.screen;

import com.huhusw.tftautoselectorcommon.Constant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {

    public static void main(String[] args) {
        JFrame jFrame = new Screen();
        jFrame.setVisible(true);
    }

    /**
     * 内容面板
     */
    private JPanel jPanel;

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

    private final String COST_ONE = "";

    public Screen() {
        jPanel = new JPanel();
        // 窗体标题
        setTitle("自动选择卡牌");
        // 设置为使用显示在最上层
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 300);

        // 设置内容面板
        setContentPane(jPanel);

        costSelector = new JComboBox<>();
        this.setCostInfo();
        jPanel.add(costSelector);

        heroSelector = new JComboBox<>();
        heroSelector.addItem("五费");
        heroSelector.addItem("四费");
        heroSelector.addItem("三费");
        heroSelector.addItem("二费");
        heroSelector.addItem("一费");
        heroSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("下拉事件");
                System.out.println(e.getActionCommand());
                System.out.println(e.getModifiers());
                System.out.println(e.getWhen());

                System.out.println(heroSelector.getEditor().getItem());
            }
        });
        jPanel.add(heroSelector);

        button = new JButton("开始");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });
        jPanel.add(button);
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
                System.out.println("下拉事件");
                System.out.println(e.getActionCommand());
                System.out.println(e.getModifiers());
                System.out.println(e.getWhen());

                System.out.println(costSelector.getEditor().getItem());
            }
        });
    }


}
