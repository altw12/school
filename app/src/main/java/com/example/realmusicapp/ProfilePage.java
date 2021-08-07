package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.realmusicapp.HomePage.tempName;

public class ProfilePage extends AppCompatActivity {

    private ImageButton profileBackButton;
    private Button profileEditButton;

    private TextView editProfileName;
    private TextView editMobileNo;
    private TextView editEmailAddress;

    private String personName;
    private String personEmail;
    private String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        editProfileName = findViewById(R.id.editProfileName);
        editMobileNo = findViewById(R.id.editMobileNo);
        editEmailAddress = findViewById(R.id.editEmailAddress);


        Intent intent = getIntent();

        //if profile hasnt been set yet (null), use default john doe values
        personName = intent.getStringExtra(EditProfilePage.EXTRA_TEXT);
        if(personName!= null){
            editProfileName.setText(personName);
            HomePage.tempName = personName;
        }
        else{
            editProfileName.setText(HomePage.tempName);
        }
        personEmail = intent.getStringExtra(EditProfilePage.EXTRA_EMAIL);
        if(personEmail != null){
            editEmailAddress.setText(personEmail);
            HomePage.tempEmail = personEmail;
        }
        else{
            editEmailAddress.setText(HomePage.tempEmail);
        }
        mobileNumber = intent.getStringExtra(EditProfilePage.EXTRA_NUMBER);
        if(mobileNumber!=null){
            editMobileNo.setText(mobileNumber);
            HomePage.tempNumber = mobileNumber;
        }
        else{
            editMobileNo.setText(HomePage.tempNumber);
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