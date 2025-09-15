package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /visit/list.do?search=name&search_text=홍길동

		// 0. 수신인코딩
		request.setCharacterEncoding("utf-8");
		
		// 1.parameter 받기
		String search = request.getParameter("search");
		if(search==null) {
			search="all";
		}
		String search_text = request.getParameter("search_text");
		
		//검색정보(조건)를 담을 Map을 선언
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		if(search.equals("name_content")) {
			map.put("name", search_text);
			map.put("content", search_text);
		}else if(search.equals("name")) {
			map.put("name", search_text);
		}else if(search.equals("content")) {
			map.put("content", search_text);
		}
		
		
		//방명록 목록 가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page); //jsp에게 보낸다.
		disp.forward(request, response);

	}

}