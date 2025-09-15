package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comments.vo.CommentsVo;
import service.DBService;

public class CommentsDao {
	//싱글톤형태로만들기
	private static CommentsDao singleton=null;
	
	//생성자는 외부에서 사용못하게 숨기기
	private CommentsDao() {
		super();
	}
	
	//외부에서 생성자를 생성하는 매서드 만들기
	public static CommentsDao getInstance() {
		if(singleton==null) {
			singleton=new CommentsDao();
		}
		return singleton;
		
	}
	
	//댓글 조회 할수 있는 매서드 만들기 / 리턴값이 있어야한다.
	 public List<CommentsVo> selectList(){
		 System.out.println("--------CommentsDao selectLis() 호출---------\n\n");
		 //컬렉션 ArrayList 객체생성 (DB에서 여러 행의 데이터를 담기 위해서)
		 List<CommentsVo> list =new ArrayList<CommentsVo>();
		 
		 //DB와 연결하는 객체
		 Connection conn=null;
		 //PreparedStatement
		 //sql문을 실행해주는 객체
		 PreparedStatement pstmt=null;
		 //조회해온 데이터값이 들어온곳
		 ResultSet rs= null;
		 
		 //sql문이 필요
		 String sql = "select * from comments";
		 
		 try {
			 //DB연결 완료
			conn=DBService.getinstance().getConnection();
			//연결된 DB에 sql문 보내기
			pstmt=conn.prepareStatement(sql);
			//sql문을 실행해서 결과 가져오기
			rs=pstmt.executeQuery();
			
			//rs에 들어있는 정보들을 한 행씩 빼는 작업 (rs.next())는 데이터가 있으면 true 리턴 없으면 false 리턴해준다.
			while (rs.next()) {
				//객체에 담을 vo 객체 생성
				CommentsVo vo = new CommentsVo();
				
				//vo객체에 한줄씩 DB에서 가져온 데이터 넣기
				vo.setCommentes_idx(rs.getInt("idx"));
				vo.setCommentes_name(rs.getString("name"));
				vo.setCommentes_content(rs.getString("content"));
				vo.setCommentes_pwd(rs.getString("pwd"));
				vo.setCommentes_ip(rs.getString("ip"));
				vo.setCommentes_regdate(rs.getString("regdate"));
				
				//컬렉션 ArrayList에 DB에있는 1행씩의 데이터를 vo에 담은걸 넣는다.
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//사용하려고 영어둔 객체들에 정보가 남아있으면 닫아준다. 
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
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
		//list에 담아둔 데이터들을 모두 호출한곳으로 리턴해준다.
		return list;
	}//end : selectList()
	
}
