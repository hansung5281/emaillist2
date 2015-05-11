package com.sds.icto.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.action.FormAction;
import com.sds.icto.action.IndexAction;
import com.sds.icto.action.InsertAction;
import com.sds.icto.web.Action;


@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			String a = request.getParameter("a");
			
			Action action = null;
				
			if("form".equals(a)){
				action = new FormAction();
				action.execute(request, response);
			}else if("insert".equals(a)){
				action = new InsertAction();
				action.execute(request, response);
			}else{
				action = new IndexAction();
				action.execute(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
