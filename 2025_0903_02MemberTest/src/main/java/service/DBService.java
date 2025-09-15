package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	DataSource ds =null;
	
	//싱글톤으로 만든다 무잡이한 낭비를 버리기위해서
	static DBService single =null;
	public static DBService getInstance() {
		if(single==null) {
			single=new DBService();
		}
		return single;
	};
		
	
	private DBService() {
		System.out.println("[싱글톤 DBService() 실행]");
		// JNDI(java naming directory interface)기술
		//			name이란 자원을 탐색 interface를 얻어내는 기술		
		// context.xml에 적혀있는 name 을 가지고 활용
		// 
		try {
			//이름을 가지고 연결하는 java api
			InitialContext ic =new InitialContext();
			//Context 위치 탐색하기, "java:comp/env"은 예약어이다.
			Context context = (Context) ic.lookup("java:comp/env");
			//DataSource자원정보 검색
			ds=(DataSource)context.lookup("jdbc/oracle_test");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException {
		//DBCP 내에 저장된 컨텍션중 1개를 얻어온다.
		return ds.getConnection();
	}
	
}//end : DBService class
