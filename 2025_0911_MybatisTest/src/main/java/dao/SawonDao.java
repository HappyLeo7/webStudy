package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	//SessionFactory생성하는 객체
	SqlSessionFactory factory;
	
	private SawonDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	
	//조회
	public List<SawonVo> selectList(){
		List<SawonVo> list =null;
		
		// 1. SqlSession객체 정보를 얻어온다.(Mybatis의 실제 작업객체)
		SqlSession sqlSession = factory.openSession();
		
		//                            패키지 테이블명
		// 2. 작업수행				 namespasce.mapper_id
		list = sqlSession.selectList("sawon.sawon_list");
		
		// 3. 닫기(내부적으로 connection 닫기) , DBCP관리하는애가 체크한다.
		sqlSession.close();
		return list;
	}

	public List<SawonVo> selectListFromDeptno(int deptno) {
		
		List<SawonVo> list = null;
		
		// 1. SqlSession객체 정보를 얻어온다.(Mybatis의 실제 작업객체)
		SqlSession sqlSession = factory.openSession();
		
		// 2. 작업수행					namespace.mapper_id  , parameter
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		
		// 3. 닫기
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectConditionList(Map<String, Object> map) {
		List<SawonVo> list = null;
		
		// 1. SqlSession객체 정보를 얻어온다.(Mybatis의 실제 작업객체)
		SqlSession sqlSession = factory.openSession();
		
		// 2. 작업수행					namespace.mapper_id  , parameter
		list = sqlSession.selectList("sawon.sawon_list_condition",map);
		
		// 3. 닫기
		sqlSession.close();
		
		return list;
	}
	
	
	
	
	
}
