package com.kim.app.board;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Board2
 *
 */
@Entity
@Table(name="BOARD2")
public class Board2 {

   @Id	// 개체 무결성: 모든 테이블들은 pk로 설정된 칼럼을 가지고 있어야만한다!
   @GeneratedValue
   private int bid;
   private String title;
   private String writer;
   private String content;
   @Temporal(TemporalType.DATE)
   private Date bdate=new Date();
   private int cnt;
   public int getBid() {
      return bid;
   }
   public void setBid(int bid) {
      this.bid = bid;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public Date getBdate() {
      return bdate;
   }
   public void setBdate(Date bdate) {
      this.bdate = bdate;
   }
   public int getCnt() {
      return cnt;
   }
   public void setCnt(int cnt) {
      this.cnt = cnt;
   }
   
   @Override
   public String toString() {
      return "Board [bid=" + bid + ", title=" + title + ", writer=" + writer + ", content=" + content + ", bdate="
            + bdate + ", cnt=" + cnt + "]";
   }

}