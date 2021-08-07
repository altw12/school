package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EditProfilePage extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.realmusicapp.EXTRA_TEXT";
    public static final String EXTRA_EMAIL = "com.example.realmusicapp.EXTRA_EMAIL";
    public static final String EXTRA_NUMBER = "com.example.realmusicapp.EXTRA_NUMBER";

    private ImageButton editProfileBackButton;
    private ImageButton editTextSaveChanges;

    private EditText editTextPersonName;
    private EditText editTextPersonEmail;
    private EditText editTextMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_page);

        editTextSaveChanges = (ImageButton) findViewById(R.id.editTextSaveChanges);
        editTextSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfilePageFromEditAndSaveChanges();
            }
        });

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
    public void openProfilePageFromEditAndSaveChanges(){
        editTextPersonName = findViewById(R.id.editTextPersonName);
        String personName = editTextPersonName.getText().toString();

        editTextPersonEmail = findViewById(R.id.editTextPersonEmail);
        String personEmail = editTextPersonEmail.getText().toString();

        editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        String mobileNumber = editTextMobileNumber.getText().toString();

        Intent intent = new Intent(this, ProfilePage.class);
        intent.putExtra(EXTRA_TEXT, personName);
        intent.putExtra(EXTRA_EMAIL, personEmail);
        intent.putExtra(EXTRA_NUMBER, mobileNumber);
        startActivity(intent);
    }
}