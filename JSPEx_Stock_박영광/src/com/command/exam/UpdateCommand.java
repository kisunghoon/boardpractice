package com.command.exam;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ExamDAO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		ExamDAO dao = new ExamDAO();
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		int total = Integer.parseInt(request.getParameter("total"));
		
		if(name != null && name.trim().length() > 0 || total < 0) {
			try {
				cnt = dao.update(uid, name, intro, total);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end if
		
		request.setAttribute("result", cnt);
	}
}
