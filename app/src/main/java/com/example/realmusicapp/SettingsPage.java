package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SettingsPage extends AppCompatActivity {

    private ImageButton settingsBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        settingsBackButton = (ImageButton) findViewById(R.id.settingsBackButton);
        settingsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageFromSettings();
            }
        });
    }
    public void openHomePageFromSettings(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}