package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

	//main 실행전에 초기화하는것
	static {
		
		//이렇게만 작성하면 heap에서 삭제가 될수있다.
		//new OracleDriver();
		
		
		//웹프로그램에서는 안해도 된다. (톰켓?서버에서 해준다.)
		//ojdbc60.jar later에서도 안해도된다.
		//클래스를 미리 메모리에 Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// 1. Connection을 얻어오기
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="test";
		String password="test";
		Connection connt = DriverManager.getConnection(url,username,password);
		
		System.out.println("------success connection--------");
		
		// 2. Statement : SQL 명령 처리 객체(DDL/DML/DCL....)
//		Statement stmt = connt.createStatement();
		Statement stmt = connt.createStatement();
		// executeUpdate(sql) : select명령외의 모든명령
		// executeQuery(sql) : select명령
		
		//DDL
//		String sql = "create table t100(no int)";
		//String sql = "drop table t100";
		
		//DML (인설트)
//		String sql = "insert into dept values(60,'기획실','606')";
//		String sql = "update dept set loc='600' where deptno=60";
//		String sql = "delete from dept where deptno=60";
//		int res =		
//		stmt.executeUpdate(sql);
//		System.out.println("------success statement-------");
		
		// 3. ResultSet : 결과행 처리객체(조회 : select)
		String sql = "select * from dept";
		//해딩을 바꿔주면 아래 조회할때 해딩명을 정확히 적어야 데이터가온다
//		String sql = "select deptno as no,loc,dname from dept"; 
		ResultSet rs = stmt.executeQuery(sql);
		
		//전체조회
		while(rs.next()) { //rs.next() 한 위치가 데이터 영역인지 체크
			//현재 rs 위치(레코드)의 필드 값 읽어오기
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			
			//쓰지마시오 정보오류가 날수 있기때문에
//			int deptno = rs.getInt(1);
//			String dname = rs.getString(2);
//			String loc = rs.getString(3);
			
			
			
			//읽어온값 출력
			System.out.printf("[%d-%s-%s]\n",deptno,dname,loc);
		}
		
		//닫기(열린역순으로 닫아준다)
		rs.close(); //3
		stmt.close(); //2
		connt.close(); //1
		

	}//end : main

}//end : DBTest class
