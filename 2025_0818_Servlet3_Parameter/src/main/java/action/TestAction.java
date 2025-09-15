package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ResponseCache;

/**
 * Servlet implementation class TestAction
 */
@WebServlet("/TestAction")
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	// 변수 선언
	int n ;
	
	//메소드 선언
	void info() {
		System.out.println("정보출력");
	}
	
	protected void service(HttpServletRequest req,HttpServletResponse response)throws ServletException, IOException{
		//서비스매소드 안에 변수선언
		int x = 10;
		response.getWriter().print(x);
	}

}
