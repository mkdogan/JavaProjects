/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycompany.test;

/**
 * @file Test.java
 * @description bu program bir müzik yayın sistemini simüle eder, kullanıcıların ve şarkıcı/bestecilerin işlemlerini, karmaşık string aramasını, çeşitli şarkıları ve özelliklerini içerir
 * @assignment Proje 2
 * @date 17.12.2022
 * @author Muhammed Kasım Doğan
 */
public class Playlist {

    private String name;
    private int nbrOfSongs;
    private Song[] songList;
    private int followerAmount;
    private User [] followers;

    public Playlist() {
        songList = new Song[5];
        followers = new User [20];
    }
    
    public String mostClickedSong() {
        int maxIdx = 0;
        boolean isFound = false;
        for (int i = 0; i < songList.length; i++) {
            int max=Integer.MIN_VALUE;
            if(songList[i] != null){
                if (songList[i].getPlayCount() > max){
                    max = songList[i].getPlayCount();
                    maxIdx = i;
                    isFound = true;
                    break;
                }
            }
        }
        if (isFound)
           return songList[maxIdx].getName();
        else{
            return "Playlist is empty!";
        }
    }
    
    public void playlistInfo() {
        System.out.println("Playlists name: " + this.name);
        System.out.println("Number of songs: " + this.nbrOfSongs);
        System.out.println("Playlists follower list: ");
        for (int i = 0; i < this.followers.length; i++) {
            if(followers[i] != null) {
                System.out.println(followers[i].getName()+ " " + followers[i].getSurname() + " (" + followers[i].getNickname() + ")");
            }
        }
        System.out.println("Playlist's songs");
        System.out.println("Song name --> Singer name");
        System.out.println("------------------------------");
        for (int i = 0; i < songList.length; i++) {
            if (songList[i] != null) {
                System.out.println(songList[i].getName() + " --> " + songList[i].getSinger().getName() + " " + songList[i].getSinger().getSurname());
            }
        }
        

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbrOfSongs() {
        return nbrOfSongs;
    }

    public void setNbrOfSongs(int nbrOfSongs) {
        this.nbrOfSongs += nbrOfSongs;
    }

    public Song[] getSongList() {
        return songList;
    }

    public void setSongList(Song[] songList) {
        this.songList = songList;
    }

    public int getFollowerAmount() {
        return followerAmount;
    }

    public void setFollowerAmount(int followerAmount) {
        this.followerAmount += followerAmount;
    }

    public User[] getFollowers() {
        return followers;
    }

    public void setFollowers(User follower) {
        for (int i = 0; i < this.followers.length; i++) {
            if(this.followers[i] == null){
                this.followers[i] = follower;
                return;
            }
        }
        
    }
}
