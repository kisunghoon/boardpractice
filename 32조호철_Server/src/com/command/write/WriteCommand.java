package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// price가 null 이면 기본값 0
		int price = 0;
		if(request.getParameter("price") == "") {
			price = 0;
		} else {
			price = Integer.parseInt(request.getParameter("price"));
		}
		
		// 유효성 체크  null 이거나, 빈문자열이면 이전화면으로 돌아가기
		if(subject != null && subject.trim().length() > 0) {
			try {
				cnt = dao.insert(subject, content, price);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		request.setAttribute("result", cnt);
		}
	}

}
