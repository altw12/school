package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PlaylistSongs extends AppCompatActivity {

    private ImageButton playlistSongsBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_songs);

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