package com.kmn.coursera;

import java.io.Serializable;

public class Data implements Serializable {
    private String mText;

    public Data(String mText) {
        this.mText = mText;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }
}
