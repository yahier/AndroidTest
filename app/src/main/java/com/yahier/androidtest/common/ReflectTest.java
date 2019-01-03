package com.yahier.androidtest.common;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/1/4.
 */

public class ReflectTest extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        Button btn1 =  (Button)findViewById(R.id.btn1);
        btn1.setText("突破private");
        btn1.setOnClickListener(this);

        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
          case R.id.btn1:
               method1();
               break;
}
    }

    void method1(){
        Class c = null;//包名.类名
        try {
            c = Class.forName("com.yahier.androidtest.common.Common");
            Method m = null;//方法名 与 ...
            m = c.getDeclaredMethod("go", new Class<?>[] {});
            m.setAccessible(true);//突破修饰符限制  private
            m.invoke(c.newInstance(), new Object[] {});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }


}
