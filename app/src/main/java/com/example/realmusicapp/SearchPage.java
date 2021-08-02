package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SearchPage extends AppCompatActivity implements View.OnClickListener {

    private ImageButton searchBackButton;
    private Button searchButton1;
    private Button searchButton2;
    private Button searchButton3;
    private Button searchButton4;
    private Button searchButton5;
    private Button searchButton6;
    private Button searchButton7;
    private Button searchButton8;
    private Button searchButton9;
    private Button searchButton10;

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