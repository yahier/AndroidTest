package com.yahier.androidtest.bitmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.yahier.androidtest.R;
import com.yahier.androidtest.widget.LargeImageView;

import java.io.IOException;
import java.io.InputStream;

public class LargeImageViewActivity extends AppCompatActivity
{
    private LargeImageView mLargeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image_view);

        mLargeImageView = (LargeImageView) findViewById(R.id.id_largetImageview);
        try
        {
            InputStream inputStream = getAssets().open("qm.jpg");
            mLargeImageView.setInputStream(inputStream);

        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
