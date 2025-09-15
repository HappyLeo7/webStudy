package action;

import java.io.IOException;
import java.rmi.ServerException;

import db.dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/visit/check_pwd.do")
public class VisitCheckPwdAction extends HttpServlet{
	//직열화때 사용되는 코드 쓰기
	private static final long serialVersionUID=1L;
	
	//서비스할 매서드 작성
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException{
		System.out.println("[비밀번호 체크 서비스]");
		// /visit/check_pwd.do?idx=5$c_pwd=1234
		
		// 0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 1. 파라메터 받기(요청받기)
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		// 2. idx에 해당되는 게시물 1건 정보 얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		//입력한 비밀번호랑 기존 비밀번호랑 비교체크하기
		boolean bResult = vo.getPwd().equals(c_pwd);
		System.out.printf("idx:%d , c_pwd:%s , vo.getPwd:%s , bResult:%b\n",idx,c_pwd,vo.getPwd(),bResult);
		
		// JSON 형식으로 : {"result" : true} or {"result" : false} 
		String json = String.format("{\"result\" : %b}", bResult);
		System.out.printf("json data : %s ",json);
		// 3.응답처리
		// 타입을 json으로 응답한다. ; 한글이 넘어갈때 인코딩도 해줘야한다.
		response.setContentType("application/json; charset=utf-8;");
		response.getWriter().print(json);
	}
}
