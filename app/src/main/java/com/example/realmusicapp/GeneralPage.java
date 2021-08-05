package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GeneralPage extends AppCompatActivity {

    private ImageButton generalBackButton;
    private TextView clearCacheTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_page);

        clearCacheTextView = findViewById(R.id.clearCacheTextView);
        clearCacheTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearCacheDialogFragment clearCacheDialogFragment = new ClearCacheDialogFragment();
                clearCacheDialogFragment.show(getSupportFragmentManager(), "clear cache fragment");
            }
        });

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