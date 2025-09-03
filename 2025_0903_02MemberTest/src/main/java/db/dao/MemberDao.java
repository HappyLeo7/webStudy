package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.MemberVo;
import service.DBService;

public class MemberDao {
	
	// single-ton
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();

		return single;
	}//end getInstance()

	private MemberDao() {

	}//end 기본생성자
	
	
	//전체조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();
			//레코드값을 VO포장후 list넣는다
			while (rs.next()) {

				MemberVo vo = new MemberVo();
				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_zippcode(rs.getString("mem_zippcode"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	//member에서 회원번호로 1개 조회
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where mem_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setInt(1, mem_idx);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new MemberVo();
				//rs가 가리키는 레코드값을 vo에 넣는다

				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}//end selectOne(mem_idx)
	
	
	//
	public MemberVo selectOne(String mem_id) {

		MemberVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where mem_id=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻기
			pstmt = conn.prepareStatement(sql);

			//3.PrepareStatement Parameter설정
			pstmt.setString(1, mem_id);

			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo = new MemberVo();
				//rs가 가리키는 레코드값을 vo에 넣는다

				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_addr(rs.getString("mem_addr"));
				vo.setMem_ip(rs.getString("mem_ip"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				vo.setMem_grade(rs.getString("mem_grade"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
	
}//end : MemberDao class
