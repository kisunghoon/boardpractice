package com.command.exam;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ExamDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		ExamDAO dao = new ExamDAO();
		
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		int total = Integer.parseInt(request.getParameter("total"));
		
		try {
			cnt = dao.insert(name, intro, total);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", cnt);
	}

}
