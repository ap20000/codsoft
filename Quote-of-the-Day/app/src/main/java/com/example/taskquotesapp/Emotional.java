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

public class Emotional extends AppCompatActivity {
    TextView quote;
    ImageButton refresh,favourite,copy;
    Random randInt;
    int integer;
    String passedQuote;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotional);

        refresh=(ImageButton)findViewById(R.id.refreshEmotionalBtn);
        quote=(TextView)findViewById(R.id.emotionalQuote);
        favourite=(ImageButton)findViewById(R.id.favouriteEmotionalBtn);
        copy=(ImageButton)findViewById(R.id.copyEmotionalBtn);
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

                Toast.makeText(Emotional.this, "Copied!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void generateQuote(){

        String emotionalQuotes[]={"The best and most beautiful things in the world cannot be seen or even touched. They must be felt with the heart.\n- Helen Keller",
                "I don't want to be at the mercy of my emotions. I want to use them, to enjoy them, and to dominate them.\n- Oscar Wilde, The Picture of Dorian Gray",
                "One thing you can't hide - is when you're crippled inside.\n- John Lennon",
                "The emotion that can break your heart is sometimes the very one that heals it...\n- Nicholas Sparks, At First Sight",
                "Your emotions are the slaves to your thoughts, and you are the slave to your emotions.\n- Elizabeth Gilbert, Eat Pray Love: One Woman's Search for Everything Across Italy, India and Indonesia",
                "The world is a tragedy to those who feel, but a comedy to those who think.\n- Horace Walpole",
                "I envy people that know love. That have someone who takes them as they are.\n-  Jess C Scott, The Devilin Fey",
                "I knew they would kill me when they found out, but…” He struggled for words, releasing a sharp breath. “I think I realized that I would rather die because I betrayed them, than live because I betrayed you.\n- Marissa Meyer, Scarlet",
                "Life is a comedy to those who think, a tragedy to those who feel.\n- Jean Racine",
                "One ought to hold on to one's heart; for if one lets it go, one soon loses control of the head too.\n- Toni Morrison"
        };



        randInt=new Random();
        integer=randInt.nextInt(10-1)+1;
        quote.setText(emotionalQuotes[integer]);

    }
}