package com.lec.java.oop03;

public class HybridCar extends Car{
	private int electricity;

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}
	
	@Override
	public String toString() {
		String out = "--- HybridCar 정보 ---\n"
				+ "speed: " + getSpeed() + "\n"
				+ "oil: " + getOil() + "\n"
				+ "electricity: " + electricity
				;
		return out;
	}

}









