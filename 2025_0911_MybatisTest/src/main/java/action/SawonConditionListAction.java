package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SawonDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/condition_list.do")
public class SawonConditionListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sawon/list.do?deptno=10
		// sawon/list.do?deptno=10&sajob=부장
		
		int deptno = 0;
		String sajob,sasex,sahire = null;
		
		
		try {
			deptno=Integer.parseInt(request.getParameter("deptno"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		sajob = request.getParameter("sajob");
		if(sajob==null) {
			sajob="all";
		}
		
		sasex=request.getParameter("sasex");
		if(sasex==null) {
			sasex="all";
		}
		sahire=request.getParameter("sahire");
		if(sahire==null) {
			sahire="all";
		}
		
		//검색조건을 담을 Map객체를 생성
		Map<String, Object> map = new HashMap<String, Object>();

		if(deptno !=0) { //전체검색이 아니면 검색조건 추가
			map.put("deptno", deptno);
		}
		
		if(sajob.equals("all")==false) { 
			map.put("sajob", sajob);
		}
		
		if(sasex.equals("all")==false) {
			map.put("sasex", sasex);
		}
		if(sahire.equals("all")==false) {
			map.put("sahire", sahire);
		}
		//목록가져오기
		List<SawonVo> list = SawonDao.getInstance().selectConditionList(map);
		
		//request binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}