package action;

import java.io.IOException;

import db.dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// parameter : 요청시 전달인자 ( name, content, pwd ) 
		//http://localhost:8080/2025_0901_Visit/visit/insert.do?name=홍길동&content=1빠이고싶어요&pwd=1234
		
		//0.수신인 코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter 받기
		String name = request.getParameter("name");
		//TODO textarea로 데이터를 받아올때 줄바꿈이\n\r로 오기때문에 다시 출력해줄땐 <br>으로 바꿔줘야한다.
		//	textarea 태그에서는  윈도우는 \r\n으로 오는데  다른곳은 \n 하나만온다
		String content = request.getParameter("content").replaceAll("\n", "<br>"); 
		String pwd = request.getParameter("pwd");
		
		//2.전송자 ip구하기
		String ip = request.getRemoteAddr(); //전송자(client) IP
		
		//3.VisitVo 포장
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		//4.DB insert (DAO에게 시킨다)
		// 리턴된 1을 받는다. / 받아두고 사용을 안해도 되지만 성공여부 체크할땐 사용할 수도 있다.
<<<<<<< HEAD
		int res = VisitDao.getinstance().insert(vo);
=======
		int res = VisitDao.getInstance().insert(vo);
>>>>>>> branch 'master' of https://github.com/HappyLeo7/webStudy.git
		
		
		//Redirect : 목록보기로 재접속정보를 응답
		response.sendRedirect("list.do");

	}

}