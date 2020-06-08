package com.yahier.androidtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.yahier.androidtest.R;
import com.yahier.androidtest.vo.ChartData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ChartView extends View {
    List<ChartData> listData;
    Paint paintBlack;
    Paint paintText;
    Paint paint1, paint2, paint3;

    public ChartView(Context context) {
        super(context);
        init();
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint1 = new Paint();
        paint1.setColor(getResources().getColor(R.color.gray));

        paint2 = new Paint();
        paint2.setColor(getResources().getColor(R.color.red));

        paint3 = new Paint();
        paint3.setColor(getResources().getColor(R.color.green));

        paintBlack = new Paint();
        paintBlack.setColor(getResources().getColor(R.color.black));

        paintText = new Paint();
        paintText.setColor(getResources().getColor(R.color.black));
        paintText.setTextSize(20);

        initData();
    }

    private void initData() {
        listData = new ArrayList<>();
        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-21", 149));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-21", 3));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-21", 0));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-22", 131));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-22", 8));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-22", 0));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-23", 259));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-23", 8));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-23", 6));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-24", 444));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-24", 16));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-24", 3));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-25", 688));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-25", 15));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-25", 11));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-26", 769));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-26", 24));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-26", 2));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-27", 1771));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-27", 26));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-27", 9));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-28", 1771));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-28", 26));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-28", 9));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-29", 1771));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-29", 26));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-29", 9));

        listData.add(new ChartData(ChartData.Companion.getTypeInfected(), "1-30", 1771));
        listData.add(new ChartData(ChartData.Companion.getTypeDied(), "1-30", 26));
        listData.add(new ChartData(ChartData.Companion.getTypeSecured(), "1-30", 9));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        width = width == 0 ? 800 : width;
        height = height == 0 ? 800 : height;

        //设置X轴和Y轴 设置高度600  交叉点是 (40,40)

        final int marginPageLeft = 100;
        final int marginPageBottom = 100;
        canvas.drawLine(marginPageLeft, height - marginPageBottom, marginPageLeft + width, height - marginPageBottom, paintBlack);//X线
        canvas.drawLine(marginPageLeft, height - marginPageBottom, marginPageLeft, marginPageBottom, paintBlack);//Y线
        //建立Y轴的刻度 10个刻度.刻度值是50
        final int rateHeight = 100;
        final float scale = 200;
        for (int i = 0; i < 11; i++) {
            int y = (height - marginPageBottom) - rateHeight * i;
            canvas.drawText(String.valueOf((int) (i * scale)), 30, y, paintText);
            canvas.drawLine(60, y, marginPageLeft, y, paintBlack);
        }


        List<ChartData> list1 = listData.stream().filter(item -> item.getType() == 1).collect(Collectors.toList());
        List<ChartData> list2 = listData.stream().filter(item -> item.getType() == 2).collect(Collectors.toList());
        List<ChartData> list3 = listData.stream().filter(item -> item.getType() == 3).collect(Collectors.toList());
        final int itemMargin = 60;
        final int itemWidth = 10;

        for (int i = 0; i < list1.size(); i++) {
            ChartData data = list1.get(i);
            int x = marginPageLeft + (itemMargin + itemWidth) * i + 20;
            //日期
            canvas.drawText(data.getDate(), x, height - 60, paintText);

        }

        for (int i = 0; i < list1.size(); i++) {
            {
                ChartData data = list1.get(i);
                int x = marginPageLeft + (itemMargin + itemWidth) * i + 20;
                float y = (height - marginPageBottom) - data.getValue() * (rateHeight / scale);
                //画线柱
                canvas.drawRect(x, y, x + itemWidth, height - marginPageBottom, paint1);
            }

            {
                ChartData data = list2.get(i);
                int x = marginPageLeft + (itemMargin + itemWidth) * i + 30;
                float y = (height - marginPageBottom) - data.getValue() * (rateHeight / scale);
                //画线柱
                canvas.drawRect(x, y, x + itemWidth, height - marginPageBottom, paint2);
            }

            {
                ChartData data = list3.get(i);
                int x = marginPageLeft + (itemMargin + itemWidth) * i + 40;
                float y = (height - marginPageBottom) - data.getValue() * (rateHeight / scale);
                //画线柱
                canvas.drawRect(x, y, x + itemWidth, height - marginPageBottom, paint3);
            }

        }


    }
}
