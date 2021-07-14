package com.lec.java.static03;

// Test 를  Singleton 으로 설계하기
public class Test {
	private int num;
	
	// singleton 패턴
	private Test() {  // 생성자 private 로
		System.out.println("Test() 생성");
		num = 100;
	}
	
	private static Test instance = null;
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test();  // 인스턴스 생성!
		}
		return instance;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}	
	
}





















