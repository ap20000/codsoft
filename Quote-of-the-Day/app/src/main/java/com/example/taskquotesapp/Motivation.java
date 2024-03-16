package com.example.taskquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Motivation extends AppCompatActivity {
    TextView quote;
    ImageButton refresh,favourite,copy;
    Random randInt;
    int integer;
    String passedQuote;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        refresh=(ImageButton)findViewById(R.id.refreshMotivationBtn);
        quote=(TextView)findViewById(R.id.motivationQuote);
        favourite=(ImageButton)findViewById(R.id.favouriteMotivationButton);
        copy=(ImageButton)findViewById(R.id.copyMotivationBtn);
        generateQuote();


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                generateQuote();

            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                favArray.add(quote.getText().toString());
//                adapter.notifyDataSetChanged();
                passedQuote=quote.getText().toString();
                intent=new Intent(Motivation.this,Favourite.class);
                intent.putExtra("Motivation",passedQuote);
                startActivity(intent);

            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("Copied Data",quote.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Motivation.this, "Copied!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void generateQuote(){
        String motivationalQuotes[]={"Attitude is a choice. Happiness is a choice. Optimism is a choice. Kindness is a choice. Giving is a choice. Respect is a choice. Whatever choice you make makes you. Choose wisely.\n- Roy T. Bennett, The Light in the Heart",
                "Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.\n- Roy T. Bennett, The Light in the Heart",
                "It's not the load that breaks you down, it's the way you carry it.\n- Lou Holtz",
                "When we are no longer able to change a situation, we are challenged to change ourselves.\n- Viktor E. Frankl, Man’s Search for Meaning",
                "Never lose hope. Storms make people stronger and never last forever.\n- Roy T. Bennett, The Light in the Heart",
                "Do you want to know who you are? Don't ask. Act! Action will delineate and define you.\n- Thomas Jefferson",
                "Nothing in the world is ever completely wrong. Even a stopped clock is right twice a day.\n-  Paulo Coelho, Brida",
                "The way to get started is to quit talking and begin doing.\n- Walt Disney",
                "The only thing standing between you and your goal is the bullshit story you keep telling yourself as to why you can't achieve it.\n- Jordan Belfort",
                "Do what you love, love what you do, and with all your heart give yourself to it.\n-  Roy T. Bennett, The Light in the Heart"
        };



        randInt=new Random();
        integer=randInt.nextInt(10-1)+1;
        quote.setText(motivationalQuotes[integer]);
    }
}