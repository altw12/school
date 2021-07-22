package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PlaylistPage extends AppCompatActivity {

    private ImageButton playlistBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_page);

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
}