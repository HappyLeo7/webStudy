
import java.io.IOException;

import action.BookAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Book CRUD를 할 객체
	BookAction action = new BookAction();
	
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //요청 URL : http://localhost:8080/2025_0915_MVCTest/list.do
		//요청 URI : /2025_0915_MVCTest/list.do
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		String forward_page = "";
		if(uri.contains("list.do")) {
			//전체목록보기
			forward_page = action.list(request, response);
		}else if(uri.contains("view.do")) {
			//상세보기
			
			forward_page = action.view(request, response);
		}
		
		//dispatcher(forward)
		
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
