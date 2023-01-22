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
public class DataManager {

    private User[] users;
    private Playlist[] playlists;
    private Singer[] singers;
    private Album[] albums;

    public DataManager() {
        users = new User[20];
        playlists = new Playlist[20];
        singers = new Singer[20];
        albums = new Album[20];
    }

    public void printInstalledSongs(PremiumUser premiumUser) {
        System.out.println("User Name: " + premiumUser.getName() + " " + premiumUser.getSurname());
        System.out.println("Nickname: " + premiumUser.getNickname());
        for (int i = 0; i < premiumUser.getInstalledSongs().length; i++) {
            if (premiumUser.getInstalledSongs()[i] != null) {
                System.out.println(premiumUser.getInstalledSongs()[i].getName());
            }
        }
    }

    public void giveAddPrivilege(User user) {
        user.setAddPrivilege(true);
    }

    public void recordAlbums(Album... albums) {
        this.setAlbums(albums);
    }

    public void recordUsers(User... users) {
        this.setUsers(users);
    }

    public void recordPlaylists(Playlist... playlists) {
        this.setPlaylists(playlists);
    }

    public void recordSingers(Singer... singers) {
        this.setSingers(singers);
    }

    public void mostPopularSongInAlbums() {
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < getAlbums().length; i++) {
            max = 0;
            maxIdx = 0;
            if (getAlbums()[i] != null) {
                for (int j = 0; j < getAlbums()[i].getSongList().length; j++) {
                    if (getAlbums()[i].getSongList()[j] != null) {
                        if (getAlbums()[i].getSongList()[j].getSongUpvote() > max) {
                            max = getAlbums()[i].getSongList()[j].getSongUpvote();
                            maxIdx = j;
                        }
                    }
                }

                // if (max == 0) {
                //  System.out.println("This album's songs are not upvoted yet :(");
                //}
                if ((getAlbums()[i].getName().charAt(getAlbums()[i].getName().length() - 1) == 's')) {
                    System.out.println(getAlbums()[i].getName() + "' most favourite song is: ");
                    getAlbums()[i].getSongList()[maxIdx].songInfo();
                } else {
                    System.out.println(getAlbums()[i].getName() + "'s most favourite song is: ");
                    getAlbums()[i].getSongList()[maxIdx].songInfo();
                }

            }
        }

    }

    public void leastPopularSongInAlbums() {
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < getAlbums().length; i++) {
            min = Integer.MAX_VALUE;
            minIdx = 0;
            if (getAlbums()[i] != null) {
                for (int j = 0; j < getAlbums()[i].getSongList().length; j++) {
                    if (getAlbums()[i].getSongList()[j] != null) {
                        if (getAlbums()[i].getSongList()[j].getSongUpvote() < min) {
                            min = getAlbums()[i].getSongList()[j].getSongUpvote();
                            minIdx = j;
                        }
                    }
                }
                //if (min == 0) {
                //  System.out.println("This album's songs are not upvoted yet :(");
                //}
                if ((getAlbums()[i].getName().charAt(getAlbums()[i].getName().length() - 1) == 's')) {
                    System.out.println(getAlbums()[i].getName() + "' least favourite song is: ");
                    getAlbums()[i].getSongList()[minIdx].songInfo();
                } else {
                    System.out.println(getAlbums()[i].getName() + "'s least favourite song is: ");
                    getAlbums()[i].getSongList()[minIdx].songInfo();
                }

            }
        }
    }

    public void mostPopularPlaylistInfo() {
        int max = 0;
        int maxIdx = 0;
        System.out.println("Most popular playlist info: ");
        for (int i = 0; i < getPlaylists().length; i++) {
            if (getPlaylists()[i].getFollowerAmount() > max) {
                max = getPlaylists()[i].getFollowerAmount();
                maxIdx = i;
            }
        }
        getPlaylists()[maxIdx].playlistInfo();
    }

    public void mostPopularSingerInfo() {
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < getSingers().length; i++) {
            if (getSingers()[i].getNbrOfFollowers() > max) {
                max = getSingers()[i].getNbrOfFollowers();
                maxIdx = i;
            }
        }
        System.out.println("Most popular composer: ");
        getSingers()[maxIdx].singerInfo();
    }

    public void mostPopularSongInfo() {
        int max = 0;
        int maxIdx = 0;
        int singerIdx = 0;
        System.out.println("Most popular song info: ");
        for (int i = 0; i < getSingers().length; i++) {
            for (int j = 0; j < getSingers()[i].getSongList().length; j++) {
                if (getSingers()[i].getSongList()[j] != null) {
                    if (getSingers()[i].getSongList()[j].getSongUpvote() > max) {
                        max = getSingers()[i].getSongList()[j].getSongUpvote();
                        maxIdx = j;
                        singerIdx = i;
                    }
                }
            }
        }
        getSingers()[singerIdx].getSongList()[maxIdx].songInfo();
    }

    public void leastPopularSongInfo() {
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        System.out.println("Least popular song info: ");
        for (int i = 0; i < getSingers().length; i++) {
            if (getSingers()[i].getSongList()[i] != null) {
                if (getSingers()[i].getSongList()[i].getSongUpvote() < min) {
                    min = getSingers()[i].getSongList()[i].getSongUpvote();
                    minIdx = i;
                }
            }
        }
        getSingers()[minIdx].getSongList()[minIdx].songInfo();

    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    public Singer[] getSingers() {
        return singers;
    }

    public void setSingers(Singer[] singers) {
        this.singers = singers;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }
}
