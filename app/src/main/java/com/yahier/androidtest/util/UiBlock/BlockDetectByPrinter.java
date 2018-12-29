package com.yahier.androidtest.util.UiBlock;

import android.os.Looper;
import android.util.Printer;

/**
 * Created by yahier on 12/29/18.
 */

public class BlockDetectByPrinter {
    public static void start() {

        Looper.getMainLooper().setMessageLogging(new Printer() {

            private static final String START = ">>>>> Dispatching";
            private static final String END = "<<<<< Finished";

            @Override
            public void println(String x) {
                if (x.startsWith(START)) {
                    LogMonitor.getInstance().startMonitor();
                }
                if (x.startsWith(END)) {
                    LogMonitor.getInstance().removeMonitor();
                }
            }
        });

    }

    public static void stop() {
        Looper.getMainLooper().setMessageLogging(null);
    }


}
