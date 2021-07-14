package com.command.exam;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ExamDAO;
import com.lec.beans.ExamDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ExamDAO dao = new ExamDAO();
		List<ExamDTO> list = null;
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			list = dao.readByUid(uid);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
