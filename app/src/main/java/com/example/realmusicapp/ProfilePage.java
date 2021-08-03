package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ProfilePage extends AppCompatActivity {

    private ImageButton profileBackButton;
    private Button profileEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        profileEditButton = (Button) findViewById(R.id.profileEditButton);
        profileEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfilePageFromProfile();
            }
        });

        profileBackButton = (ImageButton) findViewById(R.id.profileBackButton);
        profileBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageFromProfile();
            }
        });
    }
    public void openHomePageFromProfile(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openEditProfilePageFromProfile(){
        Intent intent = new Intent(this, EditProfilePage.class);
        startActivity(intent);
    }
}