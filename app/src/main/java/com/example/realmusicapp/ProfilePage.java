package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    private ImageButton profileBackButton;
    private Button profileEditButton;

    private TextView editProfileName;
    private TextView editMobileNo;
    private TextView editEmailAddress;

    private String personName;
    private String personEmail;
    private String mobileNumber;

    private String tempName = "John Doe";
    private String tempMail = "johndoe@mail.com";
    private String tempNo = "+123 456 789";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);


        Intent intent = getIntent();

        Log.d("Profile", "Extra Text = " + EditProfilePage.EXTRA_TEXT);

        personName = intent.getStringExtra(EditProfilePage.EXTRA_TEXT);
        personEmail = intent.getStringExtra(EditProfilePage.EXTRA_EMAIL);
        mobileNumber = intent.getStringExtra(EditProfilePage.EXTRA_NUMBER);

        editProfileName = findViewById(R.id.editProfileName);
        editMobileNo = findViewById(R.id.editMobileNo);
        editEmailAddress = findViewById(R.id.editEmailAddress);

        if(personName==null){
            personName = tempName;
        }
        else {
            editProfileName.setText(personName);
            tempName = personName;
        }
        if(personEmail==null){
            personEmail = tempMail;
        }
        else{
            editEmailAddress.setText(personEmail);
            tempMail = personName;
        }
        if (mobileNumber==null){
            mobileNumber = tempNo;
        }
        else{
            editMobileNo.setText(mobileNumber);
            tempNo = mobileNumber;
        }

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