package com.board.bdi.test.Impl;

import java.util.HashMap;
import java.util.Map;

import com.board.bdi.test.BoardDAO;
import com.board.bdi.test.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	@Override
	public Map<String, String> insertBoard(Map<String, String> board) 
	{
		Map<String,String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		if(result == 1)
		{
			rMap.put("msg","성공");
		}
		else
		{
			rMap.put("msg","실패");
		}
		return rMap;
	}
	
	public static void main(String[] args)
	{
		BoardService bs = new BoardServiceImpl();
		Map<String,String> board = new HashMap<>();
		board.put("bt_title","title");
		board.put("bt_content","content");
		board.put("ut_num","1");
		Map<String,String> rMap = bs.insertBoard(board);
		System.out.println(rMap);
	}

}
