package action.mamber;

import java.io.IOException;
import java.util.List;

import db.dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/member/list.do")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<MemberVo> list = MemberDao.getInstance().selectList();
		
		//request binding
		request.setAttribute("list", list);
		System.out.println(list);
		//dispatcher(forward)
		String forward_page = "member_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
