package com.board.bdi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URIController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PREFIX = "/WEB-INF";
    private static final String SUFFIX = ".jsp";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	//23.String uri 는 UserController 에 지정되어 있는 /views/msg 
		uri = PREFIX + uri + SUFFIX;			//24. /views/msg 에 /WEB-INF,.jsp 추가 /WEB-INF/views/msg.jsp 가 됨
		System.out.println(uri + "(내가나온다는건 URIController의 doGet을 탄다는 것)");
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	//22. login 에서 post 방식이기 때문에 doPost 를 실행시 doGet메소드 호출
	}

}
