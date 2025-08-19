<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//Script Let (Java Code를 작성할 수 있다)
	
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
		
	 	/* //응답
		response.setContentType("text/html; charset=utf-8;");
		
		/*  TODO 출력하는 방법의 원리
		 * OutputStream os = response.getOutputStream(); 
		 * PrintStream ps =new PrintStream(os); 
		 * PrintWriter out1 = new PrintWriter(os); 
		 * System.out.println();
		 * //여기서 out은 PrintStream 이다.
		 */ 
		 /*
		PrintWriter out1 = response.getWriter();
		
		
		//HTML 생성 -> StringBuffer에 누적
		StringBuffer sb = new StringBuffer();
		
		 sb.append("<html>");
		sb.append("<body>");
		sb.append("<table width='400' border='1'>");
		sb.append("<caption>회원정보</caption>");
		sb.append(String.format("<tr><th>이름</th><td>%s</td></tr>", name));
		sb.append(String.format("<tr><th>아이디</th><td>%s</td></tr>", id));
		sb.append(String.format("<tr><th>비밀번호</th><td>%s</td></tr>", password));
		sb.append(String.format("<tr><th>이메일</th><td>%s</td></tr>", email));
		sb.append(String.format("<tr><th>성별</th><td>%s</td></tr>", gender));
		sb.append(String.format("<tr><th>혈액형</th><td>%s</td></tr>", blood));
		sb.append(String.format("<tr><th>자기소개</th><td>%s</td></tr>", introduce));
		sb.append(String.format("<tr><th>취미</th><td>%s</td></tr>", hobby_list));
		sb.append(String.format("<tr><th>친구</th><td>%s</td></tr>", friend_list));
		sb.append("<tr><td colspan='2' align='center'><a href='input_member.html'>다시하기</a></td></tr>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		//응답(전송)
		out1.print(sb.toString());   */

%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="400" border='1'>
		<caption>::::개인정보::::</caption>
		<tr>
			<th>이름</th>
			<td><%= name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%= id %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%= password %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= email %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%= gender %></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><%= blood %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><%=hobby_list %></td>
		</tr>
		<tr>
			<th>친구</th>
			<td><%=friend_list %></td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><%=introduce %></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="input_member.html">돌아가기</a></td>
		</tr>
	</table>
	
</body>
</html>