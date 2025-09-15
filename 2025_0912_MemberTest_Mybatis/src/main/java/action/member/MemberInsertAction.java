package action.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import db.dao.MemberDao;
import db.vo.MemberVo;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[MemberInsertAction 실행]");
		//  0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8"); //클라이언트 인코딩을 체크하고 수신에 맞게 인코딩한다.
		
		// 1.parameter 받기
		String mem_name= request.getParameter("mem_name");
		String mem_id=request.getParameter("mem_id");
		String mem_pwd=request.getParameter("mem_pwd");
		String mem_email = request.getParameter("mem_email");
		String mem_zippcode=request.getParameter("mem_zippcode");
		String mem_addr=request.getParameter("mem_addr");
		
		// 2. IP받기
		String mem_ip=request.getRemoteAddr();
		
		// 3. MemberVo에 포장
		MemberVo vo = new MemberVo(mem_name, mem_id, mem_pwd, mem_email, mem_zippcode, mem_addr, mem_ip, "일반");
		
		// 4. DB insert
		int res = MemberDao.getInstance().insert(vo);
		
		//5.메인페이지 이동
		response.sendRedirect("list.do");
		
		
	}

}