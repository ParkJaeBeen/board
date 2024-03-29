package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public Map<String, String> selectUser(Map<String, String> user) {	//11.UserServiceImpl 에서 만들어진 user 라는 해쉬맵이 대입됨
		try {
			con = DriverManager.getConnection(URL,ID,PWD);	//12.커넥션을 하고(커넥션이 잘 이루어지는지)
			String sql = "select * from user_table where ut_id=? and ut_pwd=?";	//13.sql문으로 쿼리박스에서 user_table 의 ut_id,ut_pwd select
			ps = con.prepareStatement(sql);			//14.prepareStatement 에 위의 sql 기억시키고
			ps.setString(1, user.get("ut_id"));		//15.UserServiceImpl 에서 만들어진 user 라는 해쉬맵의 "utId","utPwd" 키에 있는 value를 ? 에 대입
			ps.setString(2, user.get("ut_pwd"));
			rs = ps.executeQuery();
			if(rs.next())	//16.resultSet 이 있을 때(list 에 받아올 다음 값이 있을 때) rs.next() = 데이터베이스의 리스트 에 다음 값이 있다면 return true
			{
				user.put("ut_num",rs.getString("ut_num"));	//17.user 의 "utNum","credat" 키를 새로 put 하고 rs.getString으로 데이터베이스에 있는 값인 
				user.put("credat",rs.getString("credat"));	//18."ut_num","credat" 을 value 로 지정
				user.put("ut_name", rs.getString("ut_name"));
				return user;								//19.그 후 user 를 리턴하여 doLogin() 으로 이동
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return null;
	}
	
	
	public Map<String, String> insertUser(Map<String,String> sMap)
	{
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "insert into user_table(ut_num,ut_name,ut_id,ut_pwd,credat,cretim,moddat,modtim) ";
			sql += "values(seq_ut_num.nextval,?,?,?,to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'),to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, sMap.get("ut_name"));
			ps.setString(2, sMap.get("ut_id"));
			ps.setString(3, sMap.get("ut_pwd"));
			
			if(ps.executeUpdate() == 1)
			{
				Map<String,String> rMap = new HashMap<String,String>();
				rMap.put("msg", sMap.get("ut_name") + "님 회원가입 완료");
				rMap.put("url","/views/user/login");
				return rMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
				{
					rs.close();
				}
				if(ps != null)
				{
					ps.close();
				}
				if(con != null)
				{
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	public List<Map<String, String>> selectUserList(Map<String, String> user)
	{
		List<Map<String, String>> userList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "select * from user_table where 1=1 ";
			if(user.get("ut_id") !=null)
			{
				sql += "and ut_id=?";
			}
			if(user.get("ut_name") != null)
			{
				sql += "and ut_name=?";
			}
			if(user.get("ut_num") != null)
			{
				sql += "and ut_num=?";
			}
//			if(user.get("ut_id") !=null || user.get("ut_num") !=null || user.get("ut_name") !=null)
//			{
//				sql += "where ";
//			}
			sql += " order by ut_num desc";
			ps = con.prepareStatement(sql);
			if(user.get("ut_id") != null && user.get("ut_name") == null && user.get("ut_num") == null)
			{
				ps.setString(1, user.get("ut_id"));
			}
			else if(user.get("ut_id") == null && user.get("ut_name") != null && user.get("ut_num") == null)
			{
				ps.setString(1, user.get("ut_name"));
			}
			else if(user.get("ut_id") == null && user.get("ut_name") == null && user.get("ut_num") != null)
			{
				ps.setString(1, user.get("ut_num"));
			}
			else if(user.get("ut_id") != null && user.get("ut_name") != null && user.get("ut_num") == null)
			{
				ps.setString(1, user.get("ut_id"));
				ps.setString(2, user.get("ut_name"));
			}
			else if(user.get("ut_id") != null && user.get("ut_name") == null && user.get("ut_num") != null)
			{
				ps.setString(1, user.get("ut_id"));
				ps.setString(2, user.get("ut_num"));
			}
			else if(user.get("ut_id") == null && user.get("ut_name") != null && user.get("ut_num") != null)
			{
				ps.setString(1, user.get("ut_name"));
				ps.setString(2, user.get("ut_num"));
			}
			else
			{
				ps.setString(1, user.get("ut_id"));
				ps.setString(2, user.get("ut_name"));
				ps.setString(3, user.get("ut_num"));
			}
			rs = ps.executeQuery();
			while(rs.next())
			{
				Map<String,String> map = new HashMap<>();
				map.put("ut_num",rs.getString("ut_num"));
				map.put("ut_id",rs.getString("ut_id"));
				map.put("ut_name",rs.getString("ut_name"));
				map.put("credat",rs.getString("credat"));
				map.put("cretim",rs.getString("cretim"));
				map.put("moddat",rs.getString("moddat"));
				map.put("modtim",rs.getString("modtim"));
				map.put("active",rs.getString("active"));
				userList.add(map);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
				{
					rs.close();
				}
				if(ps != null)
				{
					ps.close();
				}
				if(con != null)
				{
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
//	public static void main(String[] args)	//데이터베이스에 있는 테이블에서 값이 잘 받아지는지
//	{
//		UserDAO udao = new UserDAOImpl();
//		Map<String,String> user = new HashMap<>();
//		user.put("ut_id","idfive");
//		user.put("ut_pwd","12345"); 
//		user = udao.selectUser(user);
//		System.out.println(user);
//	}

}
