package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class addToPlaylist extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageButton addToPlaylistBackButton;
    private Spinner spinner;
    private int currentIndex = -1;


    private SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_playlist);

        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");

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
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}