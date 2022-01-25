package com.test.app.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.app.board.BoardVO;

//BoardDAO의 한계: 중복코드多
//-> JDBCTemplate 사용
//		1) JdbcDAOSupport 클래스를 상속받아서 구현 -> 강제성부족
//		2) JdbcTemplate 클래스 <bean> 등록하여 DI ◀

public class BoardDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String board_insert="insert into board2(bid,title,writer,content) values((select nvl(max(bid),0)+1 from board2),?,?,?)";
	private String board_update="update board2 set title=?,content=? where bid=?";
	private String board_delete="delete board2 where bid=?";
	private String board_selectOne="select * from board2 where bid=?";
	private String board_selectAll="select * from board2 order by bid desc";

	/*
	 * @Autowired // 주로 멤버변수위에서 타입을 먼저보고 DI public void
	 * setSuperDataSource(DataSource dataSource) { super.setDataSource(dataSource);
	 * } // ds객체를 사용할수있는 코드 존재 // ds객체주입
	 */
	public void insertBoard(BoardVO vo) {
		System.out.println("insert수행중");
		jdbcTemplate.update(board_insert,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("update수행중");
		jdbcTemplate.update(board_update,vo.getTitle(),vo.getContent(),vo.getBid());
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("delete수행중");
		jdbcTemplate.update(board_delete,vo.getBid());
	}
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne수행중");
		Object[] obj= {vo.getBid()};
		return jdbcTemplate.queryForObject(board_selectOne,obj,new BoardRowMapper());
	}

	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("selectAll수행중");
		return jdbcTemplate.query(board_selectAll,new BoardRowMapper());
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
		return data;
	}

}
