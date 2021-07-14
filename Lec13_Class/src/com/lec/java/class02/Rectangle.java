package com.lec.java.class02;

public class Rectangle {

	// 속성: 멤버변수
	private double width; // 너비
	private double height; // 높이
	
	// 생성자
	// 1)기본생성자
	public Rectangle() {
		width = 100;
		height = 100;
	}
	
	// 2)매개변수 받는 생성자
	public Rectangle(double w, double h) {
		this.width = w;
		height = h;
	}
	
	
	// 동작: 메소드
	
	// 사각형의 둘레
	public double calcPerimeter() {
		return (width + height) * 2;
	}
	
	// 사각형의 넓이
	public double calcArea() {
		return width * height;
	}
}















