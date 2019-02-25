package com.yahier.androidtest.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.HandlerAsync;
import com.yahier.androidtest.util.HttpUtil;
import com.yahier.androidtest.util.YahierEventManager;
import com.yahier.androidtest.vo.YahierEvent;

/**
 * 测试服务器压力
 */
public class ServerStressTestAct extends BaseActivity implements YahierEventManager.OnListener {
    private final String url = "http://10.101.9.17:8080/";
    private final int requestCount = 100;

    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_server_sress);

        tvResult = (TextView) findViewById(R.id.tvResult);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            ready();
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            YahierEventManager.getInstance().remove(this);
        });

        //每次进来的this都是不同的
        YahierEventManager.getInstance().add(this);
    }


    private void ready() {
        Log.d("测试服务器压力", "开始");
        for (int i = 0; i < requestCount; i++) {
            getServerData();
        }
    }

    volatile int resultAllCount = 0;
    volatile int resultRightCount = 0;

    private void getServerData() {
        new HandlerAsync().execute(new HandlerAsync.Listener() {
            @Override
            public String getResult() {
                String result = HttpUtil.invoke(url);
                return result;
            }

            @Override
            public void handleResult(String result) {
                resultAllCount++;
                if (!TextUtils.isEmpty(result)) {
                    resultRightCount++;
                }

                tvResult.setText("得到响应的次数是:" + resultAllCount + "\n得到正确结果的次数是:" + resultRightCount);
            }
        });
    }


    @Override
    public void onInvoked(YahierEvent event) {
        Log.d("ServerStress onInvoked", "type" + event.getType());
    }
}
