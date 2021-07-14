package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.Command;
import com.command.write.DeleteCommand;
import com.command.write.ListCommand;
import com.command.write.SelectCommand;
import com.command.write.UpdateCommand;
import com.command.write.WriteCommand;
import com.command.write.viewCommand;

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
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");  // 한글인코딩
		
		String uri = request.getRequestURI();   
		String conPath = request.getContextPath();  
		String com = uri.substring(conPath.length());   
		
		Command command = null;  // 어떠한 로직을 수행할지 결정
		String viewPage = null;  // 어떠한 페이지(view) 에 보여줄지 결정
		
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
			command = new viewCommand();
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
		} // end switch
		
		// 위에서 결정된 페이지 (viewPage) 로 forward 해줌
		if(viewPage != null) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		}
		
	} // end actionDo()

}
