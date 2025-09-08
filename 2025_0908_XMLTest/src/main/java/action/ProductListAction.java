package action;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.MySearchUtil;
import vo.BookVo;
import vo.ProductVo;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/product/list.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter 받기
		String p_name = request.getParameter("p_name");
		
		int start=1;
		int display=10;
		
		try {
			start=Integer.parseInt(request.getParameter("start"));
			display=Integer.parseInt(request.getParameter("display"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String product=request.getParameter("product");
		System.out.println(product);
		//naver 로 부터 검색 상품 정보를 가져오기
		if(product.equals("shop")) {
			List<ProductVo> list = MySearchUtil.search_shop(p_name, start, display);
			request.setAttribute("list", list);
			String forward_page = "product_list.jsp";
			//dispatcher(forward)
			RequestDispatcher disp = request.getRequestDispatcher(forward_page);
			disp.forward(request, response);
			
		}else if(product.equals("book")) {
			
			List<BookVo> list = MySearchUtil.search_book(p_name, start, display);
			request.setAttribute("list", list);
			String forward_page = "book_list.jsp";
			//dispatcher(forward)
			RequestDispatcher disp = request.getRequestDispatcher(forward_page);
			disp.forward(request, response);
		}
		
		//request binding
		
		

	}

}
