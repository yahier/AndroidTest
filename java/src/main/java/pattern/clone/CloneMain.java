package pattern.clone;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yahier on 12/19/18.
 * 原型模式 Cloneable接口和clone方法一点关联都没有的
 */

public class CloneMain {

    public static void main(String[] args) {
        Map<String, PointBean> map = new HashMap<>();
        map.put("1", new PointBean("1123"));
        map.put("2", new PointBean("2123"));
        map.put("3", new PointBean("3123"));
        map.put("4", new PointBean("4123"));
        map.put("5", new PointBean("5123"));

        Map cloneMap = getClonePointMap(map);
        cloneMap.put("6", new PointBean("6123"));

        showMapData("原数据", map);
        showMapData("副本数据", cloneMap);
    }

    private static HashMap getClonePointMap(Map map) {
        HashMap clone = new HashMap<>();
        if (map != null) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = (String) entry.getKey();
                PointBean pointBean = (PointBean) entry.getValue();
                if (pointBean != null) {
                    //遍历map并将克隆对象放到新的map中
                    clone.put(key, pointBean.clone());
                } else {
                    clone.put(key, null);
                }
            }
        }
        return clone;
    }


    private static void showMapData(String tag, Map<String, PointBean> map) {
        Collection<PointBean> collections = map.values();
        for (PointBean bean : collections) {
            System.out.println(tag + " " + bean.getPointName());
        }
    }
}
