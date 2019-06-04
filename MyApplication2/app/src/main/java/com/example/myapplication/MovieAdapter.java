package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<MovieItem> {
    private final Context context;
    public MovieAdapter(Context context, ArrayList<MovieItem> arrayList){
        super(context, 0, arrayList);
        this.context = context;
    }

    //@androidx.annotation.NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        if(convertView == null){
            MovieItem item = getItem(position);

        }
        return super.getView(position, convertView, parent);
    }
}
