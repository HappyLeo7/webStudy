package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.VisitVo;
import service.DBService;

// DAO (Data Access Object)
// : CRUD 처리하는 객체
public class VisitDao {
//single-ton
	static VisitDao single = null;

	public static VisitDao getinstance() {
		if (single == null) {
			single = new VisitDao();
		}
		return single;
	};

	private VisitDao() {

	};
	
	// 조회
	public List<VisitVo> selectList() {
		List<VisitVo> list = new ArrayList<VisitVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit order by idx desc";

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
				VisitVo vo = new VisitVo();
				// rs가 가리키는 레코드값을 vo에 넣는다.
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				
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
	
	
	//추가
	public int insert(VisitVo vo) {

		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		//															 1 2 3 4 <-pstmt parameter index
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		try {
			//1.Connection 얻어오기
			conn = DBService.getinstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			// pstmt.set타입(pstmt parameter idex , vo에서 받아올 데이터);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			
			//4.DB Insert (처리된 레코드 수가 들어간다 , 1개 행이 추가되었기 때문에 성공)
			// 1을 리턴한다.
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
	
	
}//end class
