package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	
	@Override
	public Map<String,String> doLogin(String utId, String utPwd) {	//7.UserController 에서 대입된 두 변수가 String utId, String utPwd 담겨있음
		Map<String,String> user = new HashMap<>();		//8.user 라는 해쉬맵을 새로 만들고,
		user.put("ut_id",utId);							//9.그 안에 "utId","utPwd" 키에 UserController 에서 대입된 두 변수값을 value 로 저장 
		user.put("ut_pwd",utPwd);
		return udao.selectUser(user);					//10.그 후 값이 들어간 user 라는 맵을 UserDaoImpl 에 있는 selectUser() 의 파라메터에 대입
		
								//20.user 에 값이 있으니 true 를 UserController 에 return 시킴(user 가 값이 있을 때 true)
	}
	 
	public Map<String,String> signUp(String utName,String utId,String utPwd)
	{
		Map<String,String> sMap = new HashMap<>();
		sMap.put("ut_name", utName);
		sMap.put("ut_id", utId);
		sMap.put("ut_pwd", utPwd);
		
		return udao.insertUser(sMap);
	}
}
