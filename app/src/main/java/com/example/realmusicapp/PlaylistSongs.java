package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaylistSongs extends AppCompatActivity {

    private ImageButton playlistSongsBackButton;
    private int playlistIndex = -1;
    private TextView playlistSongsTitle1;
    private TextView playlistSongsNumberOfSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_songs);

        Bundle playlistData = this.getIntent().getExtras();
        playlistIndex = playlistData.getInt("playlistIndex");
        //Log.d("playlistSongs", "playlistSongs Index = " + playlistIndex);

        playlistSongsTitle1 = findViewById(R.id.playlistSongsTitle1);
        playlistSongsNumberOfSongs = findViewById(R.id.playlistSongsNumberOfSongs);

        switch(playlistIndex){
            case 0:
                playlistSongsTitle1.setText("Happy Playlist");
                playlistSongsNumberOfSongs.setText(addToPlaylist.happyList.size() + " songs");
                Log.d("playlistSongs", "0");
                break;
            case 1:
                playlistSongsTitle1.setText("Sad Playlist");
                playlistSongsNumberOfSongs.setText(addToPlaylist.sadList.size() + " songs");
                Log.d("playlistSongs", "1");
                break;
            case 2:
                playlistSongsTitle1.setText("Epic Playlist");
                playlistSongsNumberOfSongs.setText(addToPlaylist.epicList.size() + " songs");
                Log.d("playlistSongs", "2");
                break;
            case 3:
                playlistSongsTitle1.setText("Funny Playlist");
                playlistSongsNumberOfSongs.setText(addToPlaylist.funnyList.size() + " songs");
                Log.d("playlistSongs", "3");
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