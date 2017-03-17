package com.simplegame.mymetalslug.bean;

import android.graphics.Bitmap;

import com.simplegame.mymetalslug.utils.GameManager;

/**
 * Created by Administrator on 2017/3/15.
 */

public class Bullet {
    // 定义代表子弹类型的常量（如果程序还需要增加更多子弹，只需在此处添加常量即可）
    public static final int BULLET_TYPE_1 = 1;
    public static final int BULLET_TYPE_2 = 2;
    public static final int BULLET_TYPE_3 = 3; // 飞机
    public static final int BULLET_TYPE_4 = 4;
    // 定义子弹的类型
    private int type;
    // 子弹的x、y坐标
    private int x;
    private int y;
    // 定义子弹的射击方向
    private int dir;
    // 定义子弹在y方向上的速度
    private int ySpeed = 0;
    // 子弹是否有效(未使用)
    private boolean isEffect = true;
    // 定义子弹的构造器
    public Bullet(int type, int x, int y, int dir)
    {
        this.type = type;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    // 根据子弹类型获取子弹对应的图片
    public Bitmap getBitmap()
    {
        switch (type)
        {
            case BULLET_TYPE_1:
                return GameManager.bulletImage[0];
            case BULLET_TYPE_2:
                return GameManager.bulletImage[1];
            case BULLET_TYPE_3:
                return GameManager.bulletImage[2];
            case BULLET_TYPE_4:
                return GameManager.bulletImage[3];
            default:
                return null;
        }
    }
    // 根据子弹类型来计算子弹在X方向上的速度
    public int getXSpeed()
    {
        // 根据玩家的方向来计算子弹方向和移动方向
        int sign = dir == Player.DIR_RIGHT ? 1 : -1;
        switch (type)
        {
            // 对于第1种子弹，以12为基数来计算它的速度
            case BULLET_TYPE_1:
                return (int) (GameManager.scale * 12) * sign;
            // 对于第2种子弹，以8为基数来计算它的速度
            case BULLET_TYPE_2:
                return (int) (GameManager.scale * 8) * sign;
            // 对于第3种子弹，以8为基数来计算它的速度
            case BULLET_TYPE_3:
                return (int) (GameManager.scale * 8) * sign;
            // 对于第4种子弹，以8为基数来计算它的速度
            case BULLET_TYPE_4:
                return (int) (GameManager.scale * 8) * sign;
            default:
                return (int) (GameManager.scale * 8) * sign;
        }
    }

    // 根据子弹类型来计算子弹在Y方向上的速度
    public int getSpeedY()
    {
        // 如果ySpeed不为0，则以ySpeed作为Y方向上的速度
        if (ySpeed != 0)
        {
            return ySpeed;
        }
        // 此处控制只有第3种子弹才有Y方向的速度（子弹会斜着向下移动）
        switch (type)
        {
            case BULLET_TYPE_1:
                return 0;
            case BULLET_TYPE_2:
                return 0;
            case BULLET_TYPE_3:
                return (int) (GameManager.scale * 6);
            case BULLET_TYPE_4:
                return 0;
            default:
                return 0;
        }
    }

    // 定义控制子弹移动的方法
    public void move()
    {
        x += getXSpeed();
        y += getSpeedY();
    }

    // 下面是各成员变量的setter、getter方法
    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getDir()
    {
        return dir;
    }

    public void setDir(int dir)
    {
        this.dir = dir;
    }

    public boolean isEffect()
    {
        return isEffect;
    }

    public void setEffect(boolean isEffect)
    {
        this.isEffect = isEffect;
    }

    public int getYSpeed()
    {
        return ySpeed;
    }

    public void setYSpeed(int ySpeed)
    {
        this.ySpeed = ySpeed;
    }
}
