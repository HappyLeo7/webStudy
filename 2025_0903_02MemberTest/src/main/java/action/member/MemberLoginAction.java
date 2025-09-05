package action.member;

import java.io.IOException;

import db.dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[MemberLoginAction sevice 실행]");
		
		//. 0수신인코읻ㅇ 설정
		request.setCharacterEncoding("utf-8");
		
		// 1. Parameter 받기
		String mem_id=request.getParameter("mem_id");
		String mem_pwd=request.getParameter("mem_pwd");
		
		// 2. mem_id 이용 selectOne 객체정보 얻어오기
		MemberVo user_vo = MemberDao.getInstance().selectOne(mem_id);
		
		// 아이디가 틀린경우
		if(user_vo==null) {
			response.sendRedirect("login_form.do?reason=fail_id"); //아이디가 틀려서 로그인 실패시 다시 form으로 이동시킨다.
			return;
		}
		
		// 비밀번호가 틀린경우
		if(user_vo.getMem_pwd().equals(mem_pwd)==false) {
			response.sendRedirect("login_form.do?reason=fail_pwd&mem_id="+mem_id);
			return;
		}
		
		// 정상적인 로그인 처리
		HttpSession session = request.getSession();
		
		System.out.println(session.getId());
		
		session.setAttribute("user_vo", user_vo);
		
		// 메인화면으로 가라..
		response.sendRedirect("list.do");
		
	}

}