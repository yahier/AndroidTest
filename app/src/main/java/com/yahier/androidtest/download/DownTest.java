package com.yahier.androidtest.download;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;

import static com.yahier.androidtest.classload.LoaderAct.TAG;


/**
 * 测试断点续传. 百分比显示。暂停。停止。断点续传。
 *
 * @author yahier.
 */

public class DownTest extends BaseActivity {
    static TextView text;
    static Context mContext;
    static boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down);
        requestPermisision();
        text = (TextView) findViewById(R.id.text);
        mContext = this;

        findViewById(R.id.start).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                System.out.println("开始");
                // 第二种方法。4.6s
                FileDownloader load = new FileDownloader();
                load.down();

                // 第一种方法 9.8s

	/*			if (flag == false) {
                    flag = true;
					return;
				}

				try {
					FileUtil.write(handler);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
            }
        });

        findViewById(R.id.pause).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                flag = false;
                System.out.println("暂停。。。");

            }
        });

        findViewById(R.id.stop).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.install).setOnClickListener(v -> {
            installSlient();
        });
    }

    private void requestPermisision() {
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions, 99);
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            Size size = (Size) msg.obj;
            float progress = size.getCurrent() / size.getAll() * 100;
            String float_str = String.valueOf(progress);
            int index = float_str.indexOf(".");
            if (index > 0)
                text.setText("进度是:" + float_str.substring(0, index) + "%");
            else
                text.setText("进度是:" + float_str + "%");
        }
    };


    String filePath = Environment.getExternalStorageDirectory().getPath() + "/dog.apk";

    private void install() {
        Log.i(TAG, "开始执行安装: " + filePath);
        File apkFile = new File(filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Log.w(TAG, "版本大于 N ，开始使用 fileProvider 进行安装");
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(
                    mContext
                    , "com.recycle.dog"
                    , apkFile);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            Log.w(TAG, "正常进行安装");
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        startActivity(intent);
    }

    private void installSlient() {
        String cmd = "pm install -r " + filePath;
        Process process = null;
        DataOutputStream os = null;
        BufferedReader successResult = null;
        BufferedReader errorResult = null;
        StringBuilder successMsg = null;
        StringBuilder errorMsg = null;
        try {
            //静默安装需要root权限
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.write(cmd.getBytes());
            os.writeBytes("\n");
            os.writeBytes("exit\n");
            os.flush();
            //执行命令
            process.waitFor();
            //获取返回结果
            successMsg = new StringBuilder();
            errorMsg = new StringBuilder();
            successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
            errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String s;
            while ((s = successResult.readLine()) != null) {
                successMsg.append(s);
            }
            while ((s = errorResult.readLine()) != null) {
                errorMsg.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (process != null) {
                    process.destroy();
                }
                if (successResult != null) {
                    successResult.close();
                }
                if (errorResult != null) {
                    errorResult.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //显示结果
        text.setText("成功消息：" + successMsg.toString() + "\n" + "错误消息: " + errorMsg.toString());
    }
}
