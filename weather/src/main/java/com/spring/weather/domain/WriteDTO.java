package com.spring.weather.domain;

public class WriteDTO {

	private int uid;
	private String city;
	private double temp;
	private String weather;
	
	public WriteDTO() {
		super();
	}

	public WriteDTO(int uid, String city, double temp, String weather) {
		super();
		this.uid = uid;
		this.city = city;
		this.temp = temp;
		this.weather = weather;
	}

	public int getW_uid() {
		return uid;
	}

	public void setW_uid(int uid) {
		this.uid = uid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "WriteDTO [w_uid=" + uid + ", city=" + city + ", temp=" + temp + ", weather=" + weather + "]";
	}
	
	
}
