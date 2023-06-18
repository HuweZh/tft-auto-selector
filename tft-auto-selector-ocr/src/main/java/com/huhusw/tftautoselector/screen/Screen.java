package com.huhusw.tftautoselector.screen;

import com.huhusw.tftautoselectorcommon.Constant;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
        this.setHeroInfo(null);
        jPanel.add(heroSelector);

        button = new JButton("自动选择");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });
        jPanel.add(button);
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

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JComboBox<String> getCostSelector() {
        return costSelector;
    }

    public void setCostSelector(JComboBox<String> costSelector) {
        this.costSelector = costSelector;
    }

    public JComboBox<String> getHeroSelector() {
        return heroSelector;
    }

    public void setHeroSelector(JComboBox<String> heroSelector) {
        this.heroSelector = heroSelector;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "jPanel=" + jPanel +
                ", button=" + button +
                ", costSelector=" + costSelector +
                ", heroSelector=" + heroSelector +
                ", heroName='" + heroName + '\'' +
                '}';
    }
}