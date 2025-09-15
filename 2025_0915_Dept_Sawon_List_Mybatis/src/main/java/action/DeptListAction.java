package action;

import java.io.IOException;
import java.util.List;

import dao.DeptDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.DeptVo;

/**
 * Servlet implementation class DeptListAction
 */
@WebServlet("/dept/list.do")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//목록가져오기
		List<DeptVo> list =DeptDao.getInstance().selectList();
		
		//reuqest binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "dept_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
