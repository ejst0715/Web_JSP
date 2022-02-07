package com.test.app.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;

public class BoardDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	private String board_insert="insert into board2(bid,title,writer,content,filepath) values((select nvl(max(bid),0)+1 from board2),?,?,?,?)";
	private String board_update="update board2 set title=?,content=? where bid=?";
	private String board_delete="delete board2 where bid=?";
	private String board_selectOne="select * from board2 where bid=?";
	private String board_selectAll="select * from board2 order by bid desc";
	
	private String selectW="select * from board2 where writer like '%'||?||'%' order by bid desc";
	private String selectT="select * from board2 where title like '%'||?||'%' order by bid desc";

	public void insertBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(board_insert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getFilepath());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
	}
	public void updateBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(board_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public void deleteBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(board_delete);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public BoardVO selectOne(BoardVO vo) {
		BoardVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(board_selectOne);
			pstmt.setInt(1, vo.getBid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBdate(rs.getDate("bdate"));
				data.setBid(rs.getInt("bid"));
				data.setCnt(rs.getInt("cnt"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setFilepath(rs.getString("filepath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, conn);
		}	
		return data;
	}
	   public List<BoardVO> selectAll(BoardVO vo) {
		      List<BoardVO> datas=new ArrayList<BoardVO>();
		      conn=JDBCUtil.connect();
		      try {
		         if(vo.getSearchCondition().equals("title")) {
		            // 제목으로 검색하는 로직
		            pstmt=conn.prepareStatement(selectT);
		         }
		         else {
		            pstmt=conn.prepareStatement(selectW);
		         }
		         pstmt.setString(1, vo.getSearchContent());
		         rs=pstmt.executeQuery();
		         while(rs.next()) {
		            BoardVO data=new BoardVO();
		            data.setBdate(rs.getDate("bdate"));
		            data.setBid(rs.getInt("bid"));
		            data.setCnt(rs.getInt("cnt"));
		            data.setContent(rs.getString("content"));
		            data.setTitle(rs.getString("title"));
		            data.setWriter(rs.getString("writer"));            
		            datas.add(data);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         JDBCUtil.disconnect(rs, pstmt, conn);
		      }   
		      return datas;
		   }
		}
