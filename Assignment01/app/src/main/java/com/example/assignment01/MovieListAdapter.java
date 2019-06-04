package com.example.assignment01;


import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MovieListAdapter extends ArrayAdapter<Movie> {
    private final ArrayList<Movie> data;
    private final Context context;
    private LayoutInflater mInflater;
    public MovieListAdapter(Context context, ArrayList<Movie> data){
        super(context,0,data);
        this.data = data;
        this.context = context;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = mInflater.inflate(R.layout.movielistitem,parent,false);
        TextView tv = (TextView) rowView.findViewById(R.id.tv_title);
        TextView tv2 = (TextView) rowView.findViewById(R.id.tv_rating_1);
        tv.setText(data.get(position).title);
        tv2.setText(Double.toString(data.get(position).rating));
        if(position % 2 == 1){
            LinearLayout ll = rowView.findViewById(R.id.movie_item_ll);
            ll.setBackgroundColor(Color.parseColor("#ff0080"));
        }
        return rowView;
    }
}
