package com.board.bdi.service;

import java.util.List;
import java.util.Map;

public interface BoardService 
{
	public List<Map<String,String>> boardSelect(List<Map<String,String>> boardlist);
	public Map<String,String> boardInsert(Map<String,String> bMap); 
}
