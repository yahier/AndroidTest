package com.yahier.androidtest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by yahier on 2018/6/22.
 * 视频播放 测试
 * 参考 https://developer.android.google.cn/guide/topics/media/mediaplayer?hl=zh_cn#java
 * <p>
 * 建立工具类 map<VideoUrl,LocalFilePath)
 * 没有key的，则下载，下载完成将key,value记录下来。直接进入，或者随机播放
 * 有key,如果对应的value已经不存在；则删除这一对key-value,执行下载。直接进入，或者随机播放
 */

public class MediaPlayerTest extends BaseActivity {
    final String TAG = "MediaPlayerTest";
    SurfaceView surfaceView;
    private SurfaceHolder holder;
    private MediaPlayer player;//媒体播放器
    private Button btnStart;
    private String path = "sdcard/test_10.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mediaplayer_test);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        holder = surfaceView.getHolder();
        //holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
            play();
        });
    }


    private void play() {
        String intentPath = getIntent().getStringExtra("videoPath");
        if (intentPath != null) {
            path = intentPath;
        }

        File file = new File(path);
        if (!file.exists()) {
            Toast.makeText(this, "文件路径不存在", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            player = new MediaPlayer();
            player.setDataSource(path);
            player.setDisplay(holder);//将影像播放控件与媒体播放控件关联起来

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {//视频播放完成后，释放资源
                    btnStart.setText("播放");
                    player.release();
                    player = null;
                }
            });

            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    //媒体播放器就绪后，设置进度条总长度，开启计时器不断更新进度条，播放视频
                    Log.e(TAG, "onPrepared");
                    player.start();
                    btnStart.setText("播放中");

                }
            });

            player.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                    btnStart.setText("width is " + width + " height is " + height);
                    refreshSurfaceView(width, height);
                }
            });

            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 比较视频的宽高比 和 屏幕的宽高比。然后撑满屏幕的宽度或者高度
     */
    private void refreshSurfaceView(int width, int height) {
        ViewGroup.LayoutParams params = surfaceView.getLayoutParams();
        params.width = width;
        params.height = height;
        surfaceView.setLayoutParams(params);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.release();
            player = null;
        }
    }

}
