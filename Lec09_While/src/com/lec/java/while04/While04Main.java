package com.lec.java.while04;

public class While04Main {

	public static void main(String[] args) {
		System.out.println("while문 연습");
		
		// 1 ~ 100 수 중에서 2 와 7의 공배수만 출력
		int i = 1;
		while(i <= 100) {
			
			if(i % 2 == 0 && i % 7 == 0) {
				System.out.println(i);		
			}
			
			i++;
		}
		
	} // end main()

} // end class While04Main









