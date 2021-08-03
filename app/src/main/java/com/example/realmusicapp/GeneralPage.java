package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GeneralPage extends AppCompatActivity {

    private ImageButton generalBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_page);

        generalBackButton = (ImageButton) findViewById(R.id.generalBackButton);
        generalBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsFromGeneralPage();
            }
        });
    }

    public void openSettingsFromGeneralPage() {
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }
}