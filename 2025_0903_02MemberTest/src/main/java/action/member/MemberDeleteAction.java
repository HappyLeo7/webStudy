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
 * Servlet implementation class MemberDeletAction
 */
@WebServlet("/member/delet.do")
public class MemberDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[MemberDeletAction service 실행]");
		//삭제처리
		int mem_idx=Integer.parseInt(request.getParameter("mem_idx"));
		int res=MemberDao.getInstance().delete(mem_idx);
		System.out.printf("mem_idx:%d",mem_idx);
		System.out.printf("res:%d",res);
		response.sendRedirect("list.do");
		

	}

}
