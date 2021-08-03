package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingsPage extends AppCompatActivity {

    private ImageButton settingsBackButton;
    private TextView settingsNotificationsButton;
    private TextView generalNotificationsButton;
    private TextView accountNotificationsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        accountNotificationsButton = (TextView) findViewById(R.id.accountGeneralButton);
        accountNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountPageFromSettings();
            }
        });

        generalNotificationsButton = (TextView) findViewById(R.id.settingsGeneralButton);
        generalNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGeneralPageFromSettings();
            }
        });

        settingsNotificationsButton = (TextView) findViewById(R.id.settingsNotificationsButton);
        settingsNotificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotificationsPageFromSettings();
            }
        });

        settingsBackButton = (ImageButton) findViewById(R.id.settingsBackButton);
        settingsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageFromSettings();
            }
        });


    }

    public void openNotificationsPageFromSettings() {
        Intent intent = new Intent(this, NotificationsPage.class);
        startActivity(intent);
    }

    public void openHomePageFromSettings(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void openGeneralPageFromSettings(){
        Intent intent = new Intent(this, GeneralPage.class);
        startActivity(intent);
    }

    public void openAccountPageFromSettings(){
        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);
    }

}