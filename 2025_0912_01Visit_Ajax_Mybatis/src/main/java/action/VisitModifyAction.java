package action;

import java.io.IOException;

import db.dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//visit/modify.do?name=응길동&content=응&pwd=vo.pwd
		// 1. 수신 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. parameter 받기
		int idx=Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		// 받아올때 \n 을 체크한다.
		String content = request.getParameter("content").replaceAll("\n", "<br>");
		String pwd = request.getParameter("pwd");
		
		// 2. 작성자 ip 받기
		String ip = request.getRemoteAddr();
		
		//3. VisitVo 포장
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);
		
		//4. DB update , DAO를 통해서
		int rse = VisitDao.getInstance().update(vo);
		
		//5. 메인화면으로 이동
		response.sendRedirect("list.do");
		
	} // end : service()

}