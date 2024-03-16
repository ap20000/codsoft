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

public class Happy extends AppCompatActivity {
    TextView quote;
    ImageButton refresh,favourite,copy;
    Random randInt;
    int integer;
    String passedQuote;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);
        refresh=(ImageButton)findViewById(R.id.refreshHappyBtn);
        quote=(TextView)findViewById(R.id.quoteHappy);
        favourite=(ImageButton)findViewById(R.id.favouriteHappyBtn);
        copy=(ImageButton)findViewById(R.id.copyHappyBtn);


        generateQuoteHappy();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateQuoteHappy();
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("Copied Data",quote.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Happy.this, "Copied!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void generateQuoteHappy(){
        String happyQuotes[]={"Happiness is largely a choice, not a right or entitlement.\n- David C. Hill",
                "Happiness is not something ready made. It comes from your own actions.\n- Dalai Lama",
                "Happiness is a direction, not a place.\n- Sydney J. Harris",
                "Happiness is not the absence of problems, it’s the ability to deal with them.\n- Steve Maraboli",
                "A great obstacle to happiness is to expect too much happiness.\n- Bernard de Fontenelle",
                "The secret of happiness is freedom, the secret of freedom is courage.\n- Carrie Jones",
                "Happiness is a function of accepting what is.\n-  Werner Erhard",
                "It is not how much we have, but how much we enjoy, that makes happiness.\n- Charles Spurgeon",
                "Happiness lies in the joy of achievement and the thrill of creative effort.\n- Franklin D. Roosevelt",
                "Do what you love, love what you do, and with all your heart give yourself to it.\n-  Roy T. Bennett, The Light in the Heart"
        };



        randInt=new Random();
        integer=randInt.nextInt(10-1)+1;
        quote.setText(happyQuotes[integer]);
    }
}