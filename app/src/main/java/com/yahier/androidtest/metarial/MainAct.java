package com.yahier.androidtest.metarial;

import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.MainActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.adapter.MainRecycleAdapter;
import com.yahier.androidtest.bitmap.ChooseImgTestAct;
import com.yahier.androidtest.bitmap.LargeImageViewActivity;
import com.yahier.androidtest.bitmap.ViewToBitmapAct;
import com.yahier.androidtest.classload.LoaderAct;
import com.yahier.androidtest.common.MyApp;
import com.yahier.androidtest.common.ReflectTest;
import com.yahier.androidtest.content.provider.TestCPActivity;
import com.yahier.androidtest.data.LogTest;
import com.yahier.androidtest.databinding.MaterialMainActBinding;
import com.yahier.androidtest.databinding.Test1Act;
import com.yahier.androidtest.databinding.Test2Act;
import com.yahier.androidtest.databinding.Test3Act;
import com.yahier.androidtest.databinding.Test4Act;
import com.yahier.androidtest.databinding.Test5Act;
import com.yahier.androidtest.databinding.Test6Act;
import com.yahier.androidtest.download.DownTest;
import com.yahier.androidtest.multipleThreads.OperateUiThreadAct;
import com.yahier.androidtest.multipleThreads.SynchonizedTest;
import com.yahier.androidtest.multipleThreads.TestHandlerThreadAct;
import com.yahier.androidtest.multipleThreads.TestIntentServiceAct;
import com.yahier.androidtest.service.AccessServiceAct;
import com.yahier.androidtest.service.ActivityMessenger;
import com.yahier.androidtest.service.ServiceActivity;
import com.yahier.androidtest.test.AppLinkTestAct;
import com.yahier.androidtest.test.BroadCastActTest;
import com.yahier.androidtest.test.ConfigChangesActTest;
import com.yahier.androidtest.test.DrawableAct;
import com.yahier.androidtest.test.GlideTestAct;
import com.yahier.androidtest.test.HandlerTest;
import com.yahier.androidtest.test.HtmlAllTestActivity;
import com.yahier.androidtest.test.JavaUpperAct;
import com.yahier.androidtest.test.TestNotificationAct;
import com.yahier.androidtest.test.WebViewAct;
import com.yahier.androidtest.test.WindowTest;
import com.yahier.androidtest.ui.test.StatusBarFitColorAct;
import com.yahier.androidtest.util.ArrayMapSparseArrayUtil;
import com.yahier.androidtest.view.act.CommonViewTest;
import com.yahier.androidtest.view.act.ConstraintLayoutTest;
import com.yahier.androidtest.view.act.CustomRoungImgAct;
import com.yahier.androidtest.view.act.DrawableStyleAct;
import com.yahier.androidtest.view.act.DrawerLayoutActTest;
import com.yahier.androidtest.view.act.MotionEventAct;
import com.yahier.androidtest.view.act.MyLayoutAct;
import com.yahier.androidtest.view.act.ParallaxVpTestActivity;
import com.yahier.androidtest.view.act.SurfaceViewTestAct;
import com.yahier.androidtest.view.act.SwipeBackMainActivity;
import com.yahier.androidtest.view.act.ViewLocationAct;
import com.yahier.androidtest.viewtest.CanvasTest;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by yahier on 16/12/30.
 */

public class MainAct extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<String> datas;
    LinkedHashMap<String, MainItem> linkedHashMap;
    MainAct mAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.material_main_act);
        MaterialMainActBinding bind = DataBindingUtil.setContentView(MainAct.this, R.layout.material_main_act);
        mAct = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);


        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //加上间隔线。这个操作还有更多强大的功能
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);

            }


            /**
             * onDraw方法先于drawChildren
             * onDrawOver在drawChildren之后，一般我们选择复写其中一个即可。
             */
            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(Color.parseColor("#dddddd"));

                int childCount = parent.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = parent.getChildAt(i);
                    int leftPosition = (int) child.getX();//getX()也是可以啦
                    int rightPosition = leftPosition + child.getWidth();
                    c.drawLine(leftPosition, child.getBottom(), rightPosition, child.getBottom(), paint);
                }

            }


            //getItemOffsets 可以通过outRect.set()为每个Item设置一定的偏移量，主要用于绘制Decorator。
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }


        });
        //引用失败
        Button btn = bind.tv;
        btn.setText("yahier的现实");

        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        setData();
        show();
        otherTest();
        //testLink();

    }

    void otherTest() {
        ArrayMapSparseArrayUtil.main(null);
        testApp();

    }

    //空指针 妥妥的
    void testApp() {
        String str = MyApp.getContext().getString(R.string.hello_world);
        Log.e("testApp", str);
    }

    //跳转yaya:
    private void testLink() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("yaya://www.baidu.com"));
        startActivity(intent);

    }

    void setData() {
        linkedHashMap = new LinkedHashMap<String, MainItem>();
        linkedHashMap.put("52", new MainItem("下载安装测试", "下载完成之后，自动安装此app", DownTest.class));
        linkedHashMap.put("51", new MainItem("CollapsingToolbarLayout", "", CollapsingToolbarLayoutTest.class));
        linkedHashMap.put("50", new MainItem("约束性布局", "", ConstraintLayoutTest.class));
        linkedHashMap.put("49", new MainItem("状态栏适配变色", "", StatusBarFitColorAct.class));
        linkedHashMap.put("48", new MainItem("link测试", "link", AppLinkTestAct.class));
        linkedHashMap.put("47", new MainItem("binding测试", "6:绑定容器 数组", Test6Act.class));
        linkedHashMap.put("46", new MainItem("binding测试", "5:View随model变化 而变化 ", Test5Act.class));
        linkedHashMap.put("45", new MainItem("binding测试", "4:绑定多个相同的model ", Test4Act.class));
        linkedHashMap.put("44", new MainItem("binding测试", "3:静态方法调用.运算符操作数据 ", Test3Act.class));
        linkedHashMap.put("43", new MainItem("binding测试", "2:事件绑定 ", Test2Act.class));
        linkedHashMap.put("42", new MainItem("binding测试", "1:测试数据绑定 ", Test1Act.class));

        linkedHashMap.put("41", new MainItem("临时测试", "临时测试 ", MainActivity.class));
        linkedHashMap.put("40", new MainItem("java upper", "lambda测试 ", JavaUpperAct.class));
        linkedHashMap.put("39", new MainItem("WebView总结", "android与js的相互调用测试 ", WebViewAct.class));
        linkedHashMap.put("1", new MainItem("矢量动画", "", VectorSVNAct.class));
        linkedHashMap.put("2", new MainItem("事件分发测试", MotionEventAct.class));
        linkedHashMap.put("3", new MainItem("drawable style效果", "详细解说一下", DrawableStyleAct.class));
        linkedHashMap.put("4", new MainItem("drawable效果  包括BitmapShader", "详细解说一下", DrawableAct.class));
        linkedHashMap.put("5", new MainItem("选图测试", "详细解说一下", ChooseImgTestAct.class));
        linkedHashMap.put("6", new MainItem("左侧滑动", "详细解说一下", SwipeBackMainActivity.class));
        linkedHashMap.put("7", new MainItem("自定义layout", "详细解说一下", MyLayoutAct.class));
        linkedHashMap.put("8", new MainItem("自定义View", "详细解说一下", ViewLocationAct.class));
        linkedHashMap.put("38", new MainItem("显示圆形图", "", CustomRoungImgAct.class));
        linkedHashMap.put("9", new MainItem("SurfaceView测试", "详细解说一下", SurfaceViewTestAct.class));
        linkedHashMap.put("10", new MainItem("测试广播", "详细解说一下", BroadCastActTest.class));
        linkedHashMap.put("11", new MainItem("测试ConfigChanges", "详细解说一下", ConfigChangesActTest.class));
        linkedHashMap.put("12", new MainItem("测试Handler处理", "详细解说一下", HandlerTest.class));
        linkedHashMap.put("13", new MainItem("测试通知 类似微博效果", "详细解说一下", TestNotificationAct.class));
        linkedHashMap.put("14", new MainItem("调通dex的方法", "详细解说一下", LoaderAct.class));
        linkedHashMap.put("15", new MainItem("加载超大图", "详细解说一下", LargeImageViewActivity.class));
        linkedHashMap.put("16", new MainItem("自定义ViewPager显示卷图", "详细解说一下", ParallaxVpTestActivity.class));
        linkedHashMap.put("17", new MainItem("glide加载图片 测试", "详细解说一下", GlideTestAct.class));
        linkedHashMap.put("18", new MainItem("material小特性", "translationZ  elevation", Material1Act.class));
        linkedHashMap.put("19", new MainItem("recycle", "详细解说一下", RecycleAct.class));
        linkedHashMap.put("20", new MainItem("cardview", "详细解说一下", CardViewAct.class));
        linkedHashMap.put("21", new MainItem("service", "详细解说一下", ServiceActivity.class));
        linkedHashMap.put("22", new MainItem("ContentProvider", "详细解说一下", TestCPActivity.class));
        linkedHashMap.put("23", new MainItem("Synchonized", "详细解说一下", SynchonizedTest.class));
        linkedHashMap.put("24", new MainItem("反射", "详细解说一下", ReflectTest.class));
        linkedHashMap.put("25", new MainItem("messenger", "msgFromClient.replyTo = mMessenger", ActivityMessenger.class));
        linkedHashMap.put("26", new MainItem("AccessbilityService", "详细解说一下", AccessServiceAct.class));
        linkedHashMap.put("27", new MainItem("子线程操作UI", "详细解说一下", OperateUiThreadAct.class));
        linkedHashMap.put("28", new MainItem("CanvasTest", "详细解说一下", CanvasTest.class));
        linkedHashMap.put("29", new MainItem("SwipeBack", "详细解说一下", SwipeBackMainActivity.class));
        linkedHashMap.put("30", new MainItem("DrawerTest", "详细解说一下", DrawerLayoutActTest.class));
        linkedHashMap.put("31", new MainItem("View转换成bitmap", "详细解说一下", ViewToBitmapAct.class));
        linkedHashMap.put("32", new MainItem("本地记录Log", "", LogTest.class));
        linkedHashMap.put("33", new MainItem("WindowTest", "", WindowTest.class));
        linkedHashMap.put("34", new MainItem("HandlerThread", "详细解说一下", TestHandlerThreadAct.class));
        linkedHashMap.put("35", new MainItem("TestIntentService", "详细解说一下", TestIntentServiceAct.class));
        linkedHashMap.put("36", new MainItem("ViewTest", "", CommonViewTest.class));
        linkedHashMap.put("37", new MainItem("HtmlTest", "", HtmlAllTestActivity.class));
    }


    private void show() {
        final Collection<MainItem> items = linkedHashMap.values();
        final MainItem[] itemArray = new MainItem[items.size()];
        items.toArray(itemArray);
        final MainRecycleAdapter mAdapter = new MainRecycleAdapter(itemArray);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClick(new MainRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClck(int i) {
                getWindow().setExitTransition(new Explode());
                Intent intent = new Intent(mAct, itemArray[i].getmAct());
                startActivity(intent,
                        ActivityOptions
                                .makeSceneTransitionAnimation(mAct).toBundle());
            }
        });
    }


}
