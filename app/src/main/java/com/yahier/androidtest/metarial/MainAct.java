package com.yahier.androidtest.metarial;

import android.Manifest;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.View;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.MainActivity;
import com.yahier.androidtest.MediaPlayerTest;
import com.yahier.androidtest.R;
import com.yahier.androidtest.activity.ActivityHookTest;
import com.yahier.androidtest.activity.EventActivity;
import com.yahier.androidtest.activity.MonitorUiBlockActivity;
import com.yahier.androidtest.adapter.MainRecycleAdapter;
import com.yahier.androidtest.bitmap.ChooseImgTestAct;
import com.yahier.androidtest.bitmap.LargeImageViewActivity;
import com.yahier.androidtest.bitmap.ViewToBitmapAct;
import com.yahier.androidtest.classload.LoaderAct;
import com.yahier.androidtest.common.ReflectTest;
import com.yahier.androidtest.content.provider.TestCPActivity;
import com.yahier.androidtest.data.LogTest;
import com.yahier.androidtest.download.DownTest;
import com.yahier.androidtest.multipleThreads.OperateUiThreadAct;
import com.yahier.androidtest.multipleThreads.SynchonizedTest;
import com.yahier.androidtest.multipleThreads.TestHandlerThreadAct;
import com.yahier.androidtest.multipleThreads.TestIntentServiceAct;
import com.yahier.androidtest.multipleThreads.ThreadPoolAct;
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
import com.yahier.androidtest.test.ServerStressTestAct;
import com.yahier.androidtest.test.TestNotificationAct;
import com.yahier.androidtest.test.WebViewAct;
import com.yahier.androidtest.test.WindowTest;
import com.yahier.androidtest.test.WorkManagerAct;
import com.yahier.androidtest.ui.test.AwardAct;
import com.yahier.androidtest.ui.test.StatusBarFitColorAct;
import com.yahier.androidtest.util.ApacheCommonTestAct;
import com.yahier.androidtest.util.ArrayMapSparseArrayUtil;
import com.yahier.androidtest.util.YahierEventManager;
import com.yahier.androidtest.view.act.CommonViewTest;
import com.yahier.androidtest.view.act.ConstraintLayoutTest;
import com.yahier.androidtest.view.act.CustomRoungImgAct;
import com.yahier.androidtest.view.act.DrawableStyleAct;
import com.yahier.androidtest.view.act.DrawerLayoutActTest;
import com.yahier.androidtest.view.act.LazyFragmentAct;
import com.yahier.androidtest.view.act.MixImgAct;
import com.yahier.androidtest.view.act.MotionEventAct;
import com.yahier.androidtest.view.act.MyLayoutAct;
import com.yahier.androidtest.view.act.ParallaxVpTestActivity;
import com.yahier.androidtest.view.act.SurfaceViewTestAct;
import com.yahier.androidtest.view.act.SwipeBackMainActivity;
import com.yahier.androidtest.view.act.ViewLocationAct;
import com.yahier.androidtest.viewtest.CanvasTest;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by yahier on 16/12/30.
 * 列表显示 是按数字大小倒序排列的
 */

public class MainAct extends BaseActivity {
    private RecyclerView mRecyclerView;
    private TreeMap<String, MainItem> map;
    private MainAct mAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.material_main_act);
        setContentView(R.layout.material_main_act);
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


        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        setData();
        show();
        otherTest();

        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions, 99);

        YahierEventManager.getInstance().add(event -> {
            Log.d("事件接收了", "" + event.getType());
        });
    }

    /**
     * 其他java方法的测试
     */
    private void otherTest() {
        ArrayMapSparseArrayUtil.main(null);

    }

    /**
     * 请注意，显示效果是key大的，显示在上面
     */
    private void setData() {
        map = new TreeMap<>((o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1));
        map.put("63", new MainItem("使用 WorkManager 调度任务 ", "使用 WorkManager API 可以轻松地调度即使在应用退出或设备重启时仍应运行的可延迟异步任务", WorkManagerAct.class));
        map.put("62", new MainItem("绘制圆形图 和 融合图片", "利用PorterDuffXfermode取得两次绘制的效果 可以是上层交集 并集 取反 各种操作", MixImgAct.class));
        map.put("61", new MainItem("按需加载Fragment", "延迟加载", LazyFragmentAct.class));
        map.put("60", new MainItem("Hook测试", "", ActivityHookTest.class));
        map.put("59", new MainItem("事件总线测试", "", EventActivity.class));
        map.put("58", new MainItem("服务器压力测试", "", ServerStressTestAct.class));
        map.put("57", new MainItem("抽奖页面 滚动名单", "页面数据变换", AwardAct.class));
        map.put("56", new MainItem("UI线程卡顿监听", "Looper打印 消息列表 Choreographer", MonitorUiBlockActivity.class));
        map.put("55", new MainItem("apache common包测试", "BeanUtils CollectionsUtils", ApacheCommonTestAct.class));
        map.put("54", new MainItem("线程池", "吼吼吼", ThreadPoolAct.class));
        map.put("53", new MainItem("视频播放", "MediaPlayer配合surfaceView", MediaPlayerTest.class));
        map.put("52", new MainItem("下载安装测试", "下载完成之后，自动安装此app", DownTest.class));
        map.put("51", new MainItem("CollapsingToolbarLayout", "", CollapsingToolbarLayoutTest.class));
        map.put("50", new MainItem("约束性布局", "ConstraintLayout", ConstraintLayoutTest.class));
        map.put("49", new MainItem("状态栏适配变色", "", StatusBarFitColorAct.class));
        map.put("48", new MainItem("link测试", "link", AppLinkTestAct.class));
//        map.put("47", new MainItem("binding测试", "6:绑定容器 数组", Test6Act.class));
//        map.put("46", new MainItem("binding测试", "5:View随model变化 而变化 ", Test5Act.class));
//        map.put("45", new MainItem("binding测试", "4:绑定多个相同的model ", Test4Act.class));
//        map.put("44", new MainItem("binding测试", "3:静态方法调用.运算符操作数据 ", Test3Act.class));
//        map.put("43", new MainItem("binding测试", "2:事件绑定 ", Test2Act.class));
//        map.put("42", new MainItem("binding测试", "1:测试数据绑定 ", Test1Act.class));
        map.put("41", new MainItem("临时测试", "临时测试 ", MainActivity.class));
        map.put("40", new MainItem("java upper", "lambda测试 ", JavaUpperAct.class));
        map.put("39", new MainItem("WebView总结", "android与js的相互调用测试 ", WebViewAct.class));
        map.put("38", new MainItem("显示圆形图", "", CustomRoungImgAct.class));
        //哈 写反了
        map.put("1", new MainItem("矢量动画", "VectorSVG可缩放矢量动画 objectAnimator", VectorSVGAct.class));
        map.put("2", new MainItem("事件分发测试", MotionEventAct.class));
        map.put("3", new MainItem("drawable style效果", "详细解说一下", DrawableStyleAct.class));
        map.put("4", new MainItem("drawable效果  包括BitmapShader", "详细解说一下", DrawableAct.class));
        map.put("5", new MainItem("选图测试", "详细解说一下", ChooseImgTestAct.class));
        map.put("6", new MainItem("左侧滑动", "详细解说一下", SwipeBackMainActivity.class));
        map.put("7", new MainItem("自定义layout", "详细解说一下", MyLayoutAct.class));
        map.put("8", new MainItem("自定义View", "详细解说一下", ViewLocationAct.class));
        map.put("9", new MainItem("SurfaceView测试", "详细解说一下", SurfaceViewTestAct.class));
        map.put("10", new MainItem("测试广播", "详细解说一下", BroadCastActTest.class));
        map.put("11", new MainItem("测试ConfigChanges", "详细解说一下", ConfigChangesActTest.class));
        map.put("12", new MainItem("测试Handler处理", "详细解说一下", HandlerTest.class));
        map.put("13", new MainItem("测试通知 类似微博效果", "详细解说一下", TestNotificationAct.class));
        map.put("14", new MainItem("调通dex的方法", "详细解说一下", LoaderAct.class));
        map.put("15", new MainItem("加载超大图", "详细解说一下", LargeImageViewActivity.class));
        map.put("16", new MainItem("自定义ViewPager显示卷图", "详细解说一下", ParallaxVpTestActivity.class));
        map.put("17", new MainItem("glide加载图片 测试", "详细解说一下", GlideTestAct.class));
        map.put("18", new MainItem("material小特性", "translationZ  elevation", Material1Act.class));
        map.put("19", new MainItem("recycle", "详细解说一下", RecycleAct.class));
        map.put("20", new MainItem("cardview", "详细解说一下", CardViewAct.class));
        map.put("21", new MainItem("service", "测试service的启动停止和生命周期", ServiceActivity.class));
        map.put("22", new MainItem("ContentProvider", "详细解说一下", TestCPActivity.class));
        map.put("23", new MainItem("Synchonized", "测试synchonized", SynchonizedTest.class));
        map.put("24", new MainItem("反射", "详细解说一下", ReflectTest.class));
        map.put("25", new MainItem("messenger", "msgFromClient.replyTo = mMessenger", ActivityMessenger.class));
        map.put("26", new MainItem("AccessbilityService", "详细解说一下", AccessServiceAct.class));
        map.put("27", new MainItem("子线程操作UI", "详细解说一下", OperateUiThreadAct.class));
        map.put("28", new MainItem("CanvasTest", "详细解说一下", CanvasTest.class));
        map.put("29", new MainItem("SwipeBack", "详细解说一下", SwipeBackMainActivity.class));
        map.put("30", new MainItem("DrawerTest", "详细解说一下", DrawerLayoutActTest.class));
        map.put("31", new MainItem("View转换成bitmap", "详细解说一下", ViewToBitmapAct.class));
        map.put("32", new MainItem("本地记录Log", "", LogTest.class));
        map.put("33", new MainItem("WindowTest", "", WindowTest.class));
        map.put("34", new MainItem("HandlerThread", "详细解说一下", TestHandlerThreadAct.class));
        map.put("35", new MainItem("TestIntentService", "详细解说一下", TestIntentServiceAct.class));
        map.put("36", new MainItem("ViewTest", "", CommonViewTest.class));
        map.put("37", new MainItem("HtmlTest", "", HtmlAllTestActivity.class));
    }


    private void show() {
        final Collection<MainItem> valueItems = map.values();
        final Set<String> keySet = map.keySet();

        final MainItem[] itemArray = new MainItem[map.size()];
        final String[] keyArray = new String[map.size()];

        valueItems.toArray(itemArray);
        keySet.toArray(keyArray);

        for (int i = 0; i < map.size(); i++) {
            itemArray[i].setTitle(keyArray[i] + " " + itemArray[i].getTitle());
        }
        final MainRecycleAdapter mAdapter = new MainRecycleAdapter(itemArray);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClick(new MainRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClck(int i) {
                getWindow().setExitTransition(new Explode());
                Intent intent = new Intent(mAct, itemArray[i].getmAct());
                startActivity(intent);
//                startActivity(intent,
//                        ActivityOptions
//                                .makeSceneTransitionAnimation(mAct).toBundle());
            }
        });
    }


}
