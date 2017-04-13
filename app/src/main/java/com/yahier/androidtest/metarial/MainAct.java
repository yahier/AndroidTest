package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.bitmap.ChooseImgTestAct;
import com.yahier.androidtest.bitmap.LargeImageViewActivity;
import com.yahier.androidtest.bitmap.ViewToBitmapAct;
import com.yahier.androidtest.classload.LoaderAct;
import com.yahier.androidtest.common.ReflectTest;
import com.yahier.androidtest.content.provider.TestCPActivity;
import com.yahier.androidtest.data.LogTest;
import com.yahier.androidtest.multipleThreads.OperateUiThreadAct;
import com.yahier.androidtest.multipleThreads.SynchonizedTest;
import com.yahier.androidtest.multipleThreads.TestHandlerThreadAct;
import com.yahier.androidtest.multipleThreads.TestIntentServiceAct;
import com.yahier.androidtest.service.AccessServiceAct;
import com.yahier.androidtest.service.ActivityMessenger;
import com.yahier.androidtest.service.ServiceActivity;
import com.yahier.androidtest.test.BroadCastActTest;
import com.yahier.androidtest.test.ConfigChangesActTest;
import com.yahier.androidtest.test.DrawableAct;
import com.yahier.androidtest.test.GlideTestAct;
import com.yahier.androidtest.test.HandlerTest;
import com.yahier.androidtest.test.HtmlAllTestActivity;
import com.yahier.androidtest.test.TestNotificationAct;
import com.yahier.androidtest.test.WindowTest;
import com.yahier.androidtest.view.act.CommonViewTest;
import com.yahier.androidtest.view.act.DrawableStyleAct;
import com.yahier.androidtest.view.act.DrawerLayoutActTest;
import com.yahier.androidtest.view.act.MotionEventAct;
import com.yahier.androidtest.view.act.MyLayoutAct;
import com.yahier.androidtest.view.act.ParallaxVpTestActivity;
import com.yahier.androidtest.view.act.SurfaceViewTestAct;
import com.yahier.androidtest.view.act.SwipeBackMainActivity;
import com.yahier.androidtest.view.act.ViewLocationAct;
import com.yahier.androidtest.viewtest.CanvasTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by yahier on 16/12/30.
 */

public class MainAct extends AppCompatActivity {

    ListView listView;
    List<String> datas;
    LinkedHashMap<String, Class> map;
    MainAct mAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.material_main_act);
        ViewDataBinding bind = DataBindingUtil.setContentView(MainAct.this, R.layout.material_main_act);
        mAct = this;
        listView = (ListView) findViewById(R.id.list_view);
        //引用失败
        //Button btn = bind.tv;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Collection<Class> e = map.values();
                Class[] classes = new Class[e.size()];

                getWindow().setExitTransition(new Explode());
                Intent intent = new Intent(mAct, e.toArray(classes)[i]);
                startActivity(intent,
                        ActivityOptions
                                .makeSceneTransitionAnimation(mAct).toBundle());

            }
        });

        setData();
        show();
    }


    void setData() {
        map = new LinkedHashMap<>();
        datas = new ArrayList<>();
        map.put("事件分发测试", MotionEventAct.class);
        map.put("drawable style效果", DrawableStyleAct.class);
        map.put("drawable效果  包括BitmapShader.", DrawableAct.class);
        map.put("选图测试", ChooseImgTestAct.class);
        map.put("选图测试", ChooseImgTestAct.class);
        map.put("左侧滑动", SwipeBackMainActivity.class);
        map.put("自定义layout", MyLayoutAct.class);
        map.put("自定义View", ViewLocationAct.class);
        map.put("SurfaceView测试", SurfaceViewTestAct.class);
        map.put("测试广播", BroadCastActTest.class);
        map.put("测试ConfigChanges", ConfigChangesActTest.class);
        map.put("测试Handler处理", HandlerTest.class);
        map.put("测试通知 类似微博效果", TestNotificationAct.class);
        map.put("调通dex的方法", LoaderAct.class);
        map.put("加载超大图", LargeImageViewActivity.class);
        map.put("自定义ViewPager显示卷图", ParallaxVpTestActivity.class);
        map.put("glide加载图片 测试", GlideTestAct.class);
        map.put("小二", Material1Act.class);
        map.put("recycle", RecycleAct.class);
        map.put("cardview", CardViewAct.class);
        map.put("service", ServiceActivity.class);
        map.put("ContentProvider", TestCPActivity.class);
        map.put("Synchonized", SynchonizedTest.class);
        map.put("反射", ReflectTest.class);
        map.put("messenger", ActivityMessenger.class);
        map.put("AccessbilityService", AccessServiceAct.class);
        map.put("子线程操作UI", OperateUiThreadAct.class);
        map.put("CanvasTest", CanvasTest.class);
        map.put("SwipeBack", SwipeBackMainActivity.class);
        map.put("DrawerTest", DrawerLayoutActTest.class);
        map.put("View转换成bitmap", ViewToBitmapAct.class);
        map.put("本地记录Log", LogTest.class);
        map.put("WindowTest", WindowTest.class);
        map.put("HandlerThread", TestHandlerThreadAct.class);
        map.put("TestIntentService", TestIntentServiceAct.class);
        map.put("ViewTest", CommonViewTest.class);
        map.put("HtmlTest", HtmlAllTestActivity.class);
        Set<String> names = map.keySet();
        datas.addAll(names);
    }


    void show() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }


}
