package com.yahier.androidtest.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.yahier.androidtest.util.AMSInvocationHandler;
import com.yahier.androidtest.util.ActivityProxyInstrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HookHelper {

    final static String TAG = "HookHelper";

    /**
     * hook通知
     */
    public static void hookNotificationManager(final Context context) throws Exception {
        Log.d(TAG, "调用 hookNotificationManager");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Method getService = NotificationManager.class.getDeclaredMethod("getService");
        getService.setAccessible(true);
        // 第一步：得到系统的 sService
        final Object sOriginService = getService.invoke(notificationManager);

        Class iNotiMngClz = Class.forName("android.app.INotificationManager");
        // 第二步：得到我们的动态代理对象
        Object proxyNotiMananer = Proxy.newProxyInstance(context.getClass().getClassLoader(), new
                Class[]{iNotiMngClz}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Log.d(TAG, "invoke(). method:" + method);
                String name = method.getName();
                Log.d(TAG, "invoke: name=" + name);
                if (args != null && args.length > 0) {
                    for (Object arg : args) {
                        Log.d(TAG, "invoke: arg=" + arg);
                    }
                }
                Toast.makeText(context.getApplicationContext(), "检测到有人发通知了", Toast.LENGTH_SHORT).show();
                // 操作交由 sOriginService 处理，不拦截通知
                return method.invoke(sOriginService, args);
                // 拦截通知，什么也不做
                // return null;
                // 或者是根据通知的 Tag 和 ID 进行筛选
            }
        });
        // 第三步：偷梁换柱，使用 proxyNotiMng 替换系统的 sService
        Field sServiceField = NotificationManager.class.getDeclaredField("sService");
        sServiceField.setAccessible(true);
        sServiceField.set(notificationManager, proxyNotiMananer);

    }

    public static void replaceInstrumentation(Activity activity) throws Exception {
        Class<?> k = Activity.class;
        //通过Activity.class 拿到 mInstrumentation字段
        Field field = k.getDeclaredField("mInstrumentation");
        field.setAccessible(true);
        //根据activity内mInstrumentation字段 获取Instrumentation对象
        Instrumentation instrumentation = (Instrumentation) field.get(activity);
        //创建代理对象
        Instrumentation instrumentationProxy = new ActivityProxyInstrumentation(instrumentation);
        //进行替换
        field.set(activity, instrumentationProxy);
    }


    /**
     * 测试失败 也许需要api26之后
     */
    public static void hookAMS() throws Exception {
        // 第一步：获取 IActivityManagerSingleton
        Class<?> aClass = Class.forName("android.app.ActivityManager");
        Field declaredField = aClass.getDeclaredField("IActivityManagerSingleton");
        declaredField.setAccessible(true);
        Object value = declaredField.get(null);

        Class<?> singletonClz = Class.forName("android.util.Singleton");
        Field instanceField = singletonClz.getDeclaredField("mInstance");
        instanceField.setAccessible(true);
        Object iActivityManagerObject = instanceField.get(value);

        // 第二步：获取我们的代理对象，这里因为 IActivityManager 是接口，我们使用动态代理的方式
        Class<?> iActivity = Class.forName("android.app.IActivityManager");
        InvocationHandler handler = new AMSInvocationHandler(iActivityManagerObject);
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new
                Class<?>[]{iActivity}, handler);

        // 第三步：偷梁换柱，将我们的 proxy 替换原来的对象
        instanceField.set(value, proxy);

    }
}
