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
public class User {

    private String name;
    private String nickname;
    private String surname;
    protected Playlist[] playlists; // Getter setter oluşturulmadı
    private boolean addPrivilege;

    public User() {
        playlists = new Playlist[2];
        //deletePrivilege = false;
        addPrivilege = false;
    }

    public User(String name, String surname, String nickname) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        playlists = new Playlist[2];
        //deletePrivilege = false;
        addPrivilege = false;

    }

    public void installSongs(Song... song) {
        System.out.println("Want to install? Get premium");
    }

    public void printPlaylists() {
        System.out.println("User name: " + this.name + " " + this.surname + "\nNickname: " + this.nickname);

        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] != null) {
                System.out.println("Playlists name: " + playlists[i].getName());
                System.out.println("Most clicked song in playlist: " + playlists[i].mostClickedSong()); // en çok dinlenenini döndüren metot.
                if (!playlists[i].mostClickedSong().equals("Playlist is empty!")) {
                    System.out.println("Playlists song list: ");
                    for (int j = 0; j < playlists[i].getSongList().length; j++) {
                        if (playlists[i].getSongList()[j] != null) {
                            System.out.println(playlists[i].getSongList()[j].getName());
                        }
                    }
                }
            }
        }

    }

    public void deleteFromPlaylist(Playlist playlist, Song song) {
        for (int j = 0; j < playlists.length; j++) {
            if (playlists[j] == playlist) {
                for (int i = 0; i < playlist.getSongList().length; i++) {
                    if (playlists[j].getSongList()[i] == song) {
                        playlists[j].getSongList()[i] = null;
                        playlist.setNbrOfSongs(-1);
                        break;
                    }
                }
            }
        }
    }

    public void addToPlaylist(Playlist playlist, Song song) {
        if (isAddPrivilege()) {
            for (int j = 0; j < playlists.length; j++) {
                if (playlists[j] == playlist) {
                    for (int i = 0; i < playlist.getSongList().length; i++) {
                        if (playlist.getSongList()[i] == null) {
                            playlist.getSongList()[i] = song; // playlistin songlistinin i'inci elemanına song'u atmayı amaçladım
                            playlist.setNbrOfSongs(1);
                            return;
                        }
                    }
                    System.out.println("Reached playlist limit, " + song.getName() + " can not be added!");
                    return;
                }
            }
            System.out.println("This playlist is not belong to " + this.getName() + " " + this.getSurname() + " " + this.getNickname());

        }

    }

    public void addPlaylist(Playlist playlist, String name) {
        if (isAddPrivilege()) {
            playlist.setName(name);
            for (int i = 0; i < playlists.length; i++) {
                if (playlists[i] == null) {
                    playlists[i] = playlist;
                    return;
                }
            }
            System.out.println("Reached playlist capacity");
        }

    }

    public void upvoteSong(Song song) {
        song.setSongUpvote(1);
        for (int i = 0; i < song.getUserUpvoteList().length; i++) {
            if (song.getUserUpvoteList()[i] == null) {
                song.getUserUpvoteList()[i] = this;
                break;
            }
        }
    }

    public void upvoteAlbum(Album album) {
        album.setAlbumUpvote(1);
    }

    public void followPlaylist(Playlist playlist) {
        playlist.setFollowerAmount(1);
        playlist.setFollowers(this);
    }

    public void followAlbum(Album album) {
        album.setAlbumFollowerAmount(1);
    }

    public void followSinger(Singer singer) {
        singer.setNbrOfFollowers(1);
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    public boolean isAddPrivilege() {
        return addPrivilege;
    }

    public void setAddPrivilege(boolean addPrivilege) {
        this.addPrivilege = addPrivilege;
    }
}
