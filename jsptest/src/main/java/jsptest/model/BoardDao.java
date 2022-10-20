package jsptest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	

	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsptest",
					"root",
					"1234"
					);
		} catch (Exception e) {System.out.println("DB연결오류 " + e);}
		
		
	}
	
	// 글작성
	public boolean write(BoardDto dto) {
		String sql="insert into board(btitle, bcontent, bwriter, bpassword) values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBwriter());
			ps.setString(4, dto.getBpassword());
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("글 작성 오류 " + e);} return false;
	}
	
	// 모든 글 출력
	public ArrayList<BoardDto> getlist(){
		String sql="select * from board";
		ArrayList<BoardDto> list= new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDto dto=new BoardDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				list.add(dto);
				System.out.println(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("모든 글 출력 오류 " + e);}return list;
	}
	
	// 개별 글 조회
	public BoardDto getboard(int bno) {
		String sql="select btitle, bcontent, bwriter from board where bno=?";
		BoardDto dto= null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto=new BoardDto();
				dto.setBtitle(rs.getString(1));
				dto.setBcontent(rs.getString(2));
				dto.setBwriter(rs.getString(3));
				return dto;
			}
		} catch (Exception e) {System.out.println("개별 글 조회 오류 " + e);}return dto;
	}
	
	
	
		
}
