package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.PersonVo;

/**
 * Servlet implementation class PersonJsonListAction
 */
@WebServlet("/person/list.do")
public class PersonJsonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//--------[데이터 Parse Start]-------------------------------------------
		String str_url="http://localhost:8080/2025_0909_JSONTest/person_data.jsp";
		URL url = new URL(str_url); //URL 클래스 
		//사용하는 이유 : header에 ID and password 정보 설정하기 위해서
		HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
//		urlConn.setRequestProperty("ID", "");
//		urlConn.setRequestProperty("PWD","");
		urlConn.connect();
		
		InputStream is = urlConn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader br =new BufferedReader(isr);
		
		StringBuffer sb =new StringBuffer();
		while(true) {
			String data = br.readLine();
			if(data==null)break;
			sb.append(data.trim());
		}
		
		String json_data=sb.toString();
		System.out.println(json_data);
		
		//JSON Parsing 
		JSONObject json = new JSONObject(json_data);
		String lastModifyDate=json.getString("lastModifyDate");
		
		List<PersonVo> list =new ArrayList<PersonVo>();
		JSONArray personArray =json.getJSONArray("persons");
		
		for(int i =0;i<personArray.length();i++) {
			JSONObject person = personArray.getJSONObject(i);
			String name = person.getString("name");
			int age = person.getInt("age");
			String tel = person.getString("tel");
			
			PersonVo vo = new PersonVo();
			vo.setName(name);
			vo.setAge(age);
			vo.setTel(tel);
			list.add(vo);
		}
//--------[데이터 Parse End]-------------------------------------------		
		request.setAttribute("lastModifyDate", lastModifyDate);
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}