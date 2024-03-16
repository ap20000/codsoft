package com.example.taskquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Favourite extends AppCompatActivity {
    ArrayList <String> favArray;
    ArrayAdapter <String> adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        listview=(ListView)findViewById(R.id.listViewQuotes);
        String motivate=getIntent().getStringExtra("Motivation");
//        String happy=getIntent().getStringExtra("Happy");
//        String love=getIntent().getStringExtra("Love");
//        String emotional=getIntent().getStringExtra("Emotional");

        favArray=new ArrayList<>();
        adapter=new ArrayAdapter <String> (getApplicationContext(), android.R.layout.simple_list_item_1,favArray);
        favArray.add(motivate);
//        favArray.add(happy);
//        favArray.add(love);
//       favArray.add(emotional);
        adapter.notifyDataSetChanged();

        listview.setAdapter(adapter);
    }
}