package com.example.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

//import java.io.Serializable;

public class MovieItem implements Serializable {
    String Title;
    int Rating;
    String Website;

    public MovieItem(String title, int rating, String website) {
        Title=title;
        Rating= rating;
        Website=website;
    }
    public View createAndBindItemView(Context context){
        View rowView = LayoutInflater.from(context).inflate(R.layout.movie_item_layout, null);
        TextView textViewTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        textViewTitle.setText(Title);

        TextView textViewWebsite = (TextView) rowView.findViewById(R.id.textViewWebsite);
        return rowView;
    }
}

