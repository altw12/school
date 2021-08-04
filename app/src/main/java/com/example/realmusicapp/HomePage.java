package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    private ImageButton homeProfileButton;
    private ImageButton homeSearchButton;
    private ImageButton homeSettingsButton;
    private ImageButton homePlaylistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        homeProfileButton = (ImageButton) findViewById(R.id.homeProfileButton);
        homeProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfilePage();
            }
        });

        homeSearchButton = (ImageButton) findViewById(R.id.homeSearchButton);
        homeSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchPage();
            }
        });

        homeSettingsButton = (ImageButton) findViewById(R.id.homeSettingsButton);
        homeSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });

        homePlaylistButton = (ImageButton) findViewById(R.id.homePlaylistButton);
        homePlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaylistPage();
            }
        });


    }
    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
    public void openSearchPage(){
        Intent intent = new Intent(this, SearchPageV2.class);
        startActivity(intent);
    }
    public void openSettingsPage(){
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }
    public void openPlaylistPage(){
        Intent intent = new Intent(this, PlaylistPage.class);
        startActivity(intent);
    }
}