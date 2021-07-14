package com.lec.java.casting;
/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */
public class CastingMain {

	public static void main(String[] args) {
		System.out.println("Casting");
		
		// 명시적 형변환
		byte num5 = (byte)513;
		System.out.println("num5 = " + num5);  // 주의! 자료 손실 발생!
		
		byte num6 = 10;
		int n = 10;
		//num6 = n;  // int 변수 -->  byte : 묵시적 형변환 안됨!!
		num6 = (byte)n;
		
		double avg1 = (99 + 88 + 78) / 3;
		System.out.println("avg1 = " + avg1);
		
		double avg2 = (double)(99 + 88 + 78) / 3;
		System.out.println("avg2 = " + avg2);

	} // end main

} // end class


















