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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request // Client -> Server넘어온 정보처리
			, HttpServletResponse response // Server -> Client응답처리하는 객체
	) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service start");
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		// TODO 문자열 -> 정수로 변환
		int int_su1 = Integer.parseInt(su1);
		int int_su2 = Integer.parseInt(su2);

		int sum = int_su1 + int_su2;
		int minus = int_su1 - int_su2;
		int multiplication = int_su1 * int_su2;

		// TODO 응답처리 mime-type; 문자셋=인코딩;
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		//Server -> Client로 내용 전송(응답)
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>:::계산하기:::</h2>");
		out.print(String.format("%d + %d = %d\n", int_su1, int_su2, sum));
		out.printf("%d + %d = %d", int_su1, int_su2, sum);
		out.print("<br>");
		out.print(String.format("%d - %d = %d\n", int_su1, int_su2, minus));
		out.print("<br>");
		out.print(String.format("%d * %d = %d\n", int_su1, int_su2, multiplication));
		out.print("<br>");
		if (int_su2 == 0) {
			out.print("<font color='red'> 0으로 나눌수 없습니다</font>");
			out.print("<br>");
		} else {

			int share = int_su1 / int_su2;
			int remain = int_su1 % int_su2;
			out.print(String.format("%d / %d = %d\n", int_su1, int_su2, share));
			out.print("<br>");
			out.print(String.format("%d %% %d = %d\n", int_su1, int_su2, remain));
			out.print("<br>");
		}
		out.print("<a href='calc.html'>돌아가기</a>");
		out.print("<br>");
		out.print("</body>");
		out.print("</html>");
	}

}
