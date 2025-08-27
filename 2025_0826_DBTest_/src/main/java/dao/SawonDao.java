package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.SawonVo;
import service.DBService;

public class SawonDao {
//single-ton
	static SawonDao single = null;

	public static SawonDao getinstance() {
		if (single == null) {
			single = new SawonDao();
		}
		return single;
	};

	private SawonDao() {

	};
	
	public List<SawonVo> selectList() {
		List<SawonVo> list = new ArrayList<SawonVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getinstance().getConnection();

			// 2. PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			//			String sql = "select * from dept where id=? and pwd=?";  //prepareStatment 형식으로 하면 왼쪽 코드처럼 물음표로 처리하기때문에 해킹방지

			// 3. ResultSet 얻어오기
			rs = pstmt.executeQuery();

			// 레코드값을 VO포장후 list 넣는다.
			while (rs.next()) {
				SawonVo vo = new SawonVo();
				// rs가 가리키는 레코드값을 vo에 넣는다.
				// rs는 테이블의 첫번째 열을 의미한다.
				vo.setSabun(rs.getInt("sabun"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			//ALT+SHIFT+Z 하면 try됨
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
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
