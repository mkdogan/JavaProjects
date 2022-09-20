import java.util.Scanner;
public class Asal_sayi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scan= new Scanner(System.in);
	int sayi= -1;
	
		System.out.println("Çıkış için sıfır, bir veya eksili bir sayı giriniz");
		
		do {
			System.out.println("Lütfen bir sayı giriniz");
			sayi= scan.nextInt();
			
			if (sayi<=0|| sayi==1) {
				System.out.println("Yine bekleriz...");
				return;
			}
			
			if (asalMi(sayi)) {
				System.out.println("Sayı asaldır.");
			}
			else if (asalMi(sayi)==false) {
				System.out.println("Sayı asal değildir");
			}
			else if(sayi<1) {
				System.out.println("Sayı asal değildir");
			}
		} while(sayi!=0);	
		System.out.println("Yine bekleriz...");
	}
	
	private static boolean asalMi (int number) {
		
		for (int i=2; i<number; i++) {
			if (number%i==0) {
				return false;
			}
		}
		return true;
	}	
}


