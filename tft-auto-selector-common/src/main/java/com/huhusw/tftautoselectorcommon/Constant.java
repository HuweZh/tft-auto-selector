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
    public static final Integer HERO_POSITION_Y = 1390;

    /**
     * 英雄名字图片的宽度
     */
    public static final Integer HERO_PIC_W = 150;

    /**
     * 英雄名字图片的高度
     */
    public static final Integer HERO_PIC_H = 30;

    /**
     * 第一位英雄名字图片的横坐标
     */
    public static final Integer FIRST_HERO_X = 650;

    /**
     * 第二位英雄名字图片的横坐标
     */
    public static final Integer SECOND_HERO_X = 910;


    /**
     * 第三位英雄名字图片的横坐标
     */
    public static final Integer THIRD_HERO_X = 1180;

    /**
     * 第四位英雄名字图片的横坐标
     */
    public static final Integer FOURTH_HERO_X = 1450;

    /**
     * 第五位英雄名字图片的横坐标
     */
    public static final Integer FIFTH_HERO_X = 1720;

    public static final Map<String, String> name2Name = new HashMap<>();

    static {
        name2Name.put("凯尔", "凯尔");
        name2Name.put("艾瑞莉娅", "艾瑞莉娅");
        name2Name.put("崔丝塔娜", "崔丝塔娜");
        name2Name.put("阿兹尔", "阿兹尔");
        name2Name.put("拉克丝", "拉克丝");
        name2Name.put("瑟庄妮", "瑟庄妮");
        name2Name.put("内瑟斯", "内瑟斯");
        name2Name.put("格温", "格温");
        name2Name.put("盐伦", "盖伦");
        name2Name.put("阿克尚", "阿克尚");
        name2Name.put("亚索", "亚索");
        name2Name.put("塔莉垛", "塔莉垭");
        name2Name.put("卡莉丝塔", "卡莉斯塔");
        name2Name.put("艾克", "艾克");
        name2Name.put("妍娜", "娑娜");
        name2Name.put("卡西奥佩娅", "卡西奥佩娅");
        name2Name.put("塔里克", "塔里克");
        name2Name.put("炸", "烬");
        name2Name.put("泽丽", "泽丽");
        name2Name.put("加里奥", "加里奥");
        name2Name.put("蔚", "蔚");
        name2Name.put("艾希", "艾希");
        name2Name.put("杰斯", "杰斯");
        name2Name.put("克烈", "克烈");
        name2Name.put("金克丝", "金克斯");
        name2Name.put("德荷厄斯", "德莱厄斯");
        name2Name.put("波比", "波比");
        name2Name.put("卡尔玛", "卡尔玛");
        name2Name.put("盖伦", "盖伦");
        name2Name.put("卡特琳娜", "卡特琳娜");
        name2Name.put("丽联卓", "丽桑卓");
        name2Name.put("塔莉垭", "塔莉垭");
        name2Name.put("索拉卡", "索拉卡");
        name2Name.put("雷克颓", "雷克顿");
        name2Name.put("维克典", "维克兹");

        name2Name.put("厄加特", "厄加特");
        name2Name.put("科加斯", "科加斯");
        name2Name.put("节瑞莉娅", "艾瑞莉娅");
        name2Name.put("增里克", "塔里克");
        name2Name.put("玛尔扎哈", "玛尔扎哈");
        name2Name.put("茂凯", "茂凯");
        name2Name.put("恭", "慎");
        name2Name.put("卡芮丁", "卡萨丁");
        name2Name.put("劫", "劫");
        name2Name.put("提范", "提莫");
        name2Name.put("沃里克", "沃里克");
        name2Name.put("卡莹", "卡莎");
        name2Name.put("厄斐琉斯", "厄斐琉斯");
        name2Name.put("雷克塞", "雷克赛");
        name2Name.put("斯维因", "斯维因");
        name2Name.put("零克塞", "雷克赛");
        name2Name.put("佛耶戈", "佛耶戈");
        name2Name.put("奥莉安娜", "奥莉安娜");
        name2Name.put("炳", "烬");
        name2Name.put("提莫", "提莫");
        name2Name.put("莎弥拉", "莎米拉");
        name2Name.put("嘴文四世", "嘉文四世");
        name2Name.put("提苣", "提莫");

        name2Name.put("卡萨丁", "卡萨丁");
        name2Name.put("维克教", "维克兹");
        name2Name.put("嘉文四世", "嘉文四世");
        name2Name.put("赛娜", "赛娜");
        name2Name.put("黑默丁格", "黑默丁格");
        name2Name.put("卑尔维斯", "卑尔维斯");
        name2Name.put("惜", "慎");

        name2Name.put("愚", "慎");
        name2Name.put("松拉卡", "索拉卡");
        name2Name.put("收席", "瑟提");
        name2Name.put("奎栖提", "奎桑提");
        name2Name.put("奎根提", "奎桑提");
        name2Name.put("赛恩", "塞恩");
        name2Name.put("卡莎", "卡莎");
        name2Name.put("提茧", "提莫");
        name2Name.put("瑞教", "瑞兹");
        name2Name.put("想庄妮", "瑟庄妮");
        name2Name.put("阿狸", "阿狸");
        name2Name.put("阿猷", "阿狸");
        name2Name.put("亚托克斯", "亚托克斯");
    }
}
