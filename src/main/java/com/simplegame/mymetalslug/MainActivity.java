package com.simplegame.mymetalslug;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.simplegame.mymetalslug.ui.GameView;

public class MainActivity extends Activity {

    // 定义资源管理的核心类
    public static Resources res = null;
    public static MainActivity mainActivity = null;
    // 定义成员变量记录游戏窗口的宽高
    public static int windowWidth, windowHeight;
    // 定义主布局内的容器
    public static FrameLayout mainLayout = null;
    // 游戏窗口的主界面
    public static GameView mainView = null;
    // 定义主布局的参数
    public static FrameLayout.LayoutParams mainViewParams = null;
    // 播放音乐的player
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        mainActivity = this;
        // 设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        windowWidth = metrics.widthPixels;
        windowHeight = metrics.heightPixels;
        // 设置软键盘不调整屏幕大小
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        mainLayout = (FrameLayout) findViewById(R.id.mainLayout);
        mainView = new GameView(getApplicationContext(), GameView.STAGE_INIT);
        mainViewParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mainLayout.addView(mainView, mainViewParams);
        mMediaPlayer = MediaPlayer.create(this, R.raw.background);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMediaPlayer != null && !mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }
}
