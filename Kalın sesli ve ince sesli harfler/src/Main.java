import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String letter="";
		boolean kalınMı=false;
		String [] kalın={"a", "ı", "o", "u"};
		String [] ince= {"e", "i", "ö", "ü"};

		System.out.println("Lütfen bir harf giriniz");
		letter=scan.nextLine();
		letter.toLowerCase();
		for(int i=0; i<4; i++) {
			if(letter.equals(kalın[i])) {
				kalınMı=true;
				break;
			}
			else if(letter.equals(ince[i])) {
				break;
			}
		}
		
		if(kalınMı) {
			System.out.println("Harf kalın seslidir");
		}
		else if(kalınMı==false) {
			System.out.println("Harf ince seslidir");
		}
		
		scan.close();
	}

}
