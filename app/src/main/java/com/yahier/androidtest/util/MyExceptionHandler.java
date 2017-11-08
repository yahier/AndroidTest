package com.yahier.androidtest.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by lenovo on 2017/11/7.
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    Context mContext;

    public MyExceptionHandler(Context context) {
        this.mContext = context;
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "crash");
        if (!file.exists() && !file.mkdir()) {
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("MM-dd kk:mm");
        String date = format.format(Calendar.getInstance().getTime());
        File crashFile = new File(file, date + ".log");
        try {
            crashFile.createNewFile();
            OutputStream stream = new FileOutputStream(crashFile);
            PrintStream printStream = new PrintStream(stream);
            ex.printStackTrace(printStream);
            printStream.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        Log.e("RongExceptionHandler", "uncaughtException", ex);
    }
}

