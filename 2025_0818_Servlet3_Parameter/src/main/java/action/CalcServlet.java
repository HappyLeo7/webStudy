package action;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc.do")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service start");
		String su1=request.getParameter("su1");
		String su2=request.getParameter("su2");
		int iSu1=Integer.parseInt(su1);
		int iSu2=Integer.parseInt(su2);
		int sum=iSu1+iSu2;
		int minus=iSu1-iSu2;
		int multiplication =iSu1*iSu2;
		int share = iSu1/iSu2;	
		int remain = iSu1%iSu2;	
		
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>:::계산하기:::</h2>");
		out.print(String.format("%d + %d = %d\n", iSu1,iSu2,sum));
		out.print("<br>");
		out.print(String.format("%d - %d = %d\n", iSu1,iSu2,minus));
		out.print("<br>");
		out.print(String.format("%d * %d = %d\n", iSu1,iSu2,multiplication));
		out.print("<br>");
		out.print(String.format("%d / %d = %d\n", iSu1,iSu2,share));
		out.print("<br>");
		out.print(String.format("%d %% %d = %d\n", iSu1,iSu2,remain));
		out.print("<br>");
		out.print("<a href='calc.html'>돌아가기</a>");
		out.print("<br>");
		out.print("</body>");
		out.print("</html>");
	}

}
