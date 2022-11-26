/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package mycompany.proje1;

import java.util.Scanner;

/**
 * @author Muhammed Kasım Doğan 
 * Öğrenci numarası: 2221221018
 */
public class Proje1 {

    public static void main(String[] args) {
        int count = 0;
        String menuManager = "";
        Scanner scan = new Scanner(System.in);

        while (!menuManager.equals("DUR")) {
            System.out.println("\nKullanıcı Menüsü\n1. Karakter dizisini çizdir\n2. Büyük harfe çevir\n3. Şifrele ve şifre çöz\n4. Harf çiz");
            System.out.println("Lütfen bir seçim yapınız: ");
            menuManager = scan.next();
            menuManager = myToUpperCase(menuManager); // "dur" kelimesinin farklı kombinasyonları için de geçerlidir.
            switch (menuManager) {
                case "1":
                    System.out.println("Bir karakter dizisi giriniz: ");
                    String input1 = scan.next();
                    karakterDizisiCizdir(input1);
                    break;
                case "2":
                    System.out.println("Cümle giriniz: ");
                    scan.nextLine(); // Scanner'ın doğru çalışması için
                    String input2 = scan.nextLine();
                    System.out.println(buyukHarfeCevir(input2));
                    break;
                case "3":
                    String input = ""; // değişken ömründen dolayı dışarıda tanımladım.
                    int kaydirma_degeri = 0;
                    boolean validity = false;
                    while (!validity) {
                        System.out.println("Lütfen kaydırma değeri giriniz");
                        kaydirma_degeri = scan.nextInt();
                        if (kaydirma_degeri >= 1 && kaydirma_degeri <= 25) {
                            System.out.println("Şifrelemek istediğiniz metni giriniz");
                            scan.nextLine(); // Scanner'ın doğru çalışması için
                            input = scan.nextLine();
                            validity = true;
                        } else if (kaydirma_degeri >= -25 && kaydirma_degeri <= -1) {
                            System.out.println("Çözmek istediğiniz metni giriniz");
                            scan.nextLine();
                            input = scan.nextLine();
                            validity = true;
                        } else {
                            System.out.println("Geçersiz kaydırma değeri");
                        }
                    }
                    sifreleCoz(input, kaydirma_degeri);
                    break;

                case "4":
                    boolean isValid = false;
                    String karakter = "";
                    int boyut = 1;
                    while (!isValid) {
                        System.out.println("Bir karakter giriniz: ");
                        karakter = scan.next();
                        karakter = myToUpperCase(karakter);
                        if ("X".equals(karakter) || "Z".equals(karakter)) {
                            isValid = true;
                        } else {
                            System.out.println("Girilen karakter geçersiz");
                        }
                    }
                    isValid = false;
                    while (!isValid) {
                        System.out.print("Bir boyut değeri giriniz: ");
                        boyut = scan.nextInt();
                        if (boyut % 2 == 1 && boyut >= 5) {
                            isValid = true;
                        } else {
                            System.out.println("Geçerli değil");
                        }
                    }
                    harfCizdir(karakter, boyut);
                    break;
                default:
                    //Yanlış giriş için kullanıcıyı uyardıktan sonra menü ekranını tekrar yazdırır.
                    if (!menuManager.equals("DUR")){
                        System.out.println("Lütfen geçerli bir seçim yapınız!!!");
                    }
                    
            }
        }

    }

    public static String myToUpperCase(String str) { // String tipinde girilen ifadeyi büyük harfe çevirir.
        String bigAlphabet = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZXQW",
                smallAlphabet = "abcçdefgğhıijklmnoöprsştuüvyzxqw",
                newStr = "";
        boolean small = false;
        char c;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < smallAlphabet.length(); j++) {
                c = smallAlphabet.charAt(j);
                if (str.charAt(i) == c) {
                    newStr += bigAlphabet.charAt(j);
                    small = true;
                    break;
                }
            }
            if (!small) {
                newStr += str.charAt(i);
            }
            small = false;
        }
        return newStr;

    } // String tipinde girilen ifadeyi büyük harfe çevirir.

    public static void karakterDizisiCizdir(String input) {
        char ch = ' ';
        int count = 1; // counter karakterin işlemini önündeki sayı kadar tekrar ettrimeyi sağlar.
        for (int i = 0; i < input.length(); i++) { // 1b2sn

            ch = input.charAt(i);
            if (ch >= 48 && ch < 58) { // Okunan karakter rakam ise counter' ı günceller.
                count = ch - 48;// ASCII 48 ile 57, 0 ile 9 rakamı demek. 48 çıkarılarak rakam elde ediliyor.
                continue;
            }

            switch (ch) {
                case 'b':
                    for (int k = 1; k <= count; k++) {
                        System.out.print(" ");
                    }
                    break;
                case 's':
                    for (int k = 1; k <= count; k++) {
                        System.out.print("*");
                    }
                    break;
                case 'n':
                    for (int k = 1; k <= count; k++) {
                        System.out.print("\n");
                    }
                    break;
                case 't':
                    for (int k = 1; k <= count; k++) {
                        System.out.print("   ");
                    }
                    break;
            }
            count = 1; // counter'ın başlangıç değerini korur.
        }
    } // Ekrana girilen b, s, n, t harflerinin tanımlanan fonksiyonlarını önünde sayı varsa sayı kadar, yoksa bir kere uygulayan ve ekrana yazdırır.
    
    public static String buyukHarfeCevir(String input) {
        String newStr = "", temp = "";
        newStr += myToUpperCase("" + input.charAt(0));
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == ' ') {
                newStr += "" + input.charAt(i);
                newStr += myToUpperCase("" + input.charAt(i + 1));
                i += 2;
            }
            newStr += "" + input.charAt(i);

        }
        return newStr + temp;

    }  // Kullanıcının girdiği kelimelerin baş harfini büyük harfe çevirir ve ekrana yazdırır.

    public static void harfCizdir(String karakter, int boyut) {
        if (karakter.equals("X")) {
            int count = 1;
            int spaceLength = boyut; //boyut değişkeninin değişmesini istemediğim için spaceLength değişkeni oluşturdum.
            for (int i = 0; i < (boyut - 1) / 2; i++) {
                System.out.print("*");
                for (int j = 0; j < spaceLength; j++) {
                    System.out.print(" ");
                }
                System.out.print("*\n");
                spaceLength -= 2;
                for (int k = 0; k < count; k++) {
                    System.out.print(" ");
                }
                count++;
            }
            count = ((boyut - 1) / 2) - 1;
            System.out.print(" *\n");
            spaceLength = 3;

            for (int i = 0; i < (boyut - 1) / 2; i++) {
                for (int k = 0; k < count; k++) {
                    System.out.print(" ");
                }
                count--;
                System.out.print("*");
                for (int j = 0; j < spaceLength; j++) {
                    System.out.print(" ");
                }
                System.out.print("*\n");
                spaceLength += 2;

            }
        }
        if (karakter.equals("Z")) {
            int j = 0;
            int k = boyut - 2;
            for (int i = 0; i < boyut; i++) {
                System.out.print("*");
            }
            for (int i = 0; i < boyut - 1; i++) {
                System.out.print("\n");

                for (j = 0; j < k; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                k--;
            }
            for (int i = 0; i < boyut - 1; i++) {
                System.out.print("*");
            }
        }
    } // kullanıcıdan x veya z harflerini alırsa, yine kullanıcının girdiği boyut değerine göre harfi ekrana çizdirir.

    public static void sifreleCoz(String input, int kaydirma_degeri) {
        input = myToUpperCase(input); 
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newStr = "";
        if (kaydirma_degeri >= 1 && kaydirma_degeri <= 25) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    newStr += " ";
                    continue;
                }
                int idxOfEncryptedCh = 0;
                for (int j = 0; j < alphabet.length(); j++) {

                    if (input.charAt(i) == alphabet.charAt(j)) {
                        idxOfEncryptedCh = j + kaydirma_degeri;
                        if (idxOfEncryptedCh > 25) {
                            idxOfEncryptedCh -= 26;
                        }
                        newStr += alphabet.charAt(idxOfEncryptedCh);
                        break;
                    }
                }
            }
        } else if (kaydirma_degeri >= -25 && kaydirma_degeri <= -1) {
            kaydirma_degeri += 26; // alphabet'te gezebilmek için pozitife çevirir.
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    newStr += " ";
                    continue;
                }
                int idxOfEncryptedCh = 0;
                for (int j = 0; j < alphabet.length(); j++) {

                    if (input.charAt(i) == alphabet.charAt(j)) {
                        idxOfEncryptedCh = j + kaydirma_degeri;
                        if (idxOfEncryptedCh > 25) {
                            idxOfEncryptedCh -= 26;
                        }
                        newStr += alphabet.charAt(idxOfEncryptedCh);
                        break;
                    }

                }
            }
        }

        System.out.println(newStr);
    } // Önce kaydırma değerini sorar. Kaydırma değeri [-25, -1] aralığındaysa program, çözmek istenilen metni ister. Kaydırma değeri [1, 25] aralığındaysa progam, şifrelenmek istenen değeri ister. böylece şifreleme ve şifre çözme işlemi gerçekleştirilir ve kullanıcıya gösterilir.

}
