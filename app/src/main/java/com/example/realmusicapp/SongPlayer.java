package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class SongPlayer extends AppCompatActivity {

    private String title = "";
    private String artist = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private ImageButton playPauseButton = null;
    private SongCollection songCollection = new SongCollection();

    private ImageButton songPlayerBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_player);
        playPauseButton = findViewById(R.id.playPauseButton);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);


    }

    public void displaySongBasedOnIndex(int selectedIndex){
        Song song = songCollection.getCurrentSong(currentIndex);
        title = song.getTitle();
        artist = song.getArtist();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();
        TextView songTitle = findViewById(R.id.song_title);
        songTitle.setText(title);
        TextView songArtist = findViewById(R.id.song_artist);
        songArtist.setText(artist);
        ImageView songPicture = findViewById(R.id.song_picture);
        songPicture.setImageResource(drawable);
    }

    public void playSong(String songUrl){
        try{
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            endMusic();

            playPauseButton.setImageResource(R.drawable.ic_pausesong_icon_black_foreground);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View view){
        if(player.isPlaying()){
            player.pause();
            playPauseButton.setImageResource(R.drawable.ic_playsong_icon_black_foreground);
        }
        else{
            player.start();
            playPauseButton.setImageResource(R.drawable.ic_pausesong_icon_black_foreground);
        }
    }

    private void endMusic(){
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playPauseButton.setImageResource(R.drawable.ic_playsong_icon_black_foreground);
            }
        });
    }

    public void playNext(View view){
        currentIndex = songCollection.getNextSong(currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void playPrev(View view){
        currentIndex = songCollection.getPrevSong(currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        player.release();
    }
}