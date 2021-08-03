package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EditProfilePage extends AppCompatActivity {

    private ImageButton editProfileBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_page);

        editProfileBackButton = (ImageButton) findViewById(R.id.editProfileBackButton);
        editProfileBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfilePageFromEdit();
            }
        });
    }
    public void openProfilePageFromEdit(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
}