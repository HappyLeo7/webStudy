package action;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.KakaoSearchUtils;
import vo.LocalVo;

/**
 * Servlet implementation class LocalListAction
 */
@WebServlet("/local/list.do")
public class LocalListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("list 서비스");
		// TODO Auto-generated method stub
		// local/search/keyword.json?query=병원&page=3&size=3&radius=100&sort=distance&x=126.952137&y=37.481021
		
		// 0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 1.p parameter받기
		int page = 1; 
		int size = 10;
		int radius =1000;
		
		String query= request.getParameter("query");
		String x = request.getParameter("longitude");
		String y = request.getParameter("latitude");
		
		try {
			page= Integer.parseInt(request.getParameter("page"));
			size= Integer.parseInt(request.getParameter("size"));
			radius= Integer.parseInt(request.getParameter("radius"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//검색정보 가져오기
		List<LocalVo> list = KakaoSearchUtils.getSearchLocal(query, page, size, radius, x, y);
		
		//request binding
		request.setAttribute("list", list);
		
		
		//dispatcher(forward)
		String forward_page = "local_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
