package com.board.bdi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService 
{
	public BoardDAO bd = new BoardDAOImpl();
	@Override
	public List<Map<String, String>> boardSelect(List<Map<String,String>> boardlist) 
	{
		Map<String, String> boardList = new HashMap<>();
		return bd.boardSelection(boardList);
	} 
	
	public Map<String,String> boardInsert(Map<String,String> bMap)
	{
		int rs = bd.boardInsertOk(bMap);
		if(rs == 1)
		{
			return bMap;
		}
		return null;
	}
	
	public Map<String,String> getBoard(Map<String,String> board)
	{
		return bd.getBoard(board);
	}
	
	public Map<String,String> deleteBoard(Map<String,String> board)
	{
		int rs = bd.deleteBoard(board);
		if(rs == 1)
		{
			return board;
		}
		return null;
	}
	
	public Map<String,String> boardUpdate(Map<String,String> bMap)
	{
		Map<String,String> rMap = new HashMap<>();
		int rs = bd.boardUpdateOk(bMap);
		if(rs == 1)
		{
			rMap.put("msg","수정완료!");
			rMap.put("url","/board/list");
		}
		else
		{
			rMap.put("msg","수정실패!");
			rMap.put("url","/board/update");
		}
		return rMap;
	}
	
//	public static void main(String[] args)
//	{
//		BoardService bs = new BoardServiceImpl();
//		Map<String,String> btMap = new HashMap<>();
//		btMap.put("bt_title","title");
//		btMap.put("bt_content","content");
//		btMap.put("ut_num","1");
//		Map<String,String> rMap = bs.boardInsert(btMap);
//		System.out.println(rMap);
//	}
}
