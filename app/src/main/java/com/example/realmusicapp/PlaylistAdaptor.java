package com.example.realmusicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaylistAdaptor extends RecyclerView.Adapter<PlaylistView> {
    List<Song> songs;
    int playlistIndex;
    Context context;
    public PlaylistAdaptor(List<Song> songs, int playlistIndex) {
        this.songs = songs;
        this.playlistIndex = playlistIndex;
    }

    @NonNull
    @Override
    public PlaylistView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View playlistView = inflater.inflate(R.layout.playlist_row, parent, false);
        PlaylistView viewHolder = new PlaylistView(playlistView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistView holder, final int position) {
        Song song = songs.get(position);
        TextView title = holder.playlistRowSongTitle;
        title.setText(song.getTitle());
        TextView artist = holder.playlistRowSongArtist;
        artist.setText(song.getArtist());
        //remove song using position from playlist
        switch(playlistIndex){
            case 0:
                holder.removeFromPlaylistButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddToPlaylistPage.happyList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                break;
            case 1:
                holder.removeFromPlaylistButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddToPlaylistPage.sadList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                break;
            case 2:
                holder.removeFromPlaylistButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddToPlaylistPage.epicList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                break;
            case 3:
                holder.removeFromPlaylistButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddToPlaylistPage.funnyList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + playlistIndex);
        }
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}
