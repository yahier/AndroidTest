package com.yahier.androidtest.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.adapter.GVImgAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahier on 17/3/13.
 */

public class GlideTestAct extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ListView listView = (ListView) findViewById(R.id.list);

        List<String> data = new ArrayList<>(20);
        data.add("http://c.hiphotos.baidu.com/image/pic/item/7acb0a46f21fbe09710bd1c26f600c338644ad8a.jpg");
        data.add("http://h.hiphotos.baidu.com/image/pic/item/a8ec8a13632762d0600802bfa2ec08fa513dc6f8.jpg");
        data.add("http://a.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb135c3b539dda51ea8d3fd1f4462.jpg");
        data.add("http://d.hiphotos.baidu.com/image/pic/item/4e4a20a4462309f753b3ec54770e0cf3d6cad69c.jpg");
        data.add("http://a.hiphotos.baidu.com/image/pic/item/42166d224f4a20a45e1514e095529822720ed089.jpg");
        data.add("http://f.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd461e3a610db30f2442a70f03.jpg");
        data.add("http://b.hiphotos.baidu.com/image/pic/item/574e9258d109b3de5d0c3261cebf6c81800a4c0c.jpg");
        data.add("http://f.hiphotos.baidu.com/image/pic/item/0b46f21fbe096b639392b42e0e338744eaf8acc1.jpg");
        data.add("http://f.hiphotos.baidu.com/image/pic/item/9358d109b3de9c826491213b6981800a18d8438a.jpg");
        data.add("http://c.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3ce21151a2b9045d688d53f20d5.jpg");
        data.add("http://b.hiphotos.baidu.com/image/pic/item/267f9e2f07082838a638b71eba99a9014c08f187.jpg");
        data.add("http://d.hiphotos.baidu.com/image/pic/item/f7246b600c338744084b7f70530fd9f9d72aa034.jpg");
        data.add("http://e.hiphotos.baidu.com/image/pic/item/c8177f3e6709c93d34c04c869c3df8dcd1005494.jpg");
        data.add("http://img.tupianzj.com/uploads/allimg/160809/9-160P9223326.jpg");
        data.add("http://img.tupianzj.com/uploads/allimg/160612/9-160612100H9.jpg");
        data.add("http://pic31.nipic.com/20130704/7447430_090814125000_2.jpg");
        data.add("http://tupian.enterdesk.net/2015/1106/20151106034033177.jpg");
        data.add("http://h.hiphotos.baidu.com/image/pic/item/d8f9d72a6059252d2baa7809369b033b5bb5b97a.jpg");
        data.add("http://b.hiphotos.baidu.com/image/pic/item/6f061d950a7b02086ab905b060d9f2d3572cc86a.jpg");
        data.add("http://d.hiphotos.baidu.com/image/h%3D360/sign=39d8f6ea552c11dfc1d1b92553276255/e850352ac65c10380842ffcbb0119313b07e89fe.jpg");
        data.add("http://f.hiphotos.baidu.com/image/pic/item/32fa828ba61ea8d320bb921b950a304e251f5810.jpg");

        GVImgAdapter adapter = new GVImgAdapter(this,data);
        listView.setAdapter(adapter);

    }
}
