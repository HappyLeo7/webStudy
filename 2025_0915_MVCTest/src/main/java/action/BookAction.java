package action;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// POJO(Plain Old Java Object) : 순수자바객체
public class BookAction {
	
	
	//목록처리하는 메소드
	public String list(HttpServletRequest request,HttpServletResponse response) {
		
		List<String> book_list =new ArrayList<String>();
		book_list.add("java");
		book_list.add("html");
		book_list.add("css");
		book_list.add("oracle");
		book_list.add("js");
		book_list.add("servlet");
		
		//request binding
		request.setAttribute("book_list", book_list);
		
		return "book_list.jsp"; // forward시킬 뷰정보를 반환
	}

	//상세보기
	public String view(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//view.do?book=%27html%27
		String book = request.getParameter("book").toUpperCase();// 대문자로 바꿔서체크
		String content="";
		if(book.equals("JAVA")) {
			content = "Java는 객체 지향 프로그래밍 언어이다. 제임스고슬링이 만든사람";
		}else if (book.equals("HTML")) {
			content = "HyperText Markup Language로 태그기반의 언어";
		}else if (book.equals("CSS")) {
			content = "Cascading Style Sheet로 모양을 내는 언어";
				
		}else if (book.equals("ORACLE")) {
			content = "Browser 내의 이벤트나 모든 동작을 제어하는 언어";
			
		}else if (book.equals("JS")) {
			content = "Java언어로 기반으로 만든 언어";
			
		}else if(book.equals("SERVLET")) {
			content = "서버";
			
		}
		
		//request binding
		request.setAttribute("content", content);
		
		return "book_view.jsp";
	}
	
}
