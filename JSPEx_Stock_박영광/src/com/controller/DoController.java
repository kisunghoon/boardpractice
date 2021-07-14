package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.exam.Command;
import com.command.exam.DeleteCommand;
import com.command.exam.ListCommand;
import com.command.exam.SelectCommand;
import com.command.exam.UpdateCommand;
import com.command.exam.ViewCommand;
import com.command.exam.WriteCommand;

@WebServlet("*.do")
public class DoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		Command command = null;
		String viewPage = null;
		
		switch(com) {
		case "/list.do":
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case "/write.do":
			viewPage = "write.jsp";
			break;
		case "/writeOk.do":
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "writeOk.jsp";
			break;
		case "/view.do":
			command = new ViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
			break;
		case "/update.do":
			command = new SelectCommand();
			command.execute(request, response);
			viewPage = "update.jsp";
			break;
		case "/updateOk.do":
			command = new UpdateCommand();
			command.execute(request, response);
			viewPage = "updateOk.jsp";
			break;
		case "/deleteOk.do":
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "deleteOk.jsp";
			break;
		} // end switch()
		
		if(viewPage != null) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		}
		
		
	} // end actionDo()
	

} // end DoController