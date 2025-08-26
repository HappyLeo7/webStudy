package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.DetpVo;
import service.DBService;

//dao 클래스 기능 : DB 데이터에서 처리하는 작업
//DAO(Data Access Object)
//CRUD처리
//Create : insert
//Read : select
//Update : update
//Delete : delete

public class DeptDao {
	//single-ton
	static DeptDao single = null;

	public static DeptDao getinstance() {
		if (single == null) {
			single = new DeptDao();
		}
		return single;
	};

	private DeptDao() {

	};
	
	//조회
	public List<DetpVo> selectList(){
		List<DetpVo> list = new ArrayList<DetpVo>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String sql = "select * from dept";
		
		try {
			// 1. Connection 얻어오기
			conn = DBService.getinstance().getConnection();
			
			// 2. PreparedStatement 얻기
			pstmt=conn.prepareStatement(sql);
			
			// 3. ResultSet 얻어오기
			rs = pstmt.executeQuery();
			
			// 레코드값을 VO포장후 list 넣는다.
			while(rs.next()) {
				DetpVo vo = new DetpVo();
				// rs가 가리키는 레코드값을 vo에 넣는다.
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			//ALT+SHIFT+Z 하면 try됨
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
}
