package com.example.animequiz.AllActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.animequiz.R;

public class QuizActivity extends AppCompatActivity {

    ImageView narutoview;
    ImageView aotview;
    ImageView coteview;
    ImageView haikyuuview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        narutoview = findViewById(R.id.narutoview);
        aotview = findViewById(R.id.aotview);
        coteview = findViewById(R.id.coteview);
        haikyuuview = findViewById(R.id.haikyuuview);

        narutoview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animeImage(v);
            }
        });

        aotview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animeImage(v);
            }
        });

        coteview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animeImage(v);
            }
        });

        haikyuuview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animeImage(v);
            }
        });
    }

    public void animeImage(View view){
        if(view.getId() == R.id.narutoview){
            Intent naruto = new Intent(this, NarutoActivity.class);
            startActivity(naruto);
        } else if (view.getId() == R.id.aotview) {
            Intent aot = new Intent(this, AotActivity.class);
            startActivity(aot);
        } else if (view.getId() == R.id.coteview) {
            Intent cote = new Intent(this, CoteActivity.class);
            startActivity(cote);
        } else if (view.getId() == R.id.haikyuuview) {
            Intent haikyuu = new Intent(this, HaikyuuActivity.class);
            startActivity(haikyuu);
        }
    }
}