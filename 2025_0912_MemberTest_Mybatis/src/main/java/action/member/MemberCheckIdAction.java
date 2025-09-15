package action.member;

import java.io.IOException;

import db.dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[MemberCheckIdAction 실행]");
		
		// 0. 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 1. parameter 받기
		String mem_id = request.getParameter("mem_id");
		
		// 2. mem_id를 이용해서 vo추출
		MemberVo vo = MemberDao.getInstance().selectOne(mem_id);
		
		// 3. 결과
		//boolean bResult = (vo==null); //id가 있으면 false를 반환하고 id가 없으면 null와서 true를 반환한다.
		boolean bResult = false;
		if(vo==null) {
			bResult = true;
		}
		
		// 4. 결과 json 생성
		// {"result":true}
		String json = String.format("{\"result\":%b}",bResult );
	
		// 5. 응답처리
		response.setContentType("application/json;charset=utf-8;"); //전송 타입을 json타입으로 보내고 인코딩한다라는 의미 
		response.getWriter().print(json); // json 데이터를 화면출력용으로 데이터 전송
	
	
	}
	

}