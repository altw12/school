package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToPlaylistPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageButton addToPlaylistBackButton;
    private Spinner spinner;
    private int currentIndex = -1;


    private SongCollection songCollection = new SongCollection();

    private ImageButton confirmAddToPlaylistButton;

    //initialise playlists
    static ArrayList<Song> happyList= new ArrayList<Song>();
    static ArrayList<Song> sadList= new ArrayList<Song>();
    static ArrayList<Song> epicList= new ArrayList<Song>();
    static ArrayList<Song> funnyList= new ArrayList<Song>();

    private int playlistIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_playlist);

        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");


        //add song to playlist based on playlist index
        confirmAddToPlaylistButton = findViewById(R.id.confirmAddToPlaylistButton);
        confirmAddToPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song song = songCollection.getCurrentSong(currentIndex);
                switch(playlistIndex){
                    case 0:
                        happyList.add(song);
                        break;
                    case 1:
                        sadList.add(song);
                        break;
                    case 2:
                        epicList.add(song);
                        break;
                    case 3:
                        funnyList.add(song);
                        break;
                    default:
                        break;
                }
                Log.d("playlist", "Added " + song.getTitle() + " to ");
                Log.d("playlist", "playlistIndex = " + playlistIndex);
                openPlaylistSongsFromAddToPlaylist(playlistIndex);

            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.playlists, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        addToPlaylistBackButton = (ImageButton) findViewById(R.id.addToPlaylistBackButton);
        addToPlaylistBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSongPlayerFromAddToPlaylist(currentIndex);
            }
        });
    }
    public void openSongPlayerFromAddToPlaylist(int index){
        Intent intent = new Intent(this, SongPlayer.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        selectPlaylist(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //get playlist index based on playlist selected
    public void selectPlaylist(String playlistName){
        String playlistFull[] = {"Happy Playlist", "Sad Playlist", "Epic Playlist", "Funny Playlist"};
        List<String> list = Arrays.asList(playlistFull);
        Log.d("playlist", "index = " + list.indexOf(playlistName));
        playlistIndex = list.indexOf(playlistName);
    }

    public void openPlaylistSongsFromAddToPlaylist(int ind){
        Intent intent = new Intent(this, PlaylistSongs.class);
        intent.putExtra("playlistIndex", ind);
        startActivity(intent);
    }

}