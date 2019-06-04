package com.example.assignment01;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder>{
    private final ArrayList<Date> data;
    Context context;
    private LayoutInflater mInflater;
    LinearLayout temp;
    int selection;
    public DateAdapter(Context context, ArrayList<Date> data){
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }
    public DateAdapter.DateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.datelayout,viewGroup,false);
        selection = 0;
        return new DateViewHolder(view,this);
    }
    public DateAdapter.DateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i, int selection) {
        View view = mInflater.inflate(R.layout.datelayout,viewGroup,false);
        this.selection = selection;
        return new DateViewHolder(view,this);
    }
    @Override
    public void onBindViewHolder(final DateAdapter.DateViewHolder dateViewHolder, int i) {
        dateViewHolder.id = i;
        dateViewHolder.tv_day.setText(String.valueOf(data.get(i).day));
        dateViewHolder.tv_dayofweek.setText(data.get(i).dayOfWeek);
        if(i == selection){
            temp = dateViewHolder.linearLayout;
            dateViewHolder.linearLayout.setAlpha(1);
        }
        else{
            dateViewHolder.linearLayout.setAlpha((float)0.5);
        }
        dateViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection = dateViewHolder.id;
                temp.setAlpha((float)0.5);
                v.setAlpha(1);
                temp = (LinearLayout) v;
            }
        });
    }
    int getSelection(){
        return selection;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }


    public class DateViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_day;
        private final TextView tv_dayofweek;
        private final LinearLayout linearLayout;
        private  DateAdapter dateAdapter;
        private int id;
        public DateViewHolder(View itemView, DateAdapter dateAdapter) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_date);
            tv_day = itemView.findViewById(R.id.tv_day);
            tv_dayofweek = itemView.findViewById(R.id.tv_dayofweek);
            this.dateAdapter = dateAdapter;
        }
    }
}
