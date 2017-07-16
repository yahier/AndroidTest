package com.yahier.androidtest.databinding;

/**
 * Created by yahier on 17/5/9.
 */

public class User {
    private String text;

    public User(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
