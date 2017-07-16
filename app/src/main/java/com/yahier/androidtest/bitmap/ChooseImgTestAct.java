package com.yahier.androidtest.bitmap;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.util.BitmapUtil;

/**
 * 测试不同的获取选到的图片
 * Created by yahier on 17/4/9.
 *
 *
 * 测试scaleType 测试了fitCenter，fitXY,matrix
 */

public class ChooseImgTestAct extends Activity {
    final String TAG = getClass().getSimpleName();
    final static int CAPTURE_GALLERY_ACTIVITY_REQUEST_CODE = 100;
    Button okBtn;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        okBtn = (Button) findViewById(R.id.button);
        okBtn.setText("选择图片");
        imageView = (ImageView) findViewById(R.id.img);
        imageView.setVisibility(View.VISIBLE);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
                getAlbum.setType("image/*");
                startActivityForResult(getAlbum, CAPTURE_GALLERY_ACTIVITY_REQUEST_CODE);
            }
        });

    }


    Bitmap mbitmap;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100: {
                Log.e(TAG, "one");
                mbitmap = data.getParcelableExtra("data");
                if (mbitmap != null) {
                    showBitmap(0);
                    return;
                }
                Uri uri = data.getData();
                ContentResolver resolver = getContentResolver();
                try {
                    byte[] mContext = BitmapUtil.readStream(resolver.openInputStream(Uri.parse(uri.toString())));
                    BitmapFactory.Options opts = new BitmapFactory.Options();
                    // BitmapFactory.Options opts2 = new
                    // BitmapFactory.Options();
                    opts.inJustDecodeBounds = true;
                    // opts2.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(mContext, 0, mContext.length, opts);
                    opts.inSampleSize = BitmapUtil.calculateInSampleSize(opts, 3000, 4000);
                    opts.inJustDecodeBounds = false;
                    mbitmap = BitmapUtil.getPicFromBytes(mContext, opts);
                    if (mbitmap != null) {
                        showBitmap(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            break;
            case 300:
                System.out.println("resultCode:" + resultCode);
                if (resultCode == RESULT_OK) {
                    BitmapFactory.Options opts = new BitmapFactory.Options();
                    opts.inJustDecodeBounds = true;
                    //BitmapFactory.decodeFile(FileUtils.getFile(fileName).getAbsolutePath(), opts);
                    //opts.inSampleSize = BitmapUtil.calculateInSampleSize(opts, 1800, 1200);
                    opts.inJustDecodeBounds = false;
                    //Bitmap mbitmap = BitmapFactory.decodeFile(FileUtils.getFile(fileName).getAbsolutePath(), opts);
                    //mbitmap = BitmapUtil.rotateUpright(mbitmap, FileUtils.getFile(fileName).getAbsolutePath());
                    if (mbitmap != null) {
                        Log.e("Main", mbitmap.getWidth() + ":" + mbitmap.getHeight());
                    }
                } else if (resultCode == RESULT_CANCELED) {
                    // User cancelled the image capture
                } else {
                    // Image capture failed, advise user
                }

                break;
            case 101:
                if (resultCode == RESULT_OK && null != data) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();

                    mbitmap = BitmapFactory.decodeFile(picturePath);
                    showBitmap(2);
                }
                break;

        }
    }

    void showBitmap(int invoker) {
        Log.e("showBitmap "+invoker, mbitmap.getWidth() + ":" + mbitmap.getHeight());
        imageView.setImageBitmap(mbitmap);
    }
}
