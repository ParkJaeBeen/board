package com.board.bdi.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO 
{
	public List<Map<String, String>> boardSelection(Map<String,String> boardlist); 
	public int boardInsertOk(Map<String, String> btMap);
}
