package com.test.app.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO4 {

	@PersistenceContext              //autowired랑 같지만 persistence.xml도 봐야하기때문에.   em객체를 주입받아서("DI") 아래의 CRUD 메서드를 사용할수있게된다!
   private EntityManager em;
   
   public void insertBoard(BoardVO vo) {
      System.out.println("JPA INSERT");
      em.persist(vo);
   }
   public void updateBoard(BoardVO vo) {
      System.out.println("JPA UPDATE");
      em.merge(vo);
   }
   public void deleteBoard(BoardVO vo) {
      System.out.println("JPA DELETE");
      em.remove(vo);
   }
   public List<BoardVO> selectAll(BoardVO vo){
      System.out.println("JPA SELECT ALL");
      return em.createQuery("select b from BoardVO b order by b.bid desc").getResultList();
   }
   public BoardVO selectOne(BoardVO vo) {
      System.out.println("JPA SELECT ONE");
      return (BoardVO)em.find(BoardVO.class, vo.getBid());
   }
   
}
