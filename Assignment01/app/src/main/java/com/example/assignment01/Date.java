package com.example.assignment01;

import java.io.Serializable;

public class Date implements Serializable {
    int day;
    String dayOfWeek;
    Date(int day, String dayOfWeek){
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }
}
