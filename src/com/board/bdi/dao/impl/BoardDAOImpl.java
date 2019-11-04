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

import com.board.bdi.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Map<String, String>> boardSelection(Map<String,String> boardlist) 
	{
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "select * from board_table order by bt_num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String,String>> boardList = new ArrayList<>();
			while(rs.next())
			{
				Map<String, String> boardMap = new HashMap<>();
				boardMap.put("bt_num",rs.getString("bt_num"));
				boardMap.put("bt_title",rs.getString("bt_title"));
				boardMap.put("bt_content",rs.getString("bt_content"));
				boardMap.put("ut_num",rs.getString("ut_num"));
				boardMap.put("credat",rs.getString("credat"));
				boardMap.put("cretim",rs.getString("cretim"));
				boardMap.put("moddat",rs.getString("moddat"));
				boardMap.put("modtim",rs.getString("modtim"));
				boardList.add(boardMap);
			}
			return boardList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			}catch (SQLException sqle) {
					sqle.printStackTrace();
				}
		}
		return null;

	}
	
	
	public int boardInsertOk(Map<String,String> btMap)
	{
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "insert into board_table(bt_num,bt_title,bt_content,ut_num,credat,cretim,moddat,modtim) ";
			sql += "values(seq_bt_num.nextval,?,?,?,to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'),to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, btMap.get("bt_title"));
			ps.setString(2, btMap.get("bt_content"));
			ps.setString(3, btMap.get("ut_num"));

			return ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			}catch (SQLException sqle) {
					sqle.printStackTrace();
				}
		}
		return 0;
	}
	public static void main(String[] args)
	{
		BoardDAO bdao = new BoardDAOImpl();
		Map<String,String> board = new HashMap<>();
		board.put("bt_title","test");
		board.put("bt_content","test");
		board.put("ut_num","1");
		
		int result = bdao.boardInsertOk(board);
		if(result == 1)
		{
			System.out.println("save");
		}
		else
		{
			System.out.println("not save");
		}
	}
}
