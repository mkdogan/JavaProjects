/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package mycompany.test;

import java.util.Scanner;

/**
 * @file Test.java
 * @description bu program bir müzik yayın sistemini simüle eder, kullanıcıların ve şarkıcı/bestecilerin işlemlerini, karmaşık string aramasını, çeşitli şarkıları ve özelliklerini içerir
 * @assignment Proje 2
 * @date 17.12.2022
 * @author Muhammed Kasım Doğan
 */
public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DataManager dataManager = new DataManager();

        Singer singer1 = new Singer("Cemil", "Tanburî");
        Singer singer2 = new Singer("Abdülaziz", "Osmanoğlu");
        Singer singer3 = new Singer("Jürgen", "Marcus"); // 's' harfi ile biten isimlerdeki özelliği test etmek için.

        User user1 = new User("Bilge", "Kağan", "<Yabgu>");
        User user2 = new User("Bayındır", "Han", "_Ataman_");
        User user3 = new User("Korkut", "Ata", "***Kutadgu***");
        PremiumUser pUser4 = new PremiumUser("Kasım", "Doğan", "ReisBey");

        Song song1 = new Song("Hüseynî Saz Semâisi", 200);
        Song song2 = new Song("Muhayyer Peşrev", 100);
        Song song3 = new Song("Çeçen Kızı", 150);

        Song song4 = new Song("Hicaz Sirto", 100);
        Song song5 = new Song("Hicaz Mandıra", 70);
        Song song6 = new Song("Valse Davet", 175);
        Song song7 = new Song("Gondol Şarkısı", 250);
        Song song8 = new Song("Abdülaziz Polka", 50);

        Song song9 = new Song("Ein Festival der Frieden", 10);
        Song song10 = new Song("Für es Vaterland", 5);
        Song song11 = new Song("Für es Kaiser", 6);

        dataManager.giveAddPrivilege(user3);
        dataManager.giveAddPrivilege(user1); //Bu satırı kapatıp bir daha programı çalıştır.
        dataManager.giveAddPrivilege(user2);
        dataManager.giveAddPrivilege(pUser4);

        user1.followSinger(singer2);
        user1.followSinger(singer1);
        user2.followSinger(singer1);

        singer1.addSong(song1);
        singer1.addSong(song2);
        singer1.addSong(song3);

        singer2.addSong(song4);
        singer2.addSong(song5);
        singer2.addSong(song6);
        singer2.addSong(song7);
        singer2.addSong(song8);

        singer3.addSong(song9);
        singer3.addSong(song10);
        singer3.addSong(song11);

        Album album1 = new Album("Osmanlı Sarayından Avrupa Müziği", singer2);
        Album album2 = new Album("Klasik Osmanlı Musikisi", singer2);
        Album album3 = new Album("Tanburî Cemil Bey Klasikleri", singer1);

        pUser4.upvoteSong(song6);
        pUser4.upvoteSong(song2);
        pUser4.upvoteSong(song4);
        pUser4.upvoteSong(song7);
        pUser4.upvoteSong(song3);
        
        user1.upvoteSong(song1);
        user1.upvoteSong(song2);
        user1.upvoteSong(song3);
        user1.upvoteSong(song6);
        user1.upvoteSong(song7);

        user2.upvoteSong(song4);
        user2.upvoteSong(song5);
        user2.upvoteSong(song6);
        user2.upvoteSong(song7);
        user2.upvoteSong(song8);
        user2.upvoteSong(song9);
        user2.upvoteSong(song10);

        user3.upvoteSong(song4);
        user3.upvoteSong(song5);
        user3.upvoteSong(song6);
        user3.upvoteSong(song7);
        user3.upvoteSong(song8);
        user3.upvoteSong(song2);

        user1.upvoteAlbum(album1);
        user1.upvoteAlbum(album3);
        user3.upvoteAlbum(album2);
        user3.upvoteAlbum(album3);
        user2.upvoteAlbum(album2);
        user2.upvoteAlbum(album3);

        user1.followAlbum(album2);
        user1.followAlbum(album1);
        user2.followAlbum(album1);
        user3.followAlbum(album3);
        user2.followAlbum(album3);
        user1.followAlbum(album3);

        singer1.addToAlbum(album3, song1);
        singer1.addToAlbum(album3, song2);
        singer1.addToAlbum(album3, song3);
        singer2.addToAlbum(album2, song4);
        singer2.addToAlbum(album2, song5);
        singer2.addToAlbum(album1, song6);
        singer2.addToAlbum(album1, song7);
        singer2.addToAlbum(album1, song8);

        Playlist playlist1 = new Playlist();
        Playlist playlist2 = new Playlist();
        Playlist playlist3 = new Playlist();
        Playlist playlist4 = new Playlist();
        Playlist playlist5 = new Playlist();
        Playlist playlist6 = new Playlist();
        Playlist playlist7 = new Playlist();

        user1.addPlaylist(playlist1, "Favori");
        user1.addPlaylist(playlist2, "Çerezlik");
        //user1.addPlaylist(playlist5, "Deneme");//normal kullanıcının ikiden fazla playlist oluşturamama testi
        user1.addToPlaylist(playlist1, song3);
        user1.addToPlaylist(playlist1, song1);
        user1.addToPlaylist(playlist1, song2);
        user1.addToPlaylist(playlist1, song4);
        user1.addToPlaylist(playlist1, song7);
        
        //user1.addToPlaylist(playlist3, song8); // kullanıcının kendisine ait olmayan playliste ekleme yapamaması testi
        //user1.addToPlaylist(playlist1, song6); // playliste şarkı ekleme limit testi
        user1.addToPlaylist(playlist2, song9);
        user1.addToPlaylist(playlist2, song10);

        user2.addPlaylist(playlist3, "Almanca Şarkılar");
        user2.addToPlaylist(playlist3, song9);
        user2.addToPlaylist(playlist3, song10);
        user2.addToPlaylist(playlist3, song11);

        user3.addPlaylist(playlist4, "Abdülaziz Han Besteleri");
        user3.addToPlaylist(playlist4, song4);
        user3.addToPlaylist(playlist4, song5);
        user3.addToPlaylist(playlist4, song6);
        user3.addToPlaylist(playlist4, song7);
        user3.addToPlaylist(playlist4, song8);

        pUser4.addPlaylist(playlist5, "Deneme1"); //Premium kullanıcının 3 playlist ekleme testi
        pUser4.addPlaylist(playlist6, "Deneme2");
        pUser4.addPlaylist(playlist7, "Deneme3");
        pUser4.addToPlaylist(playlist5, song5);
        pUser4.addToPlaylist(playlist5, song6);
        pUser4.addToPlaylist(playlist5, song7);

        user1.followPlaylist(playlist1);
        user1.followPlaylist(playlist4);

        user2.followPlaylist(playlist4);
        user2.followPlaylist(playlist1);

        user3.followPlaylist(playlist3);
        user3.followPlaylist(playlist2);
        user3.followPlaylist(playlist4);

        /*
        pUser4.installSongs(song1, song2, song3, song4, song5, song6, song7); //Premium kullanıcı install delete song işlemleri
        dataManager.printInstalledSongs(pUser4);
        pUser4.deleteSongs(song1, song2);
        System.out.println("--------------------------");
        dataManager.printInstalledSongs(pUser4);
        System.out.println("--------------------------");
        user1.installSongs(song1, song2);
        */
        
        dataManager.recordUsers(user1, user2, user3, pUser4);
        dataManager.recordSingers(singer1, singer2, singer3);
        dataManager.recordPlaylists(playlist1, playlist2, playlist3, playlist4, playlist5, playlist6, playlist7);
        dataManager.recordAlbums(album1, album2, album3);
        // 1. Adı girilen şarkıcının bilgilerinin listelenmesi
        /*
        singer1.deleteSong(song3); //kendisine ait olan şarkıyı silebilir
        singer1.singerInfo();
        System.out.println("************************************");
        singer1.deleteSong(song4); // kendisine ait olmayan şarkıyı silemez
        singer2.singerInfo();
        System.out.println("************************************");
        singer3.singerInfo();
         */
        //2. Adı girilen şarkının bilgilerinin listelenmesi
        /*
        song1.songInfo(); 
        System.out.println("-----------------------------");
        song4.songInfo();
        System.out.println("-----------------------------");
        song11.songInfo();
         */
        // 3. Adı girilen albümün bilgilerinin listelenmesi
        /*
       album1.albumInfo();
       System.out.println("-----------------------------");
       album2.albumInfo();
       System.out.println("-----------------------------");
       album3.albumInfo();
         */
        //4. Adı girilen kullanıcının çalma listeleri listelenmesi
        /*
       user1.printPlaylists();
       System.out.println("-----------------------------");
       user2.printPlaylists();
       System.out.println("-----------------------------");
       user3.printPlaylists();
       System.out.println("-----------------------------");
       pUser4.printPlaylists();
         */
        // Silme testi
        /*
        user1.deleteFromPlaylist(playlist1, song3); // song3 = Çeçen Kızı
        user1.deleteFromPlaylist(playlist1, song7); // song7 = Gondol Şarkısı
        user2.deleteFromPlaylist(playlist1, song4); // song4 = Hicaz Sirto
        playlist1.playlistInfo();
        */
        
       //5. Adı girilen çalma listesinin bilgilerinin listelenmesi
       
       /*
       playlist2.playlistInfo();
       System.out.println("-----------------------------");
       playlist3.playlistInfo();
       System.out.println("-----------------------------");
       playlist4.playlistInfo();
         */
        
        /*
        int selection = -1;
        do {
            System.out.println("1. En çok takipçiye sahip olan çalma listesinin bilgilerinin listelenmesi\n" + "2. En çok takipçisi olan şarkıcının bilgilerinin listelenmesi\n" + "3. Tüm şarkılar arasından maksimum ve minimum beğeni alan şarkıların bilgileri listelenmesi\n" + "4. Oluşturulan tüm albümler için albüm içerisindeki şarkılar arasından maksimum ve minimum beğeni sayısına sahip şarkının bilgileri listelenmesi\n" + "5. Karmaşık string araması\n" + "Çıkmak için 0'a basın");
            selection = scan.nextInt();
            switch (selection) {
                case 0:
                    break;
                case 1:
                    // 6. En çok takipçiye sahip olan çalma listesinin bilgilerinin listelenmesi.
                    dataManager.mostPopularPlaylistInfo();
                    break;
                case 2:
                    // 7. En çok takipçisi olan şarkıcının bilgilerinin listelenmesi
                    dataManager.mostPopularSingerInfo();
                    break;
                case 3:
                    // 8. Tüm şarkılar arasından maksimum ve minimum beğeni alan şarkıların bilgileri listelenebilmelidir.
                    dataManager.mostPopularSongInfo();
                    System.out.println("-------------------------------");
                    dataManager.leastPopularSongInfo();
                    break;
                case 4:
                    //9. Oluşturulan tüm albümler için albüm içerisindeki şarkılar arasından maksimum ve minimum beğeni sayısına sahip şarkının bilgileri listelenmeli.
                    dataManager.mostPopularSongInAlbums();
                    System.out.println("-------------------------------");
                    dataManager.leastPopularSongInAlbums();
                    break;
                case 5:
                    //10. Karmaşık string araması
                    System.out.println("Please make a search for singers/composers: ");
                    scan.nextLine();
                    String input = scan.nextLine();
                    for (Singer singer : dataManager.getSingers()) {
                        if (search(input, singer.getName() + singer.getSurname())) {
                            singer.singerInfo();
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
            }
        } while (selection != 0);
        */
    }

    private static boolean search(String criter, String str) {
        int indexofFirstStar,
                indexofLastStar;

        indexofFirstStar = criter.charAt(0) == '*' ? 0 : -1;
        indexofLastStar = criter.indexOf("*", indexofFirstStar + 1);

        criter = criter.trim();
        criter = criter.toUpperCase();
        str = str.toUpperCase();

        do {

            if (!midSearch(str, criter, indexofFirstStar, indexofLastStar)) {
                return false;
            }
            if (indexofLastStar == -1) {
                return true;
            }
            indexofFirstStar = criter.indexOf("*", indexofLastStar);
            indexofLastStar = criter.indexOf("*", indexofFirstStar + 1);
        } while (true);
    }

    private static boolean midSearch(String str, String crt, int firstIndex, int lastIndex) {
        String midCriter;

        if (firstIndex == -1 && lastIndex == -1) {	//Tam
            if (crt == str) {
                return true;
            } else {
                return false;
            }
        }

        if (firstIndex == -1 && lastIndex > -1) {	//Başta
            midCriter = crt.substring(0, lastIndex);
            if (str.startsWith(midCriter)) {
                return true;
            } else {
                return false;
            }
        }

        if (firstIndex > -1 && lastIndex > -1) {	//Ortada
            midCriter = crt.substring(firstIndex + 1, lastIndex);
            if (str.indexOf(midCriter) >= 0) {
                return true;
            } else {
                return false;
            }
        }

        if (firstIndex >= 0 && lastIndex == -1) {	//Sonda
            midCriter = crt.substring(firstIndex + 1);
            if (str.endsWith(midCriter)) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }
}
