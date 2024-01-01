package com.example.animequiz.AllActivities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animequiz.R;

public class MainActivity extends AppCompatActivity {
    private VideoView animeWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize VideoView and MediaController
        animeWelcome = findViewById(R.id.animeWelcome);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(animeWelcome);

        // Set the video URI (replace "your_video_url" with your actual video URL or local file path)
        animeWelcome.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.titlevideo);
        animeWelcome.start();

//         Set OnCompletionListener to loop the video
        animeWelcome.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                animeWelcome.seekTo(0);
                animeWelcome.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause video playback when the activity is paused
        if (animeWelcome.isPlaying()) {
            animeWelcome.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume video playback when the activity is resumed
        if (!animeWelcome.isPlaying()) {
            animeWelcome.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release resources when the activity is destroyed
        animeWelcome.stopPlayback();
    }

    public void start(View view){
            // Add your code to start the quiz or transition to another activity
            // For example, you can open a new activity using an Intent
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
    }
}