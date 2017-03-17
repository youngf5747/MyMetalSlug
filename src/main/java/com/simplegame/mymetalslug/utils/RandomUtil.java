package com.simplegame.mymetalslug.utils;

import java.util.Random;

/**
 * Created by Administrator on 2017/3/15.
 */

public class RandomUtil {
    public static Random random = new Random();
    // 返回一个0～range的随机数
    public static int rand(int range)
    {
        // 如果range为0，直接返回0
        if (range == 0)
            return 0;
        // 获取一个0～range之间的随机数
        return Math.abs(random.nextInt() % range);
    }
}
