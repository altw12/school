package com.example.realmusicapp;

public class SongCollection {
    private Song songs[] = new Song[10];
    public SongCollection(){
        Song medicineDaughter = new Song("searchSongButton1", "Medicine", "Daughter", "https://p.scdn.co/mp3-preview/1bcda27168947912f163fb59eeabb4a6ca6f5cb3?cid=2afe87a64b0042dabf51f37318616965", 4.32, R.drawable.daughtermedicine);
        Song toxicBritneySpears = new Song("searchSongButton2", "Toxic", "Britney Spears", "https://p.scdn.co/mp3-preview/8465386fd6ce10f7ae3bd9c907825d7cb955ade0?cid=2afe87a64b0042dabf51f37318616965", 3.31, R.drawable.toxicbs);
        Song justHearMeOutNow = new Song("searchSongButton3", "just hear me out now", "Gud", "https://drive.google.com/file/d/11MHQgxjZI-fFxSdYg3ppVSLJTG6DbGj5/preview", 2.13, R.drawable.jhmongud);
        Song drown = new Song("searchSongButton4", "Drown", "Bring Me The Horizon", "https://drive.google.com/file/d/1PXzNJyOMMBb1XufH7arte9bgAxrTs5tR/preview", 4.81, R.drawable.drownbmth);
        Song betterWithYou = new Song ("searchSongButton5", "betterWithYou", "This Wild Life", "https://p.scdn.co/mp3-preview/4a2efe4bdce703724fc12dd0ab018113fbbf590d?cid=2afe87a64b0042dabf51f37318616965", 4.81, R.drawable.thiswildlifebetterwithyou);
        Song simple = new Song ("searchSongButton6", "Simple", "iMovie", "https://drive.google.com/file/d/1Brsmro19vdmzXO0c7N0dgjSFumYcOxN5/preview", 1.01, R.drawable.simpleimovie);




        songs[0] = medicineDaughter;
        songs[1] = toxicBritneySpears;
        songs[2] = justHearMeOutNow;
        songs[3] = drown;
        songs[4] = betterWithYou;
        songs[5] = simple;

    }

    public Song getCurrentSong(int currentSongId){

        return songs[currentSongId];
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

    public int getNextSong(int currentSongIndex){
        if(currentSongIndex >= songs.length-1){
            return currentSongIndex;
        }
        else{
            return currentSongIndex+1;
        }
    }

    public int getPrevSong(int currentSongIndex){
        if(currentSongIndex <= 0){
            return currentSongIndex;
        }
        else{
            return currentSongIndex-1;
        }
    }
}
