package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;


public class PlaylistSongs extends AppCompatActivity {

    RecyclerView happyList;
    RecyclerView sadList;
    RecyclerView epicList;
    RecyclerView funnyList;
    PlaylistAdaptor playlistAdaptor;

    private ImageButton playlistSongsBackButton;
    private int playlistIndex = -1;
    private TextView playlistSongsTitle1;
    private TextView playlistSongsNumberOfSongs;
    private TextView playlistPlayerSongTitle;
    private ImageButton playlistPlayerPlayPauseButton;
    private ImageButton removeFromPlaylistButton;
    private String playlistSongFileLink;

    MediaPlayer playlistPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_songs);


        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "dataToPlayer".
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("dataToPlayer"));


        Bundle playlistData = this.getIntent().getExtras();
        playlistIndex = playlistData.getInt("playlistIndex");

        playlistSongsTitle1 = findViewById(R.id.playlistSongsTitle1);
        playlistSongsNumberOfSongs = findViewById(R.id.playlistSongsNumberOfSongs);
        removeFromPlaylistButton = findViewById(R.id.removeFromPlaylistButton);
        playlistPlayerSongTitle = findViewById(R.id.playlistPlayerSongTitle);

        playlistPlayerPlayPauseButton = (ImageButton) findViewById(R.id.playlistPlayerPlayPauseButton);
        playlistPlayerPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playOrPauseMusic();
            }
        });

        switch(playlistIndex){
            case 0:
                playlistSongsTitle1.setText("Happy Playlist");
                //Log.d("playlistSongs", "0");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.happyList.size() + " songs");
                happyList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.happyList, playlistIndex);
                happyList.setAdapter(playlistAdaptor);
                happyList.setLayoutManager(new LinearLayoutManager(this));
                break;
            case 1:
                playlistSongsTitle1.setText("Sad Playlist");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.sadList.size() + " songs");
                //Log.d("playlistSongs", "1");
                sadList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.sadList, playlistIndex);
                sadList.setAdapter(playlistAdaptor);
                sadList.setLayoutManager(new LinearLayoutManager(this));
                break;
            case 2:
                playlistSongsTitle1.setText("Epic Playlist");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.epicList.size() + " songs");
                //Log.d("playlistSongs", "2");
                epicList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.epicList, playlistIndex);
                epicList.setAdapter(playlistAdaptor);
                epicList.setLayoutManager(new LinearLayoutManager(this));

                break;
            case 3:
                playlistSongsTitle1.setText("Funny Playlist");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.funnyList.size() + " songs");
                //Log.d("playlistSongs", "3");
                funnyList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.funnyList, playlistIndex);
                funnyList.setAdapter(playlistAdaptor);
                funnyList.setLayoutManager(new LinearLayoutManager(this));
                break;
            default:
                break;
        }
        playlistSongsBackButton = (ImageButton) findViewById(R.id.playlistSongsBackButton);
        playlistSongsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forceEndMusic();
                openPlaylistPageFromPlaylistSongs();
            }
        });


    }

    public void openPlaylistPageFromPlaylistSongs(){
        Intent intent = new Intent(this, PlaylistPage.class);
        startActivity(intent);
    }


    // when data is sent to mini player, song plays
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            playlistPlayerSongTitle.setText(intent.getStringExtra("playlistSongTitle"));
            playlistSongFileLink  = intent.getStringExtra("playlistSongFileLink");
            playSong(playlistSongFileLink);
        }
    };

    public void playOrPauseMusic(){

        if(!playlistPlayer.isPlaying()){
            playlistPlayer.start();
            playlistPlayerPlayPauseButton.setImageResource(R.drawable.ic_pause_icon_white_foreground);
            Log.d("bruh", "resume");
        }
        else{
            playlistPlayer.pause();
            playlistPlayerPlayPauseButton.setImageResource(R.drawable.ic_play_icon_white_foreground);
            Log.d("bruh", "pause");
        }

    }
    // does not work
    public void playSong(String songUrl){
        try{
            if(playlistPlayer.isPlaying())
            {
                playlistPlayer.stop();
            }
            playlistPlayer.reset();
            playlistPlayer.setDataSource(songUrl);
            playlistPlayer.prepare();
            playlistPlayer.start();
            atMusicEnd();
            playlistPlayerPlayPauseButton.setImageResource(R.drawable.ic_pause_icon_white_foreground);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void atMusicEnd(){
        playlistPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playlistPlayerPlayPauseButton.setImageResource(R.drawable.ic_play_icon_white_foreground);
            }
        });
    }
    // THIS DONESTNT WORKKKKKKKK
    public void forceEndMusic(){
        playlistPlayer.stop();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        playlistPlayer.stop();
    }


    // THIS DONESTNT WORKKKKKKKK THE PLAYERS ARE NOT RELEASING
    @Override
    public void onDestroy(){
        super.onDestroy();
        playlistPlayer.stop();
        playlistPlayer.release();
        playlistPlayer = null;
    }

}