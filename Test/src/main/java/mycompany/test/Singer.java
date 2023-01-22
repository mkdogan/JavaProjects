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
public class Singer {

    private String name;
    private String surname;
    private int nbrOfFollowers;
    private Song songList[];
    private Album albumList[];
    private int nbrOfAlbum;
    private Song[] albumSongs; 

    public Singer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.songList = new Song[20];
        this.albumSongs = new Song[20];
        this.albumList = new Album[20];
    }

    public Singer() {
        this.songList = new Song[20];
        this.albumSongs = new Song[20];
        this.albumList = new Album[20];
    }

    public void addToAlbum(Album album, Song song) { // Aynı isimli iki albüm olursa ne olur (Çözüldü).
        song.setAlbum(album);

        for (int i = 0; i < album.getSongList().length; i++) {
            if (album.getSongList()[i] == null) {
                album.getSongList()[i] = song;
                return;
            }
        }
        System.out.println("Song list is full!");
    }

    public void deleteSong(Song song) {

        for (int i = 0; i < songList.length; i++) {
            if (songList[i] == song) {
                songList[i] = null;
                return;
            }
        }
        System.out.println(song.getName() + " is not belongs to " + this.name + " " + this.surname);
    }

    public void addSong(Song song) {
        song.setSinger(this);
        for (int i = 0; i < songList.length; i++) {
            if (songList[i] == null) {
                songList[i] = song;
                return;
            }
        }
        System.out.println("Reached song list upper limit");
    }

    public void singerInfo() {
        int count = 0;
        int counter = 0;
        System.out.println("Singer name: " + this.name + "\nSinger surname: " + this.surname);
        System.out.println("Number of followers: " + this.getNbrOfFollowers());
        for (int i = 0; i < this.getSongList().length; i++) {
            if (!(songList[i] == null)) {
                count++;
            }
            if (!(albumList[i] == null)) {
                counter++;
            }
        }
        System.out.println("Number of songs: " + count);

        System.out.println("Number of albums: " + counter);

        this.printSongs();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNbrOfFollowers() {
        return nbrOfFollowers;
    }

    public void setNbrOfFollowers(int nbrOfFollowers) { //Student class 'ı ile iletişimi var. sonrdan protected yapılabilir.
        this.nbrOfFollowers += nbrOfFollowers;
    }

    private void printSongs() { // getSongList yerine kullanılabilir. Private'a çevirdim  singerInfo()'da kullandım.
        char lastchar = this.getSurname().charAt(this.getSurname().length() - 1);
        if (lastchar == 's') {
            System.out.println(this.getName() + " " + this.getSurname() + "' songs:"); // Sonu s ile biten sanatçılarda imla hatası olmaması için.
        } else {
            System.out.println(this.getName() + " " + this.getSurname() + "'s songs:");
        }

        for (int i = 0; i < songList.length; i++) {
            if (!(songList[i] == null)) {
                System.out.println(songList[i].getName());
            }
        }
    }

    public Song[] getSongList() {
        return songList;
    }

    public void setSongList(Song[] songList) { 
        this.songList = songList;
    }

    public Album[] getAlbumList() {
        return albumList;
    }

    public void setAlbumList(Album album) {
        for (int i = 0; i < albumList.length; i++) {
            if (albumList[i] == null) {
                albumList[i] = album;
                break;
            }
        }
    }

    public int getNbrOfAlbum() {
        nbrOfAlbum = albumList.length;
        return nbrOfAlbum;
    }

    public Song[] getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(Song[] albumSongs) {
        this.albumSongs = albumSongs;
    }
}
