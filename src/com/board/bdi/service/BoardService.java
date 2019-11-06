package com.board.bdi.service;

import java.util.List;
import java.util.Map;

public interface BoardService 
{
	public List<Map<String,String>> boardSelect(List<Map<String,String>> boardlist);
	public Map<String,String> boardInsert(Map<String,String> bMap); 
	public Map<String,String> getBoard(Map<String,String> board);
	public Map<String,String> deleteBoard(Map<String,String> board);
	public Map<String,String> boardUpdate(Map<String,String> bMap); 
}
