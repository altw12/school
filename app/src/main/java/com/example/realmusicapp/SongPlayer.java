package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SongPlayer extends AppCompatActivity {

    private String title = "";
    private String artist = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;

    private TextView songTimerCurrent;
    private TextView songTimerEnd;

    private MediaPlayer player = new MediaPlayer();
    private ImageButton playPauseButton;
    private ImageButton nextSongButton;
    private ImageButton prevSongButton;
    private SeekBar seekBar;
    private Handler handler1 = new Handler();
    SongCollection songCollection = new SongCollection();
    SongCollection originalSongCollection = new SongCollection();


    List<Song> shuffleList = Arrays.asList(songCollection.songs);

    private ImageButton repeatSongButton;
    private ImageButton shuffleSongButton;
    Boolean repeatFlag = false;
    Boolean shuffleFlag = false;
    private ImageButton addToPlaylistButton;

    private ImageButton songPlayerBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_player);

        songTimerCurrent = (TextView) findViewById(R.id.songTimerCurrent);
        songTimerEnd = (TextView) findViewById(R.id.songTimerEnd);

        seekBar = findViewById(R.id.songSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                stopRunnable();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(player!=null && player.isPlaying()){
                    player.seekTo(seekBar.getProgress());
                }
                startRunnable();
            }
        });

        playPauseButton = (ImageButton) findViewById(R.id.playPauseButton);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playOrPauseMusic();
            }
        });

        nextSongButton = (ImageButton) findViewById(R.id.nextSongButton);
        nextSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNext();
            }
        });

        prevSongButton = (ImageButton) findViewById(R.id.prevSongButton);
        prevSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPrev();
            }
        });

        addToPlaylistButton = (ImageButton) findViewById(R.id.addToPlaylistButton);
        addToPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forceEndMusic();
                openAddToPlaylistFromSongPlayer();
            }
        });

        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);

        songPlayerBackButton = (ImageButton) findViewById(R.id.songPlayerBackButton);
        songPlayerBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forceEndMusic();
                openSearchFromSongPlayer();
            }
        });

        repeatSongButton = (ImageButton) findViewById(R.id.repeatSongButton);
        repeatSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatSong();
            }
        });

        shuffleSongButton = (ImageButton) findViewById(R.id.shuffleSongButton);
        shuffleSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffleSongs();
            }
        });

        startRunnable();
    }

    public void startRunnable(){
        p_bar.run();
    }

    public void stopRunnable(){
        handler1.removeCallbacks(p_bar);
    }


    private Runnable p_bar = new Runnable() {
        @Override
        public void run(){
            seekBar.setProgress(player.getCurrentPosition());
            songTimerCurrent.setText(createTimerLabel(player.getCurrentPosition()));
            handler1.postDelayed(this,10);
        }
    };

    public void openSearchFromSongPlayer(){
        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
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
            seekBar.setMax(player.getDuration());
            songTimerEnd.setText(createTimerLabel(player.getDuration()));
            endMusic();
            playPauseButton.setImageResource(R.drawable.ic_pausesong_icon_black_foreground);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(){
        if(!player.isPlaying()){
            player.start();
            playPauseButton.setImageResource(R.drawable.ic_pausesong_icon_black_foreground);
        }
        else{
            player.pause();
            playPauseButton.setImageResource(R.drawable.ic_playsong_icon_black_foreground);

        }
    }

    private void endMusic(){
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(repeatFlag == true){
                    playOrPauseMusic();
                }
                else{
                    playPauseButton.setImageResource(R.drawable.ic_playsong_icon_black_foreground);
                }
            }
        });
    }

    public void forceEndMusic(){
        player.release();
        stopRunnable();
    }

    public void playNext(){
        currentIndex = songCollection.getNextSong(currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void playPrev(){
        currentIndex = songCollection.getPrevSong(currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        player.release();
        stopRunnable();
    }

    public void sendDataToAddToPlaylistFromSongPlayer(int index){
        Intent intent = new Intent(this, addToPlaylist.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }
    public void openAddToPlaylistFromSongPlayer(){
        sendDataToAddToPlaylistFromSongPlayer(currentIndex);
    }

    public String createTimerLabel(int duration){
        String timerLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        timerLabel += min + ":";

        if (sec < 10) {
            timerLabel += "0";
        }
        timerLabel += sec;

        return timerLabel;
    }

    public void repeatSong(){
        if (repeatFlag == true) {
            repeatSongButton.setImageResource(R.drawable.ic_repeat_icon_black_foreground);
        }
        else{
            repeatSongButton.setImageResource(R.drawable.ic_repeat_pressed_icon_black_foreground);
        }
        repeatFlag = !repeatFlag;
    }

    public void shuffleSongs(){
        if (shuffleFlag == true) {
            shuffleSongButton.setImageResource(R.drawable.ic_shuffle_icon_black_foreground);
        }
        else{
            shuffleSongButton.setImageResource(R.drawable.ic_shuffle_pressed_icon_black_foreground);
            Collections.shuffle(shuffleList);
            Log.d("selection", "Songs: \n" + shuffleList);
        }
        shuffleFlag = !shuffleFlag;
    }
}