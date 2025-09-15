package action.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import db.dao.MemberDao;
import db.vo.MemberVo;

/**
 * Servlet implementation class MemberModifyAction
 */
@WebServlet("/member/modify.do")
public class MemberModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[MemberModifyAction service 실행]");
		
		//수신 인코딩 꼭해주기
		request.setCharacterEncoding("utf-8");
		
		/* 수정폼에서 데이터 받아오기 */
		int mem_idx=Integer.parseInt(request.getParameter("mem_idx"));
		String mem_name=	request.getParameter("mem_name");
		String mem_id=		request.getParameter("mem_id");
		String mem_pwd=		request.getParameter("mem_pwd");
		String mem_email=	request.getParameter("mem_email");
		String mem_zippcode=request.getParameter("mem_zippcode");
		String mem_addr=	request.getParameter("mem_addr");
		String mem_grade=	request.getParameter("mem_grade");
		
		//IP 받기
		String mem_ip=		request.getRemoteAddr();
		
		/* 받아온 데이터 콘솔로 확인 */
		//System.out.printf("%d,%s,%s,%s,%s,%s,%s,%s\n",mem_idx,mem_name,mem_id,mem_pwd,mem_email,mem_zippcode,mem_addr,mem_grade);
		
		/* MemberVo에 수정폼에서 받아온 데이터를 넣을수 있는 생성자를 만든다. */
		MemberVo vo= new MemberVo(mem_idx, mem_name, mem_id, mem_pwd, mem_email, mem_zippcode, mem_addr,mem_ip, mem_grade);
		System.out.println("수정폼:"+vo);
		MemberDao.getInstance().update(vo);
		
		//dispatcher(forward)
		String forward_page = "list.do";
		/*
		 * RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		 * disp.forward(request, response);
		 */
		response.sendRedirect(forward_page);

	}

}
