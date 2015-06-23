package com.example.android.mymusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button musicButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = mediaPlayer.create(getApplicationContext(), R.raw.maps);


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration = mp.getDuration();
                Toast.makeText(getApplicationContext(),"Duration: "+duration/1000,Toast.LENGTH_LONG).show();
            }
        });

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

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }
        super.onDestroy();
    }
}
