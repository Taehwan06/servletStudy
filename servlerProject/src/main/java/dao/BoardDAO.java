package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;
import vo.BoardVO;

public class BoardDAO {

	public ArrayList<BoardVO> list() {
		
		ArrayList<BoardVO> alist = new ArrayList<BoardVO>();
		
		//DB연결
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "select * from board order by bidx desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBidx(rs.getInt("bidx"));
				vo.setTitle(rs.getString("bsubject"));
				vo.setWriter(rs.getString("bwriter"));
				alist.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
		
		return alist;
		
	}
	
	public BoardVO selectOne(String bidx) {
		BoardVO vo = new BoardVO();
		
		//DB연결
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "select * from board where bidx="+bidx;
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setBidx(rs.getInt("bidx"));
				vo.setTitle(rs.getString("bsubject"));
				vo.setWriter(rs.getString("bwriter"));
				vo.setContent(rs.getString("bcontent"));
				vo.setHit(rs.getInt("bhit"));
				vo.setWdate(rs.getString("bwdate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
		
		return vo;
	}
	
	public int update(BoardVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "update board set "
					   + " bsubject=? "
					   + ", bcontent=? "
					   + " where bidx=? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getBidx());
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn);
		}
		
		return result;
	}
	
	public int insert(BoardVO vo) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "insert into board( "
					   + " bidx, bsubject, bwriter, bcontent, midx "
					   + " ) values("
					   + " bidx_seq.nextval, ?, ?, ?, 3 "
					   + " )";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn);
		}
		
		return result;
	}
	
	public void delete(String bidx) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "delete from board where bidx = ? ";
					   
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bidx);
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn);
		}
	}
	
}
