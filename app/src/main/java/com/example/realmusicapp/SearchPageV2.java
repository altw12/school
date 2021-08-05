package com.example.realmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SearchPageV2 extends AppCompatActivity {

    private ArrayList<Song> mSongList = new ArrayList<>();
    RecViewAdaptor mAdaptor;
    private ImageButton searchBackButtonV2;
    RecyclerView recyclerView;
    private EditText search_barv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page_v2);

        fillSongList();

        search_barv2 = (EditText) findViewById(R.id.search_barv2);
        search_barv2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        searchBackButtonV2 = findViewById(R.id.searchBackButtonv2);
        searchBackButtonV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePageFromSearchV2();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        mAdaptor = new RecViewAdaptor(this, mSongList);
        recyclerView.setAdapter(mAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    //filters the songs
    private void filter(String text){
        ArrayList<Song> filteredList = new ArrayList<>();
        for (Song song : mSongList){
            if (song.getTitle().toLowerCase().startsWith(text.toLowerCase())){
                filteredList.add(song);
            }
        }
        if(filteredList == null || filteredList.isEmpty()){
            filteredList = mSongList;
        }
        Log.d("selection","Filtered List: " + filteredList);
        mAdaptor.filterList(filteredList);
    }


    private void openHomePageFromSearchV2(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void fillSongList(){
        mSongList = new ArrayList<>();
        mSongList.add(new Song("searchSongButton1", "Medicine", "Daughter", "https://p.scdn.co/mp3-preview/1bcda27168947912f163fb59eeabb4a6ca6f5cb3?cid=2afe87a64b0042dabf51f37318616965", 4.32, R.drawable.daughtermedicine));
        mSongList.add(new Song("searchSongButton2", "Toxic", "Britney Spears", "https://p.scdn.co/mp3-preview/8465386fd6ce10f7ae3bd9c907825d7cb955ade0?cid=2afe87a64b0042dabf51f37318616965", 3.31, R.drawable.toxicbs));
        mSongList.add(new Song("searchSongButton3", "Holocene", "Bon Iver", "https://p.scdn.co/mp3-preview/c9f4b3bbf31e3c191d2778193e73050c212aed80?cid=2afe87a64b0042dabf51f37318616965", 2.13, R.drawable.holocene));
        mSongList.add(new Song("searchSongButton4", "Orange Julius", "Joyce Manor", "https://p.scdn.co/mp3-preview/9c66b4042e8113017be78f965d92c1a54e3d7523?cid=2afe87a64b0042dabf51f37318616965", 4.71, R.drawable.joycemanor));
        mSongList.add(new Song ("searchSongButton5", "Better With You", "This Wild Life", "https://p.scdn.co/mp3-preview/4a2efe4bdce703724fc12dd0ab018113fbbf590d?cid=2afe87a64b0042dabf51f37318616965", 4.81, R.drawable.thiswildlifebetterwithyou));
        mSongList.add(new Song ("searchSongButton6", "Anika", "Gud", "https://p.scdn.co/mp3-preview/85299fe77a9918afa89b71fee54c1a1f42d4c2d1?cid=2afe87a64b0042dabf51f37318616965", 2.76, R.drawable.gud));
        mSongList.add(new Song ("searchSongButton7", "Clover", "The Rare Occasions", "https://p.scdn.co/mp3-preview/cc88e3e3a7b98f4c8ffc57499998e667266d31bb?cid=2afe87a64b0042dabf51f37318616965", 1.15, R.drawable.clover));
        mSongList.add(new Song ("searchSongButton8", "Camp Adventure", "Delta Sleep", "https://p.scdn.co/mp3-preview/c436e1162c94d59fc20961cbec8d044b243462d3?cid=2afe87a64b0042dabf51f37318616965", 3.11, R.drawable.deltasleepcampadventure));
        mSongList.add(new Song ("searchSongButton9", "Pollen", "Ecco2k", "https://p.scdn.co/mp3-preview/0eb78eb89458b66c7eb251b9ca1c8ff8c0e11e76?cid=2afe87a64b0042dabf51f37318616965", 2.8, R.drawable.pollen));
    }

}