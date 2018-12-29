package com.yahier.androidtest.util.UiBlock;

import android.view.Choreographer;

/**
 * Created by yahier on 12/29/18.
 * Android系统每隔16ms发出VSYNC信号，触发对UI进行渲染
 */

public class BlockDetectByChoreographer {

    public static void start() {
        Choreographer.getInstance()
                .postFrameCallback(new Choreographer.FrameCallback() {
                    @Override
                    public void doFrame(long l) {
                        if (LogMonitor.getInstance().isMonitor()) {
                            LogMonitor.getInstance().removeMonitor();
                        }
                        LogMonitor.getInstance().startMonitor();
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                });
    }
}
