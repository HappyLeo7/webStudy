package action;

import java.io.IOException;

import db.dao.VisitDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/visit/delete.do")
public class VisitDeleteAction extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	 protected void service(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException{
		
		 String str_idx=request.getParameter("idx"); // 문자 "14"에서
		 int int_idx=Integer.parseInt(str_idx);			 // 숫자 14로 변경
		 System.out.println(int_idx);
		 
		 // 1. 삭제할 게시물 idx받기
		 int idx = Integer.parseInt(request.getParameter("idx"));
		 
		 // 2. DB delete , DAO에게 삭제요청하기
		 int res = VisitDao.getInstance().delete(idx);
		 
		 // 3.삭제 처리후 메인으로 다시 이동 (목록보기)
		 response.sendRedirect("list.do");
	}
}
