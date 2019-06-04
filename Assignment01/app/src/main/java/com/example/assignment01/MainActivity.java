package com.example.assignment01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> infor = new ArrayList<>();
    private ListView mRecyclerView;
    private MovieListAdapter mAdapter;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Movie List");
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        infor = db.GetMovieInformationList();
        mRecyclerView = findViewById(R.id.lv_movie);
        mAdapter = new MovieListAdapter(this, infor);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view.setClickable(false);
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra("title",infor.get(position).title);
                intent.putExtra("rating",infor.get(position).rating);
                intent.putExtra("synopsis",infor.get(position).synopsis);
                intent.putExtra("id",infor.get(position).id);
                intent.putExtra("length",infor.get(position).length);
                intent.putExtra("imageurl",infor.get(position).imageURL);
                intent.putExtra("screen",infor.get(position).screen);
                startActivity(intent);
            }
        });
    }
}
