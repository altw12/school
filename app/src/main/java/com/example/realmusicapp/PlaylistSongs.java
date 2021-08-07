package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


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
    private ImageButton removeFromPlaylistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_songs);

        Bundle playlistData = this.getIntent().getExtras();
        playlistIndex = playlistData.getInt("playlistIndex");
        //Log.d("playlistSongs", "playlistSongs Index = " + playlistIndex);

        playlistSongsTitle1 = findViewById(R.id.playlistSongsTitle1);
        playlistSongsNumberOfSongs = findViewById(R.id.playlistSongsNumberOfSongs);
        removeFromPlaylistButton = findViewById(R.id.removeFromPlaylistButton);

        switch(playlistIndex){
            case 0:
                playlistSongsTitle1.setText("Happy Playlist");
                Log.d("playlistSongs", "0");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.happyList.size() + " songs");
                happyList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.happyList, playlistIndex);
                happyList.setAdapter(playlistAdaptor);
                happyList.setLayoutManager(new LinearLayoutManager(this));
                break;
            case 1:
                playlistSongsTitle1.setText("Sad Playlist");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.sadList.size() + " songs");
                Log.d("playlistSongs", "1");
                sadList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.sadList, playlistIndex);
                sadList.setAdapter(playlistAdaptor);
                sadList.setLayoutManager(new LinearLayoutManager(this));
                break;
            case 2:
                playlistSongsTitle1.setText("Epic Playlist");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.epicList.size() + " songs");
                Log.d("playlistSongs", "2");
                epicList = findViewById(R.id.recyclerView);
                playlistAdaptor = new PlaylistAdaptor(AddToPlaylistPage.epicList, playlistIndex);
                epicList.setAdapter(playlistAdaptor);
                epicList.setLayoutManager(new LinearLayoutManager(this));

                break;
            case 3:
                playlistSongsTitle1.setText("Funny Playlist");
                playlistSongsNumberOfSongs.setText(AddToPlaylistPage.funnyList.size() + " songs");
                Log.d("playlistSongs", "3");
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
                openPlaylistPageFromPlaylistSongs();
            }
        });


    }

    public void openPlaylistPageFromPlaylistSongs(){
        Intent intent = new Intent(this, PlaylistPage.class);
        startActivity(intent);
    }

}