package com.kim.app.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {
   public static void main(String[] args) {
      // EntityManager 생성하기
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAProject");
      EntityManager em=emf.createEntityManager();

      // Transaction 생성하기
      EntityTransaction etx=em.getTransaction();

      etx.begin();
      try {
         Board2 board=new Board2();
         board.setContent("JPA 실습중입니다! :D");
         board.setTitle("JPA 제목");
         board.setWriter("JPA 작성자");

         em.persist(board); // insert
         
         etx.commit();
         
         String jpql="select b from Board2 b order by b.bid desc"; // SQL의 표준언어로 작성하는것이 특징!
         List<Board2> datas=em.createQuery(jpql).getResultList();
         for(Board2 v:datas) {
            System.out.println(v);
         }
      }catch(Exception e) {
         e.printStackTrace();
         etx.rollback();
      }finally {
         em.close();
         emf.close();
      }
   }
}