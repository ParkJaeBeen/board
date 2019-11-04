package com.board.bdi.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.bdi.service.UserService;
import com.board.bdi.service.impl.UserServiceImpl;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String utId = request.getParameter("ut_id");		//login.jsp 의 form 이 post 방식이므로 doPost 가 실행request.getParameter() < () 안의 값은 login.jsp 에 input name 과 동일해야함(대소문자까지)
		String utPwd = request.getParameter("ut_pwd");	//5.doPost 에 있는 getParameter로 login 에 input 된 utId,utPwd 가 각 변수에 대입됨
		String utName = request.getParameter("ut_name");
		String uri = request.getRequestURI();		//uri 주소를 받아와서 변수명 uri 에 대입
		String cmd = uri.substring(6);				//변수 uri 의 6번째 글자부터 받아와서 cmd 에 대입
		String path = "/views/msg";	//views 폴더의 msg.jsp 로 가기
		if("login".equals(cmd))
		{
			Map<String,String> user = us.doLogin(utId, utPwd); //6.대입된 변수를 통해 UserServiceImpl 의 doLogin method의 파라메터에 대입된 변수들을 저장 후 호출 
			if(user != null) 	
			{
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user);
				request.setAttribute("msg","로그인 성공!");
				request.setAttribute("url", "/views/index");
			}
			else
			{
				request.setAttribute("msg","로그인 실패!");
				request.setAttribute("url", "/views/login");
			}
		}
		else if("signup".equals(cmd))
		{
			Map<String,String> bMap = us.signUp(utName,utId,utPwd);
			if(bMap != null)
			{
				request.setAttribute("msg", "저장완료! 로그인해주세요!");
				request.setAttribute("url", "/views/index");
			}
			else
			{
				request.setAttribute("msg", "저장실패!");
				request.setAttribute("url", "/user/signup"); 
			}
		}
		else if("logout".equals(cmd))
		{
			
		}
		else if("update".equals(cmd))
		{
			
		}
		else if("delete".equals(cmd))
		{
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);	//21.String path 변수에 /views/* 형식을 지정했으니 URIController 로 가게 됨
		rd.forward(request, response);
		//doGet(request, response);
	}

}
