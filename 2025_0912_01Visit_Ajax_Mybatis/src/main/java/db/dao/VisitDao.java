package db.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.vo.VisitVo;
import service.MyBatisConnector;

// DAO (Data Access Object)
// : CRUD 처리하는 객체
public class VisitDao {
	
	SqlSessionFactory factory;
//single-ton
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null) {
			single = new VisitDao();
		}
		return single;
	};

	private VisitDao() {
		factory=MyBatisConnector.getInstance().getSqlSessionFactory();
	};
	
	// 조회
	public List<VisitVo> selectList() {
		List<VisitVo> list = null;

		//1.작업객체 얻어온다.
		SqlSession sqlSession = factory.openSession();
		
		// 2. 작업수행		  mapper_namespace . mapper_select_id
		list = sqlSession.selectList("visit.visit_list");
		
		// 3. 닫기
		sqlSession.close();
		

		return list;
	}
	
	//검색 조회
	public List<VisitVo> selectList(Map<String, Object> map) {
		List<VisitVo> list = null;

		//1.작업객체 얻어온다.
		SqlSession sqlSession = factory.openSession();
		
		// 2. 작업수행		  (mapper_namespace . mapper_select_id)
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		// 3. 닫기
		sqlSession.close();
		
		return list;
	}
	
	//추가
	public int insert(VisitVo vo) {

		int res = 0;

		//															 1 2 3 4 <-pstmt parameter index
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		// 1. 작업객체도구 가져오기 factory
		//										여기서 true는 오토 commit
		SqlSession sqlSession=factory.openSession(true);
		
		// 2. 작업수행
		res= sqlSession.insert("visit.visit_insert",vo);
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
	
	//삭제
	public int delete(int idx) {

		int res = 0;

		// 1. 작업객체도구 가져오기 factory
		//										여기서 true는 오토 commit
		SqlSession sqlSession=factory.openSession(true);
		
		// 2. 작업수행
		res= sqlSession.delete("visit.visit_delete",idx);
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

	
	//idx에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		//											1 <- pstmt index
		String sql = "select * from Visit where idx=?";

		// 1. 작업객체 가져오기
		SqlSession sqlSession =factory.openSession();
		
		// 2. 작업수행
		vo=sqlSession.selectOne("visit.visit_selectOne", idx);
		
		sqlSession.close();
		
		
		return vo;
	}


	//update
	public int update(VisitVo vo) {

		int res = 0;

		// 1. 작업객체 가져오기
		SqlSession sqlsession=factory.openSession(true);
		
		// 2. 작업수행
		res=sqlsession.update("visit.visit_update", vo);
		
		// 3. 닫기
		sqlsession.close();

		return res;
	}

	
	
	
	
}//end class
