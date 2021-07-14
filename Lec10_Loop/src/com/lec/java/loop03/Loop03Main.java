package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		for(int dan = 2; dan < 10; dan++) {
			
			System.out.println("구구단 " + dan + "단");
			
			for(int mul = 1; mul < 10; mul++) {				
				System.out.println(dan + " x " + mul + " = " + (dan * mul));
			}
			
			System.out.println();			
		}
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int dan = 2;
		while(dan < 10) {
			
			int mul = 1;
			while(mul < 10) {
				System.out.println(dan + " x " + mul + " = " + (dan * mul));
				mul++;
			} // end while
			
			dan++;
		} // end while
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















