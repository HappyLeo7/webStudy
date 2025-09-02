package action;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// calc.do?su1=5&su2=3
		int su1 =Integer.parseInt(request.getParameter("su1"));
		int su2 =Integer.parseInt(request.getParameter("su2"));
		
		
		response.setContentType("text/html:charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		out.print("<h3>[결과 알려줄게]</h3>");
		out.printf("%d + %d = %d<br>",su1,su2,su1+su2);
		out.printf("%d - %d = %d<br>",su1,su2,su1-su2);
		out.printf("%d * %d = %d<br>",su1,su2,su1*su2);
		if(su2==0) {
			out.print("0으로 나눌수 없습니다<br>");
			
		}else {
			out.printf("%d / %d = %d<br>",su1,su2,su1/su2);
			out.printf("%d %% %d = %d<br>",su1,su2,su1%su2);
		}
		
		
		
	}

}