package com.test.app.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;



public class BoardDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String board_insert="insert into board2(bid,title,writer,content,filepath) values((select nvl(max(bid),0)+1 from board2),?,?,?,?)";
	private String board_update="update board2 set title=?,content=? where bid=?";
	private String board_delete="delete board2 where bid=?";
	private String board_selectOne="select * from board2 where bid=?";
	private String board_selectAll="select * from board2 order by bid desc";

	private String selectW="select * from board2 where writer like '%'||?||'%' order by bid desc";
	private String selectT="select * from board2 where title like '%'||?||'%' order by bid desc";
	
	public void insertBoard(BoardVO vo) {
		jdbcTemplate.update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getFilepath());
	}
	public void updateBoard(BoardVO vo) {
		jdbcTemplate.update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());
	}
	public void deleteBoard(BoardVO vo) {
		jdbcTemplate.update(board_delete,vo.getBid());
	}
	public BoardVO selectOne(BoardVO vo) {
		Object[] obj= {vo.getBid()};
		return jdbcTemplate.queryForObject(board_selectOne,obj,new BoardRowMapper());
	}

	public List<BoardVO> selectAll(BoardVO vo) {
		String sql=board_selectAll;
		Object[] obj= {vo.getSearchContent()};
		if(vo.getSearchCondition().equals("title")) {
			sql=selectT;
		}
		else if(vo.getSearchCondition().equals("writer")) {
			sql=selectW;
		}
		return jdbcTemplate.query(sql,obj,new BoardRowMapper());
	}


}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setBdate(rs.getDate("bdate"));
		data.setBid(rs.getInt("bid"));
		data.setCnt(rs.getInt("cnt"));
		data.setContent(rs.getString("content"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setFilepath(rs.getString("filepath"));
		return data;
	}
	
	
}
