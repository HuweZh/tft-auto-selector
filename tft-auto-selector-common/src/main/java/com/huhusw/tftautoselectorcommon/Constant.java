package com.huhusw.tftautoselectorcommon;

import java.util.*;

public class Constant {
    /**
     * 一费卡
     */
    public static final String COST_ONE = "一费";

    /**
     * 二费卡
     */
    public static final String COST_TWO = "二费";

    /**
     * 三费卡
     */
    public static final String COST_THREE = "三费";

    /**
     * 四费卡
     */
    public static final String COST_FOUR = "四费";

    /**
     * 五费卡
     */
    public static final String COST_FIVE = "五费";

    /**
     * 一费英雄
     */
    public static final List<String> HERO_ONE = new ArrayList<>(Arrays.asList(
            "凯尔", "崔丝塔娜", "科加斯", "艾瑞莉娅", "茂凯", "雷克顿", "奥利安娜", "卡西奥佩娅", "波比", "马尔扎哈", "烬", "佛耶戈", "莎弥拉"));

    /**
     * 二费英雄
     */
    public static final List<String> HERO_TWO = new ArrayList<>(Arrays.asList(
            "加里奥", "索拉卡", "提莫", "沃里克", "艾希", "卡萨丁", "斯维因", "塔莉垭", "金克斯", "劫", "克烈", "蔚", "瑟提"));


    /**
     * 三费英雄
     */
    public static final List<String> HERO_THREE = new ArrayList<>(Arrays.asList(
            "娑娜", "卡尔玛", "塔里克", "卡特琳娜", "盖伦", "德莱厄斯", "杰斯", "丽桑卓", "维克兹", "阿克尚", "艾克", "雷克赛", "卡莉斯塔"));

    /**
     * 四费英雄
     */
    public static final List<String> HERO_FOUR = new ArrayList<>(Arrays.asList(
            "厄加特", "嘉文四世", "内瑟斯", "慎", "拉克丝", "瑟庄妮", "卡莎", "亚索", "泽丽", "阿兹尔", "厄斐琉斯", "格温"));

    /**
     * 五费英雄
     */
    public static final List<String> HERO_FIVE = new ArrayList<>(Arrays.asList(
            "瑞兹", "塞恩", "黑默丁格", "阿狸", "卑尔维斯", "赛娜", "亚托克斯", "奎桑提"));

    /**
     * 费用对应的英雄列表
     */
    public static final Map<String, List<String>> COST_TO_ALL_HERO = new HashMap<>();

    static {
        COST_TO_ALL_HERO.put(COST_ONE, HERO_ONE);
        COST_TO_ALL_HERO.put(COST_TWO, HERO_TWO);
        COST_TO_ALL_HERO.put(COST_THREE, HERO_THREE);
        COST_TO_ALL_HERO.put(COST_FOUR, HERO_FOUR);
        COST_TO_ALL_HERO.put(COST_FIVE, HERO_FIVE);
    }

    /**
     * 英雄的纵坐标
     */
    private static final Integer HERO_POSITION_Y = 1390;

    /**
     * 英雄名字图片的宽度
     */
    private static final Integer HERO_PIC_W = 150;

    /**
     * 英雄名字图片的高度
     */
    private static final Integer HERO_PIC_H = 30;

    /**
     * 第一位英雄名字图片的横坐标
     */
    private static final Integer FIRST_HERO_X = 650;

    /**
     * 第二位英雄名字图片的横坐标
     */
    private static final Integer SECOND_HERO_X = 910;


    /**
     * 第三位英雄名字图片的横坐标
     */
    private static final Integer THIRD_HERO_X = 1180;
    /**
     * 第四位英雄名字图片的横坐标
     */
    private static final Integer FOURTH_HERO_X = 1450;

    /**
     * 第五位英雄名字图片的横坐标
     */
    private static final Integer FIFTH_HERO_X = 1720;
}
