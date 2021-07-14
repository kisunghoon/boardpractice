package com.command.exam;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ExamDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		ExamDAO dao = new ExamDAO();
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			cnt = dao.deleteByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", cnt);
	}
}
