package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //insertItemAtRunTime();
        insertItemAtRunTimeButItLookOmegaLUL();
    }

    private void insertItemAtRunTime() {
        ListView lv = (ListView) findViewById(R.id.listview);
        String[] string = {"penguin", "dog", "duck", "omegaLUL"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,string);
        lv.setAdapter(arrayAdapter);
    }
    private void insertItemAtRunTimeButItLookOmegaLUL(){
        final ListView lv = (ListView) findViewById(R.id.listview);
        final ArrayList<MyData> al = new ArrayList<MyData>();
        al.add(new MyData("lel","lelx2", false));
        al.add(new MyData("lel x 2", "lel x3", false));
        MyDataAdapter adapter = new MyDataAdapter(this,al);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              al.get(position).isClicked = true;
              MyDataAdapter adapter = new MyDataAdapter(context,al);
              lv.setAdapter(adapter);
            }
        });

    }
}