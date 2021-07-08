package com.yahier.androidtest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewTreeObserver;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.DisplayUtil;
import com.yahier.androidtest.util.FrescoUtil;

import java.io.File;
import java.util.Random;

//import com.zdyl.mfood.R;
//import com.zdyl.mfood.utils.FrescoUtil;

/**
 * 当前所使用的1.13.0版本有内存泄露的破绽 参考https://github.com/facebook/fresco/releases
 */
public class MImageView extends SimpleDraweeView {

    private String imageUrl;
    private boolean autoAspectRatio;
    private int mWidth = 0;
    private int mHeight = 0;

    /**
     * 占位颜色
     */
    private int[] placeholderColors = {R.color.default_color_fff5f0,
            R.color.default_color_fffceb,
            R.color.default_color_f0fff5,
            R.color.default_color_f0feff,
            R.color.default_color_faf5fe};

    public MImageView(Context context) {
        this(context, null);
    }

    public MImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

    public MImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MImageView, defStyle, 0);
        mWidth = a.getLayoutDimension(R.styleable.MImageView_android_layout_width, 0);
        mHeight = a.getLayoutDimension(R.styleable.MImageView_android_layout_height, 0);
        imageUrl = a.getString(R.styleable.MImageView_imageUrl);
        autoAspectRatio = a.getBoolean(R.styleable.MImageView_autoAspectRatio, false);

        float aspectRatio = a.getFloat(R.styleable.MImageView_aspectRatio, 0);
        int maskGradientScrimGravity = a.getInt(R.styleable.MImageView_maskGradientScrimGravity, 0);
        @ColorInt int maskGradientScrimColor = a.getColor(R.styleable.MImageView_maskGradientScrimColor, 0xaa000000);
        a.recycle();
        if (aspectRatio > 0) {
            setAspectRatio(aspectRatio);
        }
        setImageUrl(imageUrl);
        if (maskGradientScrimGravity > 0) {
            setOverlayDrawable(scrimDrawable(maskGradientScrimColor, 9, maskGradientScrimGravity == 1 ? Gravity.TOP
                    : (maskGradientScrimGravity == 2 ? Gravity.CENTER : Gravity.BOTTOM)));
        }
        if (mWidth <= 0 && mHeight <= 0) {
            globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (getWidth() == 0 || getHeight() == 0) {
                        return;
                    }
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    mWidth = getWidth();
                    mHeight = getHeight();
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
        }
        GenericDraweeHierarchy hierarchy = getHierarchy();
        if (hierarchy != null && !hierarchy.hasPlaceholderImage()) {
            Random random = new Random();
            int number = random.nextInt(placeholderColors.length);
            setPlaceholderImage(placeholderColors[number]);
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (globalLayoutListener != null) {
            try {
                getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
                globalLayoutListener = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void setImageUrl(String imageUrl) {
        if (TextUtils.isEmpty(imageUrl) || !imageUrl.contains(".gif")) {
            setImageUrl(imageUrl, autoAspectRatio);
        } else {
            setGif(imageUrl);
        }
    }

    public void setImageUrl(String imageUrl, boolean autoAspectRatio) {
        if (imageUrl == null) {
            imageUrl = "";
        }
        if (autoAspectRatio && !TextUtils.isEmpty(imageUrl)) {
            setAspectRatio(1);
            loadImageForAutoAspectRatio(imageUrl);
            return;
        }
        this.imageUrl = imageUrl;
        if (imageUrl.startsWith("/")) { //local file
            imageUrl = Uri.fromFile(new File(imageUrl)).toString();
        }
        FrescoUtil.getInstance().setImageSrc(this, imageUrl, mWidth, mHeight);
    }

    public void setGif(String imageUrl) {
        Uri uri = Uri.parse(imageUrl);
        DraweeController draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(true)
                        .setControllerListener(getImageListener())
                        .build();
        setController(draweeController);
    }

    public void setPlaceholderImage(@DrawableRes int drawableId) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(drawableId);
    }

    public void setPlaceholderImage(@NonNull Drawable drawable) {
        if (drawable == null) {
            return;
        }
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(drawable);
    }

    public void setPlaceholderImage(@DrawableRes int drawableId, ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(drawableId, scaleType);
    }

    public void setPlaceholderImage(@NonNull Drawable drawable, ScalingUtils.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(drawable, scaleType);
    }

    public void setImageUri(@NonNull Uri uri) {
        setImageUrl(uri.toString());
    }

    /**
     * @param imageUrl
     * @param width    自定义的宽高
     * @param height
     */
    public void setImageUrl(@NonNull String imageUrl, int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
        setImageUrl(imageUrl);
    }

    public void setOverlayDrawable(@NonNull Drawable drawable) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = genericDraweeHierarchyBuilder
                .setOverlay(drawable)
                .build();
        setHierarchy(hierarchy);
    }

    public void setRadius(float radiusDP) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setRoundingParams(RoundingParams.fromCornersRadius( DisplayUtil.INSTANCE.dip2px(getContext(), radiusDP)));
    }

    private void loadImageForAutoAspectRatio(final String imageUrl) {
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(imageUrl))
                .build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        final DataSource<CloseableReference<CloseableImage>>
                dataSource = imagePipeline.fetchDecodedImage(imageRequest, this);

        dataSource.subscribe(new BaseBitmapDataSubscriber() {

            @Override
            public void onNewResultImpl(@Nullable Bitmap bitmap) {
                float aspectRatio = 1;
                if (dataSource.isFinished() && bitmap != null && bitmap.getHeight() > 0) {
                    aspectRatio = bitmap.getWidth() / (float) bitmap.getHeight();
                    dataSource.close();
                }
                setMeasureAspectRatio(aspectRatio);
            }

            @Override
            public void onFailureImpl(DataSource dataSource) {
                if (dataSource != null) {
                    dataSource.close();
                }
                setMeasureAspectRatio(1);
            }

            private void setMeasureAspectRatio(final float aspectRatio) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        setAspectRatio(aspectRatio);
                        setImageUrl(imageUrl, false);
                    }
                });
            }
        }, CallerThreadExecutor.getInstance());
    }

    private ImageListener imageListener;

    public ImageListener getImageListener() {
        return imageListener;
    }

    public void setImageListener(ImageListener imageListener) {
        this.imageListener = imageListener;
    }

    public Drawable scrimDrawable(int baseColor, int numStops, int gravity) {
        numStops = Math.max(numStops, 2);

        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());

        final int[] stopColors = new int[numStops];

        int red = Color.red(baseColor);
        int green = Color.green(baseColor);
        int blue = Color.blue(baseColor);
        int alpha = Color.alpha(baseColor);

        for (int i = 0; i < numStops; i++) {
            float x = i * 1f / (numStops - 1);
            float opacity = Math.max(0, Math.min(1, (float) Math.pow(x, 3)));
            stopColors[i] = Color.argb((int) (alpha * opacity), red, green, blue);
        }

        final float x0, x1, y0, y1;
        switch (gravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
            case Gravity.LEFT:
                x0 = 1;
                x1 = 0;
                break;
            case Gravity.RIGHT:
                x0 = 0;
                x1 = 1;
                break;
            default:
                x0 = 0;
                x1 = 0;
                break;
        }
        switch (gravity & Gravity.VERTICAL_GRAVITY_MASK) {
            case Gravity.TOP:
                y0 = 1;
                y1 = 0;
                break;
            case Gravity.BOTTOM:
                y0 = 0;
                y1 = 1;
                break;
            default:
                y0 = 0;
                y1 = 0;
                break;
        }

        paintDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient linearGradient = new LinearGradient(
                        width * x0,
                        height * y0,
                        width * x1,
                        height * y1,
                        stopColors, null,
                        Shader.TileMode.CLAMP);
                return linearGradient;
            }
        });

        //android4.1.2bug
        paintDrawable.setPadding(new Rect());

        return paintDrawable;
    }

    public static class ImageListener extends BaseControllerListener<ImageInfo> {

        protected void onFinalImageSet(int width, int height) {

        }

        protected void onFailure(Throwable throwable) {
        }

        @Override
        public final void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            if (imageInfo.getWidth() == 0
                    || imageInfo.getHeight() == 0) {
                onFailure(new IllegalArgumentException("image info with/height is zero"));
            } else {
                onFinalImageSet(imageInfo.getWidth(), imageInfo.getHeight());
            }
        }

        @Override
        public final void onFailure(String id, Throwable throwable) {
            onFailure(throwable);
        }

        @Override
        public final void onIntermediateImageSet(String id, ImageInfo imageInfo) {
            onFinalImageSet(imageInfo.getWidth(), imageInfo.getHeight());
        }

        @Override
        public final void onIntermediateImageFailed(String id, Throwable throwable) {

        }
    }
}