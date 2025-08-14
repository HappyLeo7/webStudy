package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("----HelloAction.service() call----");
		//TODO 요청자 IP
		String ip = request.getRemoteAddr();
		System.out.printf("[%s]님 요청\n",ip);
		
		//여러분 화면에 응답
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.printf("[%s]님 안녕하세요", ip);
	}

}
