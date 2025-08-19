package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register2.do")
public class MemberRegisterAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
	
	protected void service(
			HttpServletRequest request //요청처리객체
			, HttpServletResponse response //응답처리객체
			)throws ServletException,IOException{
		//http://localhost:8080/2025_0818_Servlet3_Parameter/member_register.do?
		//name=홍길동
		//id=hong&
		//password=1234&
		//email=hong%40naver.com&
		//gender=남자
		//EC%9D%8C%EC%95%85&hobby=%EC%9A%B4%EB%8F%99&friend=%EC%B9%9C%EA%B5%AC1&friend=&friend=&blood=B&introduce=%EB%B0%98%EA%B0%91%EC%8A%B5%EB%8B%88%EB%8B%A4
		
		//요청해주는 수신인코딩 설정 매소드
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
//		System.out.println(name);
		
		String id = request.getParameter("id"); 
		String password = request.getParameter("password"); 
		String email = request.getParameter("email"); 
		String gender = request.getParameter("gender"); 
		String blood = request.getParameter("blood"); 
		String introduce = request.getParameter("introduce"); 
		
		//parameter가 동일한 이름으로 여러개 있는 경우에 배열로 받는다.
		String [] hobby_array=request.getParameterValues("hobby");
		String [] friend_array=request.getParameterValues("friend");
		
		String hobby_list ="취미없음";
		//member_register.do?hobby=독서&hobby=영화
		//String [] hobby_array={"독서","영화"};
		if(hobby_array!=null) {
			StringBuffer sb1=new StringBuffer();
			for(String hobby : hobby_array) {
				sb1.append(" ");
				sb1.append(hobby);
				sb1.append(" ");
			}// 독서 영화 
			
			hobby_list = sb1.toString();
		}
		
		//member_register.do?friend=&friend=&friend=&blood=A
		//String [] friend_array= {"","",""};
		StringBuffer sb2=new StringBuffer();
		for(String friend : friend_array) {
			
			sb2.append(friend);
			sb2.append(" ");
		} //  "" " " "" " " "" " "
		String friend_list = sb2.toString().trim(); //
		if(friend_list.isEmpty()) { //if(friend_list.equals(""))
			friend_list = "친구없음";
		}
		
		
		//------------------[↑]     :	Business Logic (Data 관리 로직) 클라이언트가 요청한 정보를 데이터 처리
		//								비지니스 로직
						// 모델1 : 두 로직이 같이있는 걸
		//------------------[↓]		:	Presentation Logic (화면 로직)
		// <K , V>
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("id", id);
		map.put("password", password);
		map.put("email", email);
		map.put("gender", gender);
		map.put("blood", blood);
		map.put("hobby_list", hobby_list);
		map.put("friend_list", friend_list);
		map.put("introduce", introduce);
		
		//request binding 연결
		request.setAttribute("map", map);
		
		//출력은 result_member2.jsp 하라고 호출
		RequestDispatcher disp = request.getRequestDispatcher("result_member2.jsp");
		disp.forward(request, response);
	
		
		
	}//end service

}
