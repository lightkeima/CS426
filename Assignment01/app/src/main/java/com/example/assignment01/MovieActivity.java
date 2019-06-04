package com.example.assignment01;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    private TextView title;
    private TextView rating;
    private TextView legngth;
    private TextView synopsis;
    private ImageView filmImg;
    private TextView screen;
    private ArrayList<String> genres = new ArrayList<>();
    private ArrayList<Date> dates;
    private GenresAdapter adapter;
    private DateAdapter adapterX2;
    private RecyclerView genresRV;
    private RecyclerView datesRV;
    private DatabaseHelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        title = findViewById(R.id.am_tv_title);
        rating = findViewById(R.id.tv_rating_1);
        legngth = findViewById(R.id.tv_min_1);
        synopsis = findViewById(R.id.synopsis);
        screen = findViewById(R.id.tv_screen);
        filmImg = findViewById(R.id.movie_img);
        genresRV = findViewById(R.id.rv_genres);
        datesRV = findViewById(R.id.rv_date);
        /*try {
            URL url = new URL(intent.getStringExtra("imageurl"));
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            filmImg.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        title.setText(intent.getStringExtra("title"));
        rating.setText(String.valueOf(intent.getDoubleExtra("rating",0)));
        legngth.setText(String.valueOf(intent.getIntExtra("length",0))+" mins");
        synopsis.setText(intent.getStringExtra("synopsis"));
        screen.setText(intent.getStringExtra("screen"));
        int id = intent.getIntExtra("id",0);
        db = new DatabaseHelper(this);
        genres = db.GetGenresList(String.valueOf(id));
        adapter= new GenresAdapter(this,genres);
        genresRV.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        genresRV.setLayoutManager(layoutManager);
        dates = db.GetDateList(id);
        Log.d("bug",dates.toString()
        );

        adapterX2 = new DateAdapter(this,dates);
        datesRV.setAdapter(adapterX2);
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        datesRV.setLayoutManager(layoutManager1);
    }
}
