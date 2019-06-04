package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class MyDataAdapter extends ArrayAdapter<MyData> {
    public MyDataAdapter(Context context, ArrayList<MyData> arrayList){
        super(context, 0, arrayList);
    }

    @Override
    public View getView(int position,View convertView,  ViewGroup parent) {
        if (convertView == null){
            if(position % 2 == 0) {
                if(getItem(position).isClicked  == false){
                    View v;
                    v = createARowFromLayout(R.layout.layout_forfun);
                    MyData data = getItem(position);
                    bindDataToRow(v, data);
                    convertView = v;
                }
                else {
                    View v;
                    v = createARowFromLayout(R.layout.another_layout);
                    MyData data = getItem(position);
                    bindDataToRowX2(v, data);
                    convertView = v;
                }
            } else {
                if(getItem(position).isClicked  == false){
                    View v;
                    v = createARowFromLayout(R.layout.another_layout);
                    MyData data = getItem(position);
                    bindDataToRowX2(v, data);
                    convertView = v;
                }
                else {
                    View v;
                    v = createARowFromLayout(R.layout.layout_forfun);
                    MyData data = getItem(position);
                    bindDataToRow(v, data);
                    convertView = v;
                }
            }
        }
        return convertView;
     //   return super.getView(position, convertView, parent);
    }

    private void bindDataToRow(View v, MyData data) {
        TextView t1 = v.findViewById(R.id.textView);
        t1.setText(data.a);
        TextView t2 = v.findViewById(R.id.textView2);
        t2.setText(data.b);
    }
    private void bindDataToRowX2(View v, MyData data) {
        TextView t1 = v.findViewById(R.id.textView3);
        t1.setText(data.a);
        TextView t2 = v.findViewById(R.id.textView4);
        t2.setText(data.b);
    }
    private View createARowFromLayout(int layout_ID) {
        return LayoutInflater.from(this.getContext()).inflate(layout_ID, null);
    }
}
