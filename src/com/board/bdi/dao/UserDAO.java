package com.board.bdi.dao;

import java.util.Map;

public interface UserDAO 
{
	public Map<String,String> selectUser(Map<String,String> user);
	public Map<String,String> insertUser(Map<String,String> sMap);
}
