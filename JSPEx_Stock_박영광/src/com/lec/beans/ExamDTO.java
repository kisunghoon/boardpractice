package com.lec.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExamDTO {
	private int uid;
	private String name;
	private String intro;
	private int total;
	private LocalDateTime regDate;
	
	
	public ExamDTO() {
		super();
	}

	public ExamDTO(int uid, String name, String intro, int total, LocalDateTime regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.intro = intro;
		this.total = total;
		this.regDate = regDate;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	public String getRegDateTime() {
		if(this.regDate == null) return "";
		return this.regDate.format(DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:ss"));
	}
	
	@Override
	public String toString() {
		return String.format("ExamDTO] %d : %s : %s : %d : %s", uid, name, intro, total, regDate);
	}
	
	
}
