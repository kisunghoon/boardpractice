package practice.game369;

// feat. 최은아
public class Game369Main {
	public static void main(String[] args) {
		int i = 1;
		while(i <= 100) {
			int a = i / 10;
			int b = i % 10;
			
			if(a == 3 || a == 6 || a == 9 || b == 3 || b == 6 || b == 9) {
				System.out.printf("%-3s","*");
			 }else {
				 System.out.printf("%-3d",i);
			 }
			if(b == 0) {
				System.out.println();
			}
			i++;
		}
	}
}
