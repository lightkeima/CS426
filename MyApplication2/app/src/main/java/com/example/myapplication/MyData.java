package com.example.myapplication;

import java.io.Serializable;

class MyData implements Serializable {
    String a;
    String b;
    boolean isClicked;
    public MyData(String s, String s1, boolean isClicked) {
        a = s;
        b = s1;
        this.isClicked = isClicked;
    }
}
