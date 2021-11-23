package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="bang";
		String password="1234";
	
//		System.out.println("찾고싶은 번호 입려:");
		System.out.println("찾고싶은 이름 입력 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
//		String num = sc.next();
		String sql = "select * from test where b like '%"+name+"%'";
		/*
		1. JDBC 드라이버를 JVM에 로드 
		2. DB에 연결
		3. DBMS에 데이터를 read, write == SQL문을 수행
		4. DB연결 해제
		 */
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
//			System.out.println("JDBC 드라이버 로드 성공!");
			
			conn=DriverManager.getConnection(url, user, password);
//			System.out.println("오라클에 연결 성공!");
			
			stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//이터레이터와 유사한 rs
			int cnt = 0;
			while(rs.next()) {
				System.out.println(rs.getInt("a")+":"+rs.getString("b"));
				cnt++;
			}
			if(cnt==0) {
				System.out.println("없는 데이터입니다!");
			}
			rs.close(); 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

