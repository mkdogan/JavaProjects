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
public class PremiumUser extends User {

    private Song[] installedSongs;

    public PremiumUser(String name, String surname, String nickname) {
        super(name, surname, nickname);
        playlists = new Playlist[3];
        installedSongs = new Song[20];
    }

    public PremiumUser() {
        playlists = new Playlist[3];
        installedSongs = new Song[20];
    }

    public void deleteSongs(Song... songs) {
        for (Song song : songs) {
            for (int i = 0; i < getInstalledSongs().length; i++) {
                if (installedSongs[i] != null) {
                    getInstalledSongs()[i] = null;
                    break;
                }
            }
        }
    }

    public void installSongs(Song... songs) {
        for (Song song : songs) {
            for (int i = 0; i < getInstalledSongs().length; i++) {
                if (installedSongs[i] == null) {
                    getInstalledSongs()[i] = song;
                    break;
                }
            }
        }

    }

    public Song[] getInstalledSongs() {
        return installedSongs;
    }

    public void setInstalledSongs(Song[] installedSongs) {
        this.installedSongs = installedSongs;
    }

}
