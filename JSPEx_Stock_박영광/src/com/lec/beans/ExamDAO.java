package com.lec.beans;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import common.D;

public class ExamDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public ExamDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end ExamDAO()
	
	
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close()
	
	// 트랜잭션
	
	// 새글작성
	public int insert(String name, String intro, int total) throws SQLException {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_EXAM_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, intro);
			pstmt.setInt(3, total);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		} // end try
		
		return cnt;
	} // end insert
	
	// 새글작성(DTO)
	public int insert(ExamDTO dto) throws SQLException {
		int cnt = 0;
		
		String name = dto.getName();
		String intro = dto.getIntro();
		int total = dto.getTotal();
		cnt = this.insert(name, intro, total);
		
		return cnt;
	} // end insert(DTO)
	
	// List
	public List<ExamDTO> buildList(ResultSet rs) throws SQLException{
		List<ExamDTO> list = new ArrayList<ExamDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("uid");
			String name = rs.getString("name");
			String intro = rs.getString("intro");
			if(intro == null) intro = "";
			int total = rs.getInt("total");
			LocalDateTime regDate = null;
			Timestamp timestamp = rs.getTimestamp("regdate");
			if(timestamp != null)
				regDate = timestamp.toLocalDateTime();
			
			ExamDTO dto = new ExamDTO(uid, name, intro, total, regDate);
			list.add(dto);
		} // end while
		return list;
	} // end builList()
	
	// 전체
	public List<ExamDTO> select() throws SQLException {
		List<ExamDTO> list = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_EXAM_SELECT);
			rs = pstmt.executeQuery();
			list = buildList(rs);
		} finally {
			close();
		}
		return list;
	}// end select()
	
	// uid select
	public List<ExamDTO> selectByUid(int uid) throws SQLException {
		List<ExamDTO> list = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_EXAM_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			list = buildList(rs);
		} finally {
			close();
		}
		return list;
	} // end selectByUid()
	
	public List<ExamDTO> readByUid(int uid) throws SQLException {
		List<ExamDTO> list = null;
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(D.SQL_EXAM_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			list = buildList(rs);
			
			conn.commit();
		} catch(SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		return list;
	} // end readByUid()

	// 수정
	public int update(int uid, String name, String intro, int total) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_EXAM_UPDATE);
			pstmt.setString(1, name);
			pstmt.setString(2, intro);
			pstmt.setInt(3, total);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		return cnt;
	} // end update
	
	public int deleteByUid(int uid) throws SQLException {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_EXAM_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		return cnt;
	} // deleteByUid()
	
	
} // end DAO
























