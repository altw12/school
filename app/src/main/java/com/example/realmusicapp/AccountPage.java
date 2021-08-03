package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class AccountPage extends AppCompatActivity {

    private ImageButton accountBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);

        accountBackButton = (ImageButton) findViewById(R.id.accountBackButton);
        accountBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsFromAccountPage();
            }
        });
    }

    public void openSettingsFromAccountPage() {
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }
}