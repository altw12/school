package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SearchPage extends AppCompatActivity {

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

    }
    public void openHomePageFromSearch(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}