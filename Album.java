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

public class Album {

    private String name;
    private Singer singer;
    private Song songList[];
    private int albumFollowerAmount;
    private int albumUpvote;

    public Album(String name, Singer singer){
        this.name = name;
        this.singer= singer;
        for (int i = 0; i < singer.getAlbumList().length; i++) {
            if(singer.getAlbumList()[i] == null){
                singer.setAlbumList(this);
                break;
            }
        }
        songList = new Song [20];
    }
    
    public void printSongs(){ // albumInfo metodunda songList 'i yazdırmak için oluşturdum.
        for (int i = 0; i < songList.length; i++) {
            if (this.songList[i] != null) {
                System.out.println(this.songList[i].getName());
            }
        }
    }
    
    public void albumInfo(){
        System.out.println("Album name: " + this.name);
        System.out.println("Singer: " + this.singer.getName() + " " + this.singer.getSurname());
        System.out.println("Song list: "); // Nasıl yapılabilir??????????????????????????????????????????????????????
         for (int i = 0; i < songList.length; i++) {
            if (this.songList[i] != null) {
                System.out.println(this.songList[i].getName());
            }
        }
        //printSongs(); // Başka bir yöntemle  yap bunu!
        System.out.println("Album follower amount: " + this.getAlbumFollowerAmount());
        System.out.println("Album upvote: " + albumUpvote);
    }
    
    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Song[] getSongList() {
        return songList;
    }

    public void setSongList(Song[] songList) {
        this.songList = songList;
    }

    public int getAlbumFollowerAmount() {
        return albumFollowerAmount;
    }

    public void setAlbumFollowerAmount(int albumFollowerAmount) {
        this.albumFollowerAmount += albumFollowerAmount;
    }

    public int getAlbumUpvote() {
        return albumUpvote;
    }

    public void setAlbumUpvote(int albumUpvote) {
        this.albumUpvote += albumUpvote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
