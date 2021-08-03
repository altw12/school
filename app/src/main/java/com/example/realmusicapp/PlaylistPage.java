package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PlaylistPage extends AppCompatActivity {

    private ImageButton playlistBackButton;
    private ImageButton playlist1;
    private ImageButton playlist2;
    private ImageButton playlist3;
    private ImageButton playlist4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_page);

        playlist1 = (ImageButton) findViewById(R.id.playlist1);
        playlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaylistSongsFromPlaylistPage();
            }
        });

        playlist2 = (ImageButton) findViewById(R.id.playlist2);
        playlist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaylistSongsFromPlaylistPage();
            }
        });

        playlist3 = (ImageButton) findViewById(R.id.playlist3);
        playlist3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaylistSongsFromPlaylistPage();
            }
        });

        playlist4 = (ImageButton) findViewById(R.id.playlist4);
        playlist4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaylistSongsFromPlaylistPage();
            }
        });

        playlistBackButton = (ImageButton) findViewById(R.id.playlistBackButton);
        playlistBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageFromPlaylist();
            }
        });
    }
    public void openHomePageFromPlaylist(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void openPlaylistSongsFromPlaylistPage(){
        Intent intent = new Intent(this, PlaylistSongs.class);
        startActivity(intent);
    }
}