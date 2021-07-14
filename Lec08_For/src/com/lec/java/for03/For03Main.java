package com.lec.java.for03;

public class For03Main {

	public static void main(String[] args) {
		System.out.println("for 연습");
		
		// 1 ~ 100 사이의 수 중에서 13의 배수만 출력하기
		for(int i = 1; i <= 100; i++) {
			if(i % 13 == 0)   // 블럭 문장이 하나만 있는 경우는 블럭 {} 안해도 됨
				System.out.println(i);
		}

	} // end main()

} // end class For03Main




