package com.yahier.androidtest.classload;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

import java.io.File;

import dalvik.system.DexClassLoader;

/**
 * Created by yahier on 17/3/21.
 * 测试ClassLoader
 */

public class LoaderAct extends BaseActivity {
    public static final String TAG = "LoaderAct";
    public static final String SHOWSTRINGCLASS = "showStringClass_impl.jar";
    public static final String SHOWSTRINGCLASS_PATH = "com.yahier.androidtest.classload.ShowStringClass";
    public static final String DEX = "dex";
    public ShowStringClass mShowStringClass = null;
    public TextView mTv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.text);

        mTv.setText("点击加载jar的方法");
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDexClassLoader();
            }
        });

        findViewById(R.id.btnTest).setOnClickListener(v -> {
            showClassLoader();
        });

    }

    /**
     * 使用DexClassLoader方式加载类
     */
    public void testDexClassLoader() {
        // dex压缩文件的路径（可以是apk,jar,zip格式）
        String dexPath = Environment.getExternalStorageDirectory().toString() + File.separator + SHOWSTRINGCLASS;

        // dex解压释放后的目录
        String dexOutputDirs = Environment.getExternalStorageDirectory().toString();

        //指定dexoutputpath为APP自己的缓存目录
        File dexOutputDir = getDir(DEX, 0);

        // 定义DexClassLoader
        // 第一个参数：是dex压缩文件的路径
        // 第二个参数：是dex解压缩后存放的目录
        // 第三个参数：是C/C++依赖的本地库文件目录,可以为null
        // 第四个参数：是上一级的类加载器
        DexClassLoader dexClassLoader = new DexClassLoader(dexPath, dexOutputDir.getAbsolutePath(), null, getClassLoader());
        // DexClassLoader dexClassLoader = new DexClassLoader(dexPath,dexOutputDirs,null,getClassLoader());


        Class libProvierClazz = null;
        // 使用DexClassLoader加载类
        try {
            libProvierClazz = dexClassLoader.loadClass(SHOWSTRINGCLASS_PATH);
            // 创建dynamic实例
            mShowStringClass = (ShowStringClass) libProvierClazz.newInstance();
            if (mShowStringClass != null) {
                final String chenyu = mShowStringClass.sayChenyu();
                if (chenyu != null) {
                    mTv.post(new Runnable() {
                        @Override
                        public void run() {
                            mTv.setText(chenyu);
                        }
                    });
                }
            } else {
                Log.d(TAG, "mShowStringClass is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印系统的classLoader
     */
    private void showClassLoader() {
        ClassLoader classLoader = getClassLoader();
        if (classLoader != null) {
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                Log.i(TAG, "loader:" + classLoader.toString());
            }
        }
    }
}
