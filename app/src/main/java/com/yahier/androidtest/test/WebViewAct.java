package com.yahier.androidtest.test;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

import java.io.Serializable;

/**
 * Created by yahier on 17/4/26.
 */

public class WebViewAct extends BaseActivity implements View.OnClickListener {
    WebView mWeb;
    final String tag = "yahier";
    final String TAG = "WebViewAct";

    private Button btn1, btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_act);
        mWeb = (WebView) findViewById(R.id.web);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        String assetPath = "file:///android_asset/index.html";
        mWeb.loadUrl(assetPath);
        //必须启用 才能和js交互
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        //控制webView的跳转
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.addJavascriptInterface(new JS(), tag);

        mWeb.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                //return true;
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

            }

//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//                LogUtil.logE("ANDROID_LAB", "TITLE=" + title);
//                webTitle = title;
//                // setLabel(title);
//                tvTitle.setText(title);
//            }
        });


        //代理host
        //mWeb.getSettings().setUserAgentString(settings.getUserAgentString() + ";STBL");
    }


    //测试webview直接打开下载地址。
    void testOpenLink() {
        String downloadUrl = "http://download.ydstatic.com/notewebsite/downloads/YoudaoNote.dmg";
        mWeb.loadUrl(downloadUrl);
    }


    private Handler mHandler = new Handler();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mWeb.loadUrl("javascript:testAlert()");
                testOpenLink();
                break;
            case R.id.btn2:
                mWeb.loadUrl("javascript:show('234')");
                break;
        }
    }

    private final class JS implements Serializable {

        @JavascriptInterface
        public void test(final String title) {
            mHandler.post(new Runnable() { //线程调用，需要回到主线程，否则点击分享的时候会崩溃
                @Override
                public void run() {
                    Log.e(TAG, "JS test " + title);
                    btn1.setText(title);

                }
            });
        }

        @JavascriptInterface
        public String test2() {
            Log.e(TAG, "JS test2");
            return "yahier...";
        }

    }


}
