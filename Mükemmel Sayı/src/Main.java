import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int num, sum=0;//6--> 1, 2, 3
		boolean mükemmel=false;
		Scanner scan=new Scanner(System.in);
		System.out.println("Bir sayı giriniz");
		num=scan.nextInt();
		for(int i=1; i<num;i++) {
			if (num%i==0) {
				sum=sum+i;
				if(sum==num) {
					mükemmel=true;
				}
			}
		}
		if(mükemmel) {
			System.out.println("Sayı mükemmel bir sayıdır");
		}
		else if (mükemmel==false) {
			System.out.println("Sayı bir mükemmel sayı değildir");
		}
		scan.close();
	}
}
