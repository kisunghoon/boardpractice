package com.command.write;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class viewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		List<WriteDTO> list = null;
		int uid = Integer.parseInt(request.getParameter("uid")); // 매개변수 검증
		
		try {
			list = dao.readByUid(uid);
			request.setAttribute("list", list);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
