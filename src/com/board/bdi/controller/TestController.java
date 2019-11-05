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


public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI() + "(나는 TestController의 doGet)");
		List<Map<String,String>> list = new ArrayList<>();
		
//		for(int i = 1;i<=10;i++)
//		{
//			Map<String,String> map = new HashMap<>();
//			map.put("num",i+"");
//			map.put("name","I'm "+ i);
//			map.put("age","I'm "+ i);
//			list.add(map);
//		}
		
		Map<String,String> map = new HashMap<>();
		map.put("num",1+"");
		map.put("name","a");
		map.put("age","10");
		Map<String,String> map2 = new HashMap<>();
		map2.put("num",2+"");
		map2.put("name","b");
		map2.put("age","15");
		Map<String,String> map3 = new HashMap<>();
		map3.put("num",3+"");
		map3.put("name","c");
		map3.put("age","20");
		list.add(map);
		list.add(map2);
		list.add(map3);
		
		request.setAttribute("list", list);
		String path = "/views/test/test";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
