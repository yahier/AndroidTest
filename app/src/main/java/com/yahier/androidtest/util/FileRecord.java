package com.yahier.androidtest.util;

import android.util.Log;

import com.yahier.androidtest.common.MyApp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by yahier on 2018/4/189.
 * 记录app运行时的打印信息,帮助排查错误
 */
public class FileRecord {
    static RandomAccessFile access;


    public static void record(String str) {
        write(str);
    }

    public static void record(String tag, String json) {
        StringBuffer sb = new StringBuffer();
        sb.append(tag + "\t");
        if (json != null) {
            sb.append(json);
        }
        write(sb.toString());
    }

    private static File file;
    private static File file2;

    static {
        File root = MyApp.getContext().getExternalCacheDir();
        File dir = new File(root, "recycle.com.dog.runtime");
        if (!dir.exists()) {
            boolean result = dir.mkdirs();
            Log.e("FileRecord 1 " + result, dir.getAbsolutePath());
        }
        file = new File(dir, "access.txt");
        file2 = new File(dir, "inputStream.txt");
    }

    private static void write(String test) {
        test = test + "\n";
        try {
            access = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (access == null) return;
        try {
            access.write(test.getBytes("UTF-8"));
            access.close();
        } catch (Exception e) {

        }


    }


    public static void writeStream(String msg) {
        msg = msg + "\n";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(msg.getBytes());
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
