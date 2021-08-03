package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SearchPage extends AppCompatActivity implements View.OnClickListener {

    private ImageButton searchBackButton;
    private ImageButton searchButton1;
    private ImageButton searchButton2;
    private ImageButton searchButton3;
    private ImageButton searchButton4;
    private ImageButton searchButton5;
    private ImageButton searchButton6;
    private ImageButton searchButton7;
    private ImageButton searchButton8;
    private ImageButton searchButton9;
    private ImageButton searchButton10;

    private TextView searchSongTitle1;
    private TextView searchSongTitle2;
    private TextView searchSongTitle3;
    private TextView searchSongTitle4;
    private TextView searchSongTitle5;
    private TextView searchSongTitle6;
    private TextView searchSongTitle7;
    private TextView searchSongTitle8;
    private TextView searchSongTitle9;

    private TextView searchSongArtist1;
    private TextView searchSongArtist2;
    private TextView searchSongArtist3;
    private TextView searchSongArtist4;
    private TextView searchSongArtist5;
    private TextView searchSongArtist6;
    private TextView searchSongArtist7;
    private TextView searchSongArtist8;
    private TextView searchSongArtist9;

    private TextView searchSongPlatform1;
    private TextView searchSongPlatform2;
    private TextView searchSongPlatform3;
    private TextView searchSongPlatform4;
    private TextView searchSongPlatform5;
    private TextView searchSongPlatform6;
    private TextView searchSongPlatform7;
    private TextView searchSongPlatform8;
    private TextView searchSongPlatform9;

    SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        searchBackButton = (ImageButton) findViewById(R.id.searchBackButton);
        searchBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageFromSearch();
            }
        });

        searchButton1 = findViewById(R.id.searchSongButton1);
        searchButton2 = findViewById(R.id.searchSongButton2);
        searchButton3 = findViewById(R.id.searchSongButton3);
        searchButton4 = findViewById(R.id.searchSongButton4);
        searchButton5 = findViewById(R.id.searchSongButton5);
        searchButton6 = findViewById(R.id.searchSongButton6);
        searchButton7 = findViewById(R.id.searchSongButton7);
        searchButton8 = findViewById(R.id.searchSongButton8);
        searchButton9 = findViewById(R.id.searchSongButton9);
        searchButton10 = findViewById(R.id.searchSongButton10);

        searchSongTitle1 = findViewById(R.id.searchSongTitle1);
        searchSongTitle2 = findViewById(R.id.searchSongTitle2);
        searchSongTitle3 = findViewById(R.id.searchSongTitle3);
        searchSongTitle4 = findViewById(R.id.searchSongTitle4);
        searchSongTitle5 = findViewById(R.id.searchSongTitle5);
        searchSongTitle6 = findViewById(R.id.searchSongTitle6);
        searchSongTitle7 = findViewById(R.id.searchSongTitle7);
        searchSongTitle8 = findViewById(R.id.searchSongTitle8);
        searchSongTitle9 = findViewById(R.id.searchSongTitle9);

        searchSongArtist1 = findViewById(R.id.searchSongArtist1);
        searchSongArtist2 = findViewById(R.id.searchSongArtist2);
        searchSongArtist3 = findViewById(R.id.searchSongArtist3);
        searchSongArtist4 = findViewById(R.id.searchSongArtist4);
        searchSongArtist5 = findViewById(R.id.searchSongArtist5);
        searchSongArtist6 = findViewById(R.id.searchSongArtist6);
        searchSongArtist7 = findViewById(R.id.searchSongArtist7);
        searchSongArtist8 = findViewById(R.id.searchSongArtist8);
        searchSongArtist9 = findViewById(R.id.searchSongArtist9);

        searchButton1.setOnClickListener(this);
        searchButton2.setOnClickListener(this);
        searchButton3.setOnClickListener(this);
        searchButton4.setOnClickListener(this);
        searchButton5.setOnClickListener(this);
        searchButton6.setOnClickListener(this);
        searchButton7.setOnClickListener(this);
        searchButton8.setOnClickListener(this);
        searchButton9.setOnClickListener(this);
        searchButton10.setOnClickListener(this);

        initSearchPage();
    }

    public void initSearchPage() {
        Song song1 = songCollection.getCurrentSong(0);
        searchSongTitle1.setText(song1.getTitle());
        searchSongArtist1.setText(song1.getArtist());
        searchButton1.setImageResource(song1.getDrawable());
        Song song2 = songCollection.getCurrentSong(1);
        searchSongTitle2.setText(song2.getTitle());
        searchSongArtist2.setText(song2.getArtist());
        searchButton2.setImageResource(song2.getDrawable());
        Song song3 = songCollection.getCurrentSong(2);
        searchSongTitle3.setText(song3.getTitle());
        searchSongArtist3.setText(song3.getArtist());
        searchButton3.setImageResource(song3.getDrawable());
        Song song4 = songCollection.getCurrentSong(3);
        searchSongTitle4.setText(song4.getTitle());
        searchSongArtist4.setText(song4.getArtist());
        searchButton4.setImageResource(song4.getDrawable());
        Song song5 = songCollection.getCurrentSong(4);
        searchSongTitle5.setText(song5.getTitle());
        searchSongArtist5.setText(song5.getArtist());
        searchButton5.setImageResource(song5.getDrawable());
        Song song6 = songCollection.getCurrentSong(5);
        searchSongTitle6.setText(song6.getTitle());
        searchSongArtist6.setText(song6.getArtist());
        searchButton6.setImageResource(song6.getDrawable());
        Song song7 = songCollection.getCurrentSong(6);
        searchSongTitle7.setText(song7.getTitle());
        searchSongArtist7.setText(song7.getArtist());
        searchButton7.setImageResource(song7.getDrawable());
        Song song8 = songCollection.getCurrentSong(7);
        searchSongTitle8.setText(song8.getTitle());
        searchSongArtist8.setText(song8.getArtist());
        searchButton8.setImageResource(song8.getDrawable());
        Song song9 = songCollection.getCurrentSong(8);
        searchSongTitle9.setText(song9.getTitle());
        searchSongArtist9.setText(song9.getArtist());
        searchButton9.setImageResource(song9.getDrawable());
    }

    public void openHomePageFromSearch(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.searchSongButton1:
                //Toast.makeText(this,"Song 1 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton1);
                break;
            case R.id.searchSongButton2:
                //Toast.makeText(this,"Song 2 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton2);
                break;
            case R.id.searchSongButton3:
                //Toast.makeText(this,"Song 3 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton3);
                break;
            case R.id.searchSongButton4:
                //Toast.makeText(this,"Song 4 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton4);
                break;
            case R.id.searchSongButton5:
                //Toast.makeText(this,"Song 5 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton5);
                break;
            case R.id.searchSongButton6:
                //Toast.makeText(this,"Song 6 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton6);
                break;
            case R.id.searchSongButton7:
                //Toast.makeText(this,"Song 7 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton7);
                break;
            case R.id.searchSongButton8:
                //Toast.makeText(this,"Song 8 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton8);
                break;
            case R.id.searchSongButton9:
                //Toast.makeText(this,"Song 9 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton9);
                break;
            case R.id.searchSongButton10:
                //Toast.makeText(this,"Song 10 selected", Toast.LENGTH_SHORT).show();
                handleSelectionSearch(searchButton10);
                break;
            default:
                break;
        }
    }

    public void sendDataToSongPlayerFromSearch(int index){
        Intent intent = new Intent(this, SongPlayer.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    public void handleSelectionSearch(View myView){
        String resourceId = getResources().getResourceEntryName(myView.getId());
        int currentArrayIndex = songCollection.searchSongById(resourceId);
        Log.d("Selection Handling", "ID: " + resourceId);
        sendDataToSongPlayerFromSearch(currentArrayIndex);
    }
}