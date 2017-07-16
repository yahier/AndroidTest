package com.yahier.androidtest.metarial;

/**
 * Created by yahier on 17/4/17.
 */

public class MainItem {
    String title;
    String des;
    Class mAct;

    public MainItem(String title, Class mact) {
        this.title = title;
        this.mAct = mact;
    }

    public MainItem(String title, String des, Class mact) {
        this.title = title;
        this.des = des;
        this.mAct = mact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Class getmAct() {
        return mAct;
    }

    public void setmAct(Class mAct) {
        this.mAct = mAct;
    }
}
