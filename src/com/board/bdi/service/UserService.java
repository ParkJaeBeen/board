package com.board.bdi.service;

import java.util.List;
import java.util.Map;

public interface UserService 
{
	public Map<String,String> doLogin(String utId, String utPwd);
	public Map<String, String> signUp(String utName,String utId,String utPwd);
	public List<Map<String,String>> getUserList(Map<String,String> user);
}
