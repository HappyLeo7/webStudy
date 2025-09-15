package action.member;

import java.io.IOException;

import db.dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberModifyAction
 */
@WebServlet("/member/modify_form.do")
public class MemberModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[MemberModifyFormAction service 실행]");
		
		//mem_idx 받아오기 파라메터로
		int mem_idx=Integer.parseInt(request.getParameter("mem_idx"));
		
		// Dao 이용해서 1개의 데이터 조회해오기
		MemberVo vo=MemberDao.getInstance().selectOne(mem_idx);
		request.setAttribute("vo", vo);
		
		//dispatcher(forward)
		String forward_page = "member_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		

	}

}