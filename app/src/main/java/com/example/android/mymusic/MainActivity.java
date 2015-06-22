package com.example.android.mymusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button musicButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.create(getApplicationContext(), R.raw.game_field);
        musicButton = (Button)findViewById(R.id.playMusic);
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    pauseMusic();
                }
                else {
                    startMusic();
                }

            }
        });

    }

  public void pauseMusic(){
      if (mediaPlayer !=null){
          mediaPlayer.pause();
          musicButton.setText("Start");
      }
  }
    public void startMusic(){
        if (mediaPlayer != null){
            mediaPlayer.start();
            musicButton.setText("Pause");
        }
    }
}
