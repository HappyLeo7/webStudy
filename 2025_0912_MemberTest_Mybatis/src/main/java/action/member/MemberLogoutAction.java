package action.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutAction
 */
@WebServlet("/member/logout.do")
public class MemberLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	System.out.println("[MemberLogoutAction service() 실행]");

	//세션 정보 지우기
	HttpSession session = request.getSession();
	//user 정보 삭제 (키값 삭제)
	session.removeAttribute("user_vo");
	
	//완전히 session에 있는 정보 삭제 , 세션을 완전히 삭제하면 로그아웃 기록을 남길수 있다.
	//session.invalidate();
	
	//메인화면으로 이동 ..
	response.sendRedirect("list.do");
	
	}

}