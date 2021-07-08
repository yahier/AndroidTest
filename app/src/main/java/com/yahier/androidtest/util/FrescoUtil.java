package com.yahier.androidtest.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.view.ViewGroup;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.yahier.androidtest.common.MyApp;
import com.yahier.androidtest.widget.MImageView;

import java.io.File;

/**
 * .
 */
public final class FrescoUtil {

    private static FrescoUtil mInstance = null;
    private static int DISK_CACHE_SIZE_HIGH = 1024 * 1024 * 80;
    private static int DISK_CACHE_SIZE_LOW = 1024 * 1024 * 40;
    private static int DISK_CACHE_SIZE_VERY_LOW = 1024 * 1024 * 20;

    public static FrescoUtil getInstance() {
        if (mInstance == null) {
            mInstance = new FrescoUtil();
        }
        return mInstance;
    }

    public void init(Context context, String diskCacheUniqueName) {
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(context)
                .setMaxCacheSize(DISK_CACHE_SIZE_HIGH)
                .setMaxCacheSizeOnLowDiskSpace(DISK_CACHE_SIZE_LOW)
                .setMaxCacheSizeOnVeryLowDiskSpace(DISK_CACHE_SIZE_VERY_LOW)
                .setBaseDirectoryName(diskCacheUniqueName)
                .setBaseDirectoryPath(getDiskCacheDir(context, diskCacheUniqueName))
                //.setVersion(SystemInfoUtil.getVersionCode(context))
                .build();

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(diskCacheConfig)
                .setDownsampleEnabled(true)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .build();
        Fresco.initialize(context, config);
    }

    /**
     * 建议使用该函数， 传递宽高值, 可以减少由于压缩图片引起的内存损耗
     */
    public void setImageSrc(final DraweeView draweeView, String strSrc, int width, int height) {
        ViewGroup.LayoutParams params = draweeView.getLayoutParams();
        if (params != null) {
            Point point = DisplayUtil.INSTANCE.getScreenDisplay(MyApp.getContext());
            if (width <= 0) {
                width = params.width > 0 ? params.width : point.x;
            }
            if (height <= 0) {
                height = params.height > 0 ? params.height : point.x;
            }
        }
        Uri uri = Uri.parse(strSrc);
        setImageSrc(draweeView, uri, width, height);
    }

    public void setImageSrc(final DraweeView draweeView, Uri uri, int width, int height) {
        ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(uri);
        if (width > 0 && height > 0) {
            builder.setResizeOptions(new ResizeOptions(width, height));
        }
        ImageRequest request = builder.build();
        PipelineDraweeControllerBuilder controllerBuilder = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setTapToRetryEnabled(false)
                .setOldController(draweeView.getController());
        if (draweeView instanceof MImageView
                && ((MImageView) draweeView).getImageListener() != null) {
            controllerBuilder.setControllerListener(((MImageView) draweeView).getImageListener());
        }
        DraweeController controller = controllerBuilder.build();
        draweeView.setController(controller);
    }

    public void getBitmap(Context context, Uri uri, DataSubscriber dataSubscriber) {
        getBitmap(context, uri, 0, 0, dataSubscriber);
    }

    /**
     * @param width  如果图片尺寸不会导致outofmemory， width ＝ 0
     * @param height 同上
     */
    public void getBitmap(Context context, Uri uri, int width, int height, DataSubscriber dataSubscriber) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(uri);
        if (width > 0 && height > 0) {
            builder.setResizeOptions(new ResizeOptions(width, height));
        }
        ImageRequest request = builder.build();
        DataSource<CloseableReference<CloseableImage>>
                dataSource = imagePipeline.fetchDecodedImage(request, context);
        dataSource.subscribe(dataSubscriber, UiThreadImmediateExecutorService.getInstance());
    }

    public long getFrescoCacheSize() {
        long size = Fresco.getImagePipelineFactory().getMainFileCache().getSize();
        return ((size < 0) ? 0 : size);
    }

    public void clearFrescoCache() {
        Fresco.getImagePipelineFactory().getMainFileCache().clearAll();
    }

    private File getDiskCacheDir(Context context, String uniqueName) {
        try {
            String cachePath;
            if ((android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState())
                    || !android.os.Environment.isExternalStorageRemovable()) && context.getExternalCacheDir() != null) {
                cachePath = context.getExternalCacheDir().getPath();
            } else if (context.getCacheDir() != null) {
                cachePath = context.getCacheDir().getPath();
            } else {
                cachePath = "";
            }
            return new File(cachePath + File.separator + uniqueName);
        } catch (Exception e) {
            return new File(context.getCacheDir().getPath(), uniqueName);
        }
    }

}
