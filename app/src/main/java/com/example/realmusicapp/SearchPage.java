package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SearchPage extends AppCompatActivity implements View.OnClickListener {

    private ImageButton searchBackButton;

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

        Button searchButton1 = findViewById(R.id.searchSongButton1);
        Button searchButton2 = findViewById(R.id.searchSongButton2);
        Button searchButton3 = findViewById(R.id.searchSongButton3);
        Button searchButton4 = findViewById(R.id.searchSongButton4);
        Button searchButton5 = findViewById(R.id.searchSongButton5);
        Button searchButton6 = findViewById(R.id.searchSongButton6);
        Button searchButton7 = findViewById(R.id.searchSongButton7);
        Button searchButton8 = findViewById(R.id.searchSongButton8);
        Button searchButton9 = findViewById(R.id.searchSongButton9);
        Button searchButton10 = findViewById(R.id.searchSongButton10);

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
                Toast.makeText(this,"Song 1 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton2:
                Toast.makeText(this,"Song 2 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton3:
                Toast.makeText(this,"Song 3 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton4:
                Toast.makeText(this,"Song 4 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton5:
                Toast.makeText(this,"Song 5 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton6:
                Toast.makeText(this,"Song 6 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton7:
                Toast.makeText(this,"Song 7 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton8:
                Toast.makeText(this,"Song 8 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton9:
                Toast.makeText(this,"Song 9 selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchSongButton10:
                Toast.makeText(this,"Song 10 selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}