package action;

import java.io.IOException;
import java.util.List;

import dao.SawonDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sawon/list.do?deptno=10
		
		int deptno = 0;
		try {
			deptno=Integer.parseInt(request.getParameter("deptno"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//목록가져오기
		List<SawonVo> list = null;
		if(deptno==0) {
		//전체조회
			list= SawonDao.getInstance().selectList();
		}else {
			//부서별조회
			System.out.println("부서별조회");
			System.out.println(deptno);
			list=SawonDao.getInstance().selectListFromDeptno(deptno);
		}
		
		//request binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}