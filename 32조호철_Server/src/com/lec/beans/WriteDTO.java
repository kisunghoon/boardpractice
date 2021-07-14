package com.lec.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteDTO {
	private int uid;  // bk_uid
	private String subject;  // bk_subject
	private String content;  // bk_content
	private int price;  // bk_price
	private int viewCnt;  // bk_viewcnt
	private LocalDateTime regDate;  // bk_regdate
	
	public WriteDTO(int uid, String subject, String content, int price, int viewCnt, LocalDateTime regDate) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.price = price;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	
	public String getRegDateTime() {
		if(this.regDate == null) return "";
		return this.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return String.format("WriteDTO] %d : %s : %s : %d : %d : %s",
				uid, subject, content, price, viewCnt, regDate);
	}
	
	
}
