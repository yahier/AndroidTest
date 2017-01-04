package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.content.provider.TestCPActivity;
import com.yahier.androidtest.multipleThreads.SynchonizedTest;
import com.yahier.androidtest.service.ServiceActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by yahier on 16/12/30.
 */

public class MainAct extends Activity {
    ListView listView;
    List<String> datas;
    HashMap<String, Class> map;
    MainAct mAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_main_act);
        mAct = this;
        listView = (ListView) findViewById(R.id.listView);
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
        map = new HashMap<>();
        datas = new ArrayList<>();
        map.put("小二", Material1Act.class);
        map.put("recycle", RecycleAct.class);
        map.put("cardview", CardViewAct.class);
        map.put("service", ServiceActivity.class);
        map.put("ContentProvider", TestCPActivity.class);
        map.put("SynchonizedTest", SynchonizedTest.class);

        Set<String> names = map.keySet();
        datas.addAll(names);

    }


    void show() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }


}
