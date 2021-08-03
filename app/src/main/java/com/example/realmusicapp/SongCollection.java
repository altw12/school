package com.example.realmusicapp;

public class SongCollection {
    public Song[] songs = new Song[9];
    public SongCollection(){
        Song medicineDaughter = new Song("searchSongButton1", "Medicine", "Daughter", "https://p.scdn.co/mp3-preview/1bcda27168947912f163fb59eeabb4a6ca6f5cb3?cid=2afe87a64b0042dabf51f37318616965", 4.32, R.drawable.daughtermedicine);
        Song toxicBritneySpears = new Song("searchSongButton2", "Toxic", "Britney Spears", "https://p.scdn.co/mp3-preview/8465386fd6ce10f7ae3bd9c907825d7cb955ade0?cid=2afe87a64b0042dabf51f37318616965", 3.31, R.drawable.toxicbs);
        Song holocene = new Song("searchSongButton3", "Holocene", "Bon Iver", "https://p.scdn.co/mp3-preview/c9f4b3bbf31e3c191d2778193e73050c212aed80?cid=2afe87a64b0042dabf51f37318616965", 2.13, R.drawable.holocene);
        Song orangeJulius = new Song("searchSongButton4", "Orange Julius", "Joyce Manor", "https://p.scdn.co/mp3-preview/9c66b4042e8113017be78f965d92c1a54e3d7523?cid=2afe87a64b0042dabf51f37318616965", 4.71, R.drawable.joycemanor);
        Song betterWithYou = new Song ("searchSongButton5", "Better With You", "This Wild Life", "https://p.scdn.co/mp3-preview/4a2efe4bdce703724fc12dd0ab018113fbbf590d?cid=2afe87a64b0042dabf51f37318616965", 4.81, R.drawable.thiswildlifebetterwithyou);
        Song anika = new Song ("searchSongButton6", "Anika", "Gud", "https://p.scdn.co/mp3-preview/85299fe77a9918afa89b71fee54c1a1f42d4c2d1?cid=2afe87a64b0042dabf51f37318616965", 2.76, R.drawable.gud);
        Song clover = new Song ("searchSongButton7", "Clover", "The Rare Occasions", "https://p.scdn.co/mp3-preview/cc88e3e3a7b98f4c8ffc57499998e667266d31bb?cid=2afe87a64b0042dabf51f37318616965", 1.15, R.drawable.clover);
        Song campAdventure = new Song ("searchSongButton8", "Camp Adventure", "Delta Sleep", "https://p.scdn.co/mp3-preview/c436e1162c94d59fc20961cbec8d044b243462d3?cid=2afe87a64b0042dabf51f37318616965", 3.11, R.drawable.deltasleepcampadventure);
        Song pollen = new Song ("searchSongButton9", "Pollen", "Ecco2k", "https://p.scdn.co/mp3-preview/0eb78eb89458b66c7eb251b9ca1c8ff8c0e11e76?cid=2afe87a64b0042dabf51f37318616965", 2.8, R.drawable.pollen);




        songs[0] = medicineDaughter;
        songs[1] = toxicBritneySpears;
        songs[2] = holocene;
        songs[3] = orangeJulius;
        songs[4] = betterWithYou;
        songs[5] = anika;
        songs[6] = clover;
        songs[7] = campAdventure;
        songs[8] = pollen;

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
