package com.board.bdi.test.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.board.bdi.test.BoardDAO;

public class BoardDAOImpl implements BoardDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int insertBoard(Map<String,String> board) 
	{
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			String sql = "insert into board_table(bt_num,bt_title,bt_content,ut_num,credat,cretim,moddat,modtim) ";
			sql += "values(seq_bt_num.nextval,?,?,?,to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'),to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("bt_title"));
			ps.setString(2, board.get("bt_content"));
			ps.setString(3, board.get("ut_num"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
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
		
		int result = bdao.insertBoard(board);
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
