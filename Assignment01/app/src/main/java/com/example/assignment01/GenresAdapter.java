package com.example.assignment01;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenresViewHolder> {
    private  final ArrayList<String> data;
    //private final Context context;
    private LayoutInflater mInflater;
    public GenresAdapter(Context context,
                           ArrayList<String> data) {
        mInflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public GenresViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.genreslistitem,viewGroup,false);
        return new GenresViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(GenresViewHolder genresViewHolder, int i) {
        genresViewHolder.tv.setText(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class GenresViewHolder extends RecyclerView.ViewHolder {
        public final TextView tv;
        final GenresAdapter adapter;
        public GenresViewHolder(View itemView, GenresAdapter adapter) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_item_genre);
            this.adapter = adapter;
        }
    }
}
