package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.yahier.androidtest.R;
import com.yahier.androidtest.ver.tab.LoveAsk;
import com.yahier.androidtest.ver.tab.LoveHeart;

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
    HashMap<String,Class> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_main_act);
        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
                Collection<Class> e =  map.values();
                Class[] classes  = new Class[e.size()];
                Intent intent = new Intent(MainAct.this,e.toArray(classes)[i]);
                startActivity(intent);


            }
        });

        setData();
        show();
    }


    void setData(){
       map = new HashMap<>();
        datas = new ArrayList<>();
       map.put("小二",LoveAsk.class);
        map.put("小si",LoveHeart.class);

       Set<String> names = map.keySet();
        datas.addAll(names);

    }


    void show(){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }
}
