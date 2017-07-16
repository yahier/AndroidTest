package com.yahier.androidtest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by yahier on 17/4/9.
 */

public class BitmapUtil {
    static final String TAG = "BitmapUtil";

    public static byte[] readStream(InputStream inStream) throws Exception {
        byte[] buffer = new byte[1024];
        int len = -1;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }

    /**
     * 返回相对较小的比例
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);// 高度比例
            // 4
            final int widthRatio = Math.round((float) width / (float) reqWidth);// 宽度比例
            // 3
            inSampleSize = heightRatio < widthRatio ? widthRatio : heightRatio;

            if (reqWidth == 1800 && widthRatio >= heightRatio) {
                if (inSampleSize == 3) {//等于3时会降到2，误差太大；等于3的时候，960*3/4==720刚好
                    inSampleSize = 4;
                } else if (inSampleSize == 6) {//960*6/8==720
                    inSampleSize = 8;
                } else if (inSampleSize == 7) {//960*7/8==840
                    inSampleSize = 8;
                }
            }
        }
        Log.e(TAG, "calculateInSampleSize  " + inSampleSize);
        return inSampleSize;
    }


    public static Bitmap getPicFromBytes(byte[] bytes, BitmapFactory.Options opts) {
        if (bytes != null)
            if (opts != null)
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);
            else
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return null;
    }
}
