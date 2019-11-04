package com.board.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.bdi.service.BoardService;
import com.board.bdi.service.impl.BoardServiceImpl;


public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BoardService bs = new BoardServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		System.out.println(cmd); 
		String path = "/views/board/list";
		List<Map<String,String>> bb = new ArrayList<>();
		if("list".equals(cmd))
		{
			request.setAttribute("list", bs.boardSelect(bb));
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		else
		{
			doPost(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/msg";
		Map<String,String> bMap = new HashMap<>();
		if("insert".equals(cmd))
		{
			bMap.put("bt_title",request.getParameter("bt_title"));
			bMap.put("bt_content",request.getParameter("bt_content"));
			
			HttpSession hs = request.getSession();
			Map<String,String> user = (Map<String,String>)hs.getAttribute("user");
			bMap.put("ut_num",user.get("ut_num"));
			Map<String,String> nMap = bs.boardInsert(bMap);
			
			request.setAttribute("msg", "작성완료!");
			request.setAttribute("url", "/board/list");
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
