package com.example.realmusicapp;

public class SongCollection {
    private Song songs[] = new Song[2];
    public SongCollection(){
        Song medicineDaughter = new Song("searchSongButton1", "Medicine", "Daughter", "https://p.scdn.co/mp3-preview/1bcda27168947912f163fb59eeabb4a6ca6f5cb3?cid=2afe87a64b0042dabf51f37318616965", 4.32, R.drawable.daughtermedicine);
        Song toxicBritneySpears = new Song("searchSongButton2", "Toxic", "Britney Spears", "https://p.scdn.co/mp3-preview/8465386fd6ce10f7ae3bd9c907825d7cb955ade0?cid=2afe87a64b0042dabf51f37318616965", 3.31, R.drawable.toxicbs);
        songs[0] = medicineDaughter;
        songs[1] = toxicBritneySpears;
    }
    public int searchSongById(String id){
        for(int index = 0; index < songs.length; index++){
            Song tempSong = songs[index];
            if(tempSong.getId().equals(id)){
                return index;
            }
        }
        return -1;
    }
}
