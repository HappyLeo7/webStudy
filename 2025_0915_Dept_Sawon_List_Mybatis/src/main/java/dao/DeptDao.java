package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {

	//Mybatis객체
	SqlSessionFactory factory;
	
	//single-ton
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();

		return single;
	}

	private DeptDao() {
		factory=MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<DeptVo> selectList(){
		List<DeptVo> list = null;
		
			//도구
			SqlSession sqlsession=factory.openSession();
			//실행
			list=sqlsession.selectList("dept.dept_list");
			//닫기
			sqlsession.close();
		
		return list;
	}
	
}
