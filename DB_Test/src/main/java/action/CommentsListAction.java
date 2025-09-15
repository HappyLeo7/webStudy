package action;


import java.io.IOException;
import java.util.List;

import comments.vo.CommentsVo;
import dao.CommentsDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO 어노테이션 WebServlet URL 필요
@WebServlet("/comments_list.do")
// TODO HTTP Servlet 상속받기
public class CommentsListAction extends HttpServlet {

		// TODO 직열화관련해서 필요한 코드
		private static final long serialVersionUID = 1L;
		
		// TODO service 매서드 구현하기
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
			
			//데이터 처리
			//데이터베이스에서 데이터 전체 가져오기 Dao을 이용하여서
			List<CommentsVo> list=CommentsDao.getInstance().selectList();
			
			//list에 담아온 데이터를 
			request.setAttribute("list", list);
			
			// 보여줄 jsp 경로
			String forward_page="/WEB-INF/jsp/comments/comments_list.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(forward_page);
			disp.forward(request, response);
		}

}
