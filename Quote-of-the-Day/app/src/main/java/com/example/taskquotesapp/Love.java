package com.example.taskquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Love extends AppCompatActivity {
    TextView quote;
    ImageButton refresh,favourite,copy;
    Random randInt;
    int integer;
    String passedQuote;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        refresh=(ImageButton)findViewById(R.id.refreshLoveBtn);
        quote=(TextView)findViewById(R.id.loveQuote);
        favourite=(ImageButton)findViewById(R.id.favouriteLoveBtn);
        copy=(ImageButton)findViewById(R.id.copyLoveBtn);
        generateQuote();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateQuote();
            }
        });


        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("Copied Data",quote.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Love.this, "Copied!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void generateQuote(){
        String loveQuotes[]={"You know you're in love when you can't fall asleep because reality is finally better than your dreams.\n-  Dr. Seuss",
                "A friend is someone who knows all about you and still loves you.\n- Roy T. Bennett, The Light in the Heart",
                "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.\n- Lou Holtz",
                "It is better to be hated for what you are than to be loved for what you are not.\n- Viktor E. Frankl, Man’s Search for Meaning",
                "As he read, I fell in love the way you fall asleep: slowly, and then all at once.\n- Roy T. Bennett, The Light in the Heart",
                "It is not a lack of love, but a lack of friendship that makes unhappy marriages.\n- Friedrich Nietzsche",
                "Being deeply loved by someone gives you strength, while loving someone deeply gives you courage.\n-  Lao Tzu",
                "There is never a time or place for true love. It happens accidentally, in a heartbeat, in a single flashing, throbbing moment.\n- Sarah Dessen, The Truth About Forever",
                "Love is that condition in which the happiness of another person is essential to your own.\n- Robert A. Heinlein, Stranger in a Strange Land",
                "Do what you love, love what you do, and with all your heart give yourself to it.\n-  Roy T. Bennett, The Light in the Heart"
        };



        randInt=new Random();
        integer=randInt.nextInt(10-1)+1;
        quote.setText(loveQuotes[integer]);
    }
}