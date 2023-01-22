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
public class Song {
    private String name;
    private Singer singer;
    private int songUpvote;
    private User userUpvoteList[];
    private Album album;
    private int playCount;

    public Song(String name, int playCount){
        this.name = name;
        this.playCount = playCount;
        userUpvoteList = new User [10];
    }
    
    
    
    public void songInfo(){
        System.out.println("Songs name: " + this.name);
        System.out.println("Song upvote: " + getSongUpvote());
        System.out.println("Like list: ");
        for (int i = 0; i < userUpvoteList.length; i++) {
            if(songUpvote == 0){
                System.out.println("No one liked the song yet :(");
                break;
            }
            if(userUpvoteList[i] != null){
                System.out.println(userUpvoteList[i].getName() + " " + userUpvoteList[i].getSurname() + "(" + userUpvoteList[i].getNickname() + ")");
            }
           
        }
        System.out.println("Songs album information: ");
        if (this.album != null){
            album.albumInfo();
        } else{
            System.out.println("Song does not belongs to an album.");
        }
        
    }
    
    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public int getSongUpvote() {
        return songUpvote;
    }

    public void setSongUpvote(int songUpvote) { //?????????????????????????
        this.songUpvote += songUpvote;
        
        
    }

    public User[] getUserUpvoteList() {
        return userUpvoteList;
    }

    public void setUserUpvoteList(User[] userUpvoteList) {
        this.userUpvoteList = userUpvoteList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
}
