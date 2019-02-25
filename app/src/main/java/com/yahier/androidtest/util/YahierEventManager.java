package com.yahier.androidtest.util;

import android.util.Log;

import com.yahier.androidtest.vo.YahierEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 从观察者模式到EventBus 。接口和注解两种方式
 */
public class YahierEventManager {
    private static YahierEventManager manager;
    private List<OnListener> listSubscriber;

    private YahierEventManager() {
    }

    static {
        manager = new YahierEventManager();
    }

    public static YahierEventManager getInstance() {
        return manager;
    }

    public void add(OnListener listener) {
        if (listSubscriber == null) {
            listSubscriber = new ArrayList<>();
        }

        if (!listSubscriber.contains(listener))
            listSubscriber.add(listener);
    }

    public void remove(OnListener listener) {
        if (listSubscriber == null) {
            return;
        }

        listSubscriber.remove(listener);
    }


    public void post(YahierEvent event) {
        if (listSubscriber == null)
            return;

        for (OnListener listener : listSubscriber) {
            listener.onInvoked(event);
        }
    }


    public interface OnListener {
        void onInvoked(YahierEvent event);
    }


    //todo 上面针对接口
    //todo 以下针对注解


    private List<Object> listObj;

    public void addAnnotation(Object object) {
        if (listObj == null) {
            listObj = new ArrayList<>();
        }

        if (!listObj.contains(object))
            listObj.add(object);
    }


    public void removeAnnotation(Object object) {
        if (listObj == null) {
            return;
        }

        listObj.remove(object);
    }


    /**
     * 给实现了注解了方法发送广播
     */
    public void postAnnotation(YahierEvent event) {
        if (listObj == null)
            return;
        for (Object object : listObj) {
            Class mClass = object.getClass();
            try {
                Method method = mClass.getDeclaredMethod("onYahierEvent", new Class[]{YahierEvent.class});
                Yahier yahier = method.getAnnotation(Yahier.class);
                int type = yahier.type();
                Log.d("postAnnotation", "type:" + type);

                try {
                    method.invoke(object, event);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }

}
