package com.example.realmusicapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PlaylistView extends RecyclerView.ViewHolder {
    public TextView playlistRowSongTitle;
    public TextView playlistRowSongArtist;
    public Button playlistRowButton;
    public ImageButton removeFromPlaylistButton;
    public TextView playlistPlayerSongTitle;

    public PlaylistView(@NonNull View itemView) {
        super(itemView);
        playlistRowSongTitle = itemView.findViewById(R.id.playlistRowSongTitle);
        playlistRowSongArtist = itemView.findViewById(R.id.playlistRowSongArtist);
        playlistRowButton = itemView.findViewById(R.id.playlistRowButton);
        removeFromPlaylistButton = itemView.findViewById(R.id.removeFromPlaylistButton);
        playlistPlayerSongTitle = itemView.findViewById(R.id.playlistPlayerSongTitle);
    }
}
