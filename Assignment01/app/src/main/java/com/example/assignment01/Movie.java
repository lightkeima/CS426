package com.example.assignment01;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    int id;
    String title;
    String synopsis;
    String imageURL;
    String screen;
    ArrayList<String> genres;
    double rating;
    int length; //mins
    Movie(int id, String title, String synopsis, int length, double rating, String imageURL, ArrayList<String> genres, String screen){
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.genres = genres;
        this.length = length;
        this.imageURL = imageURL;
        this.rating = rating;
        this.screen = screen;
    };
}
