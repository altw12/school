package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NotificationsPage extends AppCompatActivity {

    private ImageButton notificationsBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_page);

        notificationsBackButton = (ImageButton) findViewById(R.id.notificationsBackButton);
        notificationsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsFromNotificationsPage();
            }
        });

    }

    public void openSettingsFromNotificationsPage() {
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }
}