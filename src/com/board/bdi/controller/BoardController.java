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

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;
import com.board.bdi.service.impl.BoardServiceImpl;


public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BoardService bs = new BoardServiceImpl();
	public BoardDAO bd = new BoardDAOImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		System.out.println(cmd + "(내가 나온다는건 BoardController의 doget메소드를 탄다는것)"); 
		String path = "/views/board/list";
		List<Map<String,String>> bb = new ArrayList<>();
		
		Map<String,String> board = new HashMap<>();
		if("list".equals(cmd))
		{
			request.setAttribute("list", bs.boardSelect(bb));
		}
		else if("content".equals(cmd))
		{
			path = "/views/board/content";
			board.put("bt_num",request.getParameter("bt_num"));
			board = bs.getBoard(board);
			request.setAttribute("board", board);
		}
		else if("delete".equals(cmd))
		{
			path = "/views/msg";
			board.put("bt_num", request.getParameter("bt_num"));
			board = bs.deleteBoard(board);
			request.setAttribute("msg", "삭제완료!");
			request.setAttribute("url", "/board/list");
		}
		else if("update".equals(cmd))
		{
			path="/views/board/update";
			board.put("bt_num",request.getParameter("bt_num"));
			board = bs.getBoard(board);
			request.setAttribute("board", board);
		}
		else
		{
			doPost(request,response);
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		System.out.println(cmd + "(내가 나온다는건 BoardController의 dopost메소드를 탄다는것)"); 
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
		else if("updateok".equals(cmd))
		{
			bMap.put("bt_title",request.getParameter("bt_title"));
			bMap.put("bt_content",request.getParameter("bt_content"));
			bMap.put("bt_num",request.getParameter("bt_num"));
			Map<String,String> rMap = bs.boardUpdate(bMap);
			request.setAttribute("msg", rMap.get("msg"));
			request.setAttribute("url", rMap.get("url"));
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
