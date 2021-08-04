package com.example.realmusicapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecViewAdaptor extends RecyclerView.Adapter<RecViewAdaptor.myViewHolder>{
    //CHYANGED THIS
    private List<Song> mSongList = new ArrayList<>();
    private List<Song> songListFull = new ArrayList<>();
    Context context;
    SongCollection songCollection = new SongCollection();
    ///constructor///////
    public RecViewAdaptor(Context ct, List<Song> songList){
        context = ct;
        mSongList = songList;
        songListFull = songList;
    }
    ///////////////////

    //////inflater/////////
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.search_row, parent, false);
        return new myViewHolder(view);

    }
    //////set Data //////////////
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Song currentSong = mSongList.get(position);
        holder.searchv2Title.setText(currentSong.getTitle());
        holder.searchv2Artist.setText(currentSong.getArtist());
        //holder.searchv2Platform.setText(currentSong.getPl
        holder.searchv2Button.setImageResource(currentSong.getDrawable());
        holder.searchv2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("selection", "Song name: " + currentSong.getTitle());
                Log.d("selection", "Full Song List" + songListFull);
                /*for(Song song : songListFull){
                    int count = 0;
                    if(song != currentSong){
                        count++;
                    }
                    else{
                        Log.d("selection", "Song Array Index: " + count);
                    }
                }*/
                sendDataToSongPlayerFromSearchV2(songListFull.indexOf(currentSong));
            }
        });
    }

    /////dont need/////////
    @Override
    public int getItemCount() {
        return mSongList.size();
    }

    /////////change recyclerview based on mSongList///////////
    public void filterList(ArrayList<Song> filteredList){
        mSongList = filteredList;
        notifyDataSetChanged();
    }
    /////////////

    ////init ui///
    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView searchv2Title, searchv2Artist, searchv2Platform;
        ImageButton searchv2Button;
        ConstraintLayout mainLayout;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            searchv2Title = itemView.findViewById(R.id.searchv2Title1);
            searchv2Artist = itemView.findViewById(R.id.searchv2Artist1);
            searchv2Platform = itemView.findViewById(R.id.searchv2Platform);
            searchv2Button = itemView.findViewById(R.id.searchv2Button1);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

    ////////send data to song player
    public void sendDataToSongPlayerFromSearchV2(int index){
        Intent intent = new Intent(context, SongPlayer.class);
        intent.putExtra("index", index);
        //Log.d("selection", "Song Index: "+ index);
        context.startActivity(intent);
    }

}