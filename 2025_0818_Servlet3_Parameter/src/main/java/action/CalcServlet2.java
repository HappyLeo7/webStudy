package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcServlet2
 */
@WebServlet("/calc2.do")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
    	
    	String su1=request.getParameter("su1");
    	System.out.printf("%s", su1);
    	response.setContentType("text/html;charset=utf-8;");//html 언어로 설정하고 언어패치
    	PrintWriter out=response.getWriter();
    	out.print(String.format("%s", su1));
    	
    }


}
