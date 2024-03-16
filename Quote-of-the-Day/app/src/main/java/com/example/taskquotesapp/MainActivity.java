package com.example.taskquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Intent motivation,love,happy,emotional,favourite;
    ImageButton motivationBtn,loveBtn,happyBtn,emotionalBtn,favouriteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        motivationBtn=(ImageButton)findViewById(R.id.motivation);
        loveBtn=(ImageButton)findViewById(R.id.love);
        happyBtn=(ImageButton)findViewById(R.id.happy);
        emotionalBtn=(ImageButton)findViewById(R.id.emotional);
        favouriteBtn=(ImageButton)findViewById(R.id.favourite);


        motivationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motivation=new Intent(getApplicationContext(),Motivation.class);
                startActivity(motivation);
            }
        });

        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happy=new Intent(getApplicationContext(),Happy.class);
                startActivity(happy);
            }
        });



        loveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                love=new Intent(getApplicationContext(),Love.class);
                startActivity(love);
            }
        });

        emotionalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emotional=new Intent(getApplicationContext(),Emotional.class);
                startActivity(emotional);
            }
        });

        favouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favourite=new Intent(getApplicationContext(),Favourite.class);
                startActivity(favourite);
            }
        });


    }
}