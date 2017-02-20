package com.yahier.androidtest.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/2/20.
 */

public class HtmlAllTestActivity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view);
        this.tv = (TextView) findViewById(R.id.text_view);


        //CharSequence text = tv.getText();
        String value = "百度   http://www.baidu.com/";
        tv.setText(value);
        CharSequence text = tv.getText();

        if (text instanceof Spannable) {
            int end = text.length();
            Spannable sp = (Spannable) tv.getText();
            URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
            SpannableStringBuilder style = new SpannableStringBuilder(text);
            style.clearSpans();// should clear old spans
            for (URLSpan url : urls) {
                MyURLSpan myURLSpan = new MyURLSpan(url.getURL());
                style.setSpan(myURLSpan, sp.getSpanStart(url), sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            }
            tv.setText(style);
        }

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HtmlAllTestActivity.this, "tv click", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private class MyURLSpan extends ClickableSpan {

        private String mUrl;

        MyURLSpan(String url) {
            mUrl = url;
        }

        @Override
        public void onClick(View widget) {
            Toast.makeText(HtmlAllTestActivity.this, mUrl, Toast.LENGTH_LONG).show();
            widget.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }
}
