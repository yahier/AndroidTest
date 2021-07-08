package com.yahier.androidtest.ui.test;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.DisplayUtil;
import com.yahier.androidtest.util.PicassoUtil;
import com.yahier.androidtest.widget.MImageView;

/**
 * ，试验发现，glide加载gif非常顺滑，而Facebook的非常卡顿
 */
public class GifTestAct extends BaseActivity {
    private MImageView imgGif, imgGif2, imgGif3, imgGif4, imgGif5, img6;
    private String url1 = "https://test-o2o-storage-public.oss-cn-shenzhen.aliyuncs.com/322a0ac7-5c5b-463e-9c9d-93bd7cb46fad.gif";
    private String url2 = "https://test-o2o-storage-public.oss-cn-shenzhen.aliyuncs.com/86a5bf0f-de11-4f78-a5c5-b1c07bec3bde.gif";
    private String url3 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201508%2F23%2F20150823163723_rzH2K.thumb.700_0.gif&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620962835&t=c11070b8c35fd2d2d4d96442c894c492";
    private String url4 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fphotocdn.sohu.com%2F20150719%2Fmp23323231_1437278547473_5.gif&refer=http%3A%2F%2Fphotocdn.sohu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620963679&t=bb65880acb5bcc6f87b0f1599c4adf0e";
    private String url5 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimages%2F20180930%2F2369f497741e4f65a89ab70903599ac5.gif&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620963752&t=b92c89011d800809097a9c2708d8b187";

    private String url6 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.52z.com%2Fupload%2Fnews%2Fimage%2F20200226%2F20200226040355_72667.jpg&refer=http%3A%2F%2Fimg.52z.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620966409&t=378d9def7b49a6de4409701d56cda713";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_gif);
        imgGif = findViewById(R.id.imgGif);
        imgGif2 = findViewById(R.id.imgGif2);
        imgGif3 = findViewById(R.id.imgGif3);
        imgGif4 = findViewById(R.id.imgGif4);
        imgGif5 = findViewById(R.id.imgGif5);
        img6 = findViewById(R.id.img6);
        show();
    }

    private void show() {
        showImgByGlide(imgGif, url1);
        showImgByGlide(imgGif2, url2);
        showImgByGlide(imgGif3, url3);
        showImgByGlide(imgGif4, url4);
        showImgByGlide(imgGif5, url5);
        showImgByGlide(img6, url6);

    }

    private void showImgByFacebook(MImageView img, String imgUrl) {
        img.setImageUrl(imgUrl);
    }


    private void showImgByGlide(ImageView img, String imgUrl) {
        Point point = DisplayUtil.INSTANCE.getScreenDisplay(this);
        PicassoUtil.loadImg(this, imgUrl, point.x, DisplayUtil.INSTANCE.dip2px(this, 300), img);
    }
}
