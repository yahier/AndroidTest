package com.yahier.androidtest.util.apache;

import android.content.Context;
import android.util.Log;

import com.annimon.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by yahier on 10/1/18.
 */

public class IOTest {

    public static void main(Context context) {
        new Thread(() -> test1()).start();
        test2(context);

    }

    /**
     * 测试 流
     */
    private static void test1() {
        Log.d("IOTest", "test1");
        InputStream inputStream = null;
        try {
            inputStream = new URL("https://www.baidu.com").openStream();
            String content = IOUtils.toString(inputStream, "utf-8");
            System.out.println(content);

            System.out.println();

            List<String> list = IOUtils.readLines(inputStream, "utf-8");
            Stream.of(list).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("test1", e.getLocalizedMessage());
        } finally {
            if (inputStream != null)
                IOUtils.closeQuietly(inputStream);
        }
    }

    /***
     *   测试文件读写   强大的FileUtils复制功能也是有的喔
     */
    public static void test2(Context context) {
        File file = new File(context.getExternalCacheDir(), "test.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            //还有各种写入喔
            FileUtils.writeStringToFile(file, "如何面对，曾一起走左", "UTF-8");

            List<String> list = FileUtils.readLines(file, "UTF-8");
            Stream.of(list).forEach(item -> System.out.println("test2 read:" + item));

            byte[] data = FileUtils.readFileToByteArray(file);
            Log.d("test2", "byte data length:" + data.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
