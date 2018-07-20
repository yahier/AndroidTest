package com.yahier.androidtest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by yahier on 2018/6/22.
 * 视频播放 测试
 */

public class MediaPlayerTest extends AppCompatActivity {
    final String TAG = "MediaPlayerTest";
    SurfaceView surfaceView;
    private SurfaceHolder holder;
    private MediaPlayer player;//媒体播放器
    private Button btnStart;
    public static final String path = "sdcard/360/1529656917065904.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mediaplayer_test);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        holder = surfaceView.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
            play();
        });


        String path = Environment.getExternalStorageDirectory().getPath();
        Log.e(TAG, "path:" + path);

        StringBuffer buffer = new StringBuffer();
        buffer.append("yahier");
        buffer.delete(0,5);
        Log.e("buffer",buffer.toString());
    }


    private void play() {
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

            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
