package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.vo.MemberVo;
import service.MyBatisConnector;

public class MemberDao {
	
	SqlSessionFactory factory;
	//single-ton
		static MemberDao single = null;

		public static MemberDao getInstance() {
			if (single == null) {
				single = new MemberDao();
			}
			return single;
		};

		private MemberDao() {
			factory=MyBatisConnector.getInstance().getSqlSessionFactory();
		};
	
	
	//전체조회 TODO 제네릭 수정하기
	public List<MemberVo> selectList() {
		System.out.println("[Dao selectList() 실행]");
		List<MemberVo> list = null;

		//도구
		SqlSession sqlSession=factory.openSession();
		
		//TODO 수행               (mapper_namespace . mapper_select_id) 
		list=sqlSession.selectList("member.member_list");
		//닫기
		sqlSession.close();
		
		return list;
	}
	
	//member에서 회원번호로 1개 조회
	public MemberVo selectOne(int mem_idx) {
		System.out.println("[MemberDao selectOne(int mem_idx) 실행]");
		MemberVo vo = null;


		String sql = "select * from member where mem_idx=?";

		//도구
		SqlSession sqlSession=factory.openSession();
		//수행
		vo=sqlSession.selectOne("member.member_one",mem_idx);
		//닫기
		sqlSession.close();
		return vo;
	}//end selectOne(mem_idx)
	
	
	//로그인시 사용
	public MemberVo selectOne(String mem_id) {
		System.out.println("[MemberDao selectOne(String mem_id) 실행]");
		
		MemberVo vo = null;


		String sql = "select * from member where mem_id=?";
		//도구
		SqlSession sqlSession=factory.openSession();
		//실행
		vo=sqlSession.selectOne("member.member_one_id",mem_id);
		//닫기
		sqlSession.close();

		return vo;
	}

	
	//추가
	public int insert(MemberVo vo) {
		System.out.println("[MemberDao insert(MemberVo vo) 실행]");
		
		int res = 0;
		//																   1 2 3 4 5 6 7 
		String sql = "insert into member values(seq_member_mem_idx.nextval,?,?,?,?,?,?,?,sysdate,'일반')";

		
		//도구
		SqlSession sqlSession=factory.openSession(true);
		//수행
		res=sqlSession.insert("member.member_insert",vo);
		//닫기
		sqlSession.close();
		return res;
	}
	
	//삭제
		public int delete(int mem_idx) {

			int res = 0;

			// 1. 작업객체도구 가져오기 factory
			//										여기서 true는 오토 commit
			SqlSession sqlSession=factory.openSession(true);
			
			// 2. 작업수행  TODO (mapper_namespace . mapper_select_id , 파라미터변수)
			res= sqlSession.delete("member.member_delete",mem_idx);
			if(res==1) {
				
			// 2-1. 커밋을해야 데이터가 DB에올라간다.
			sqlSession.commit();
			}else if(res==0) {
				
			// 2-2. 데이터에 올리기전에 취소
			//sqlSession.rollback();
			}
			
			// 3. 닫기
			sqlSession.close();

			return res;
		}
	
	//수정처리
	public int update(MemberVo vo) {

		int res = 0;

		//										1			2		  3          4            5               6           7            8         9              10		
		String sql = "update member set mem_idx=?, mem_name=?, mem_id=?, mem_pwd=?, mem_email=?, mem_zippcode=?, mem_addr=?, mem_grade=?, mem_ip=? where mem_idx=?";

		System.out.println(vo);
		//도구
		SqlSession sqlSession=factory.openSession(true);
		//수행
		res=sqlSession.update("member.member_update",vo);
		//닫기
		sqlSession.close();
		return res;
	}
	
}//end : MemberDao class
