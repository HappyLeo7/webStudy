package action;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
//http://localhost:8080/2025_0818_Servlet3_Parameter/hellod.do
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, // 요청처리객체(client의 정보관리)
			HttpServletResponse response  //응답처리 객체  , 응답처리객체(client에게 응답 : clostb 정보를 알고있다.
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//			?query
				//   전달인자(parameter)
			//  /hello.do?nation=kor&time=morning
			//  /hello.do?nation=eng
			//  /hello.do?nation=jpn
			//  /hello.do?nation=chn
			//  /hello.do?nation=ger
			//  /hello.do?nation=fra
		//  	/hello.do
		//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   hello.do?nation=kor&time = morning;
		
		
		String nation = request.getParameter("nation");
		if(nation==null) {
			nation="kor";
		}
		//System.out.println(nation);
		String time = request.getParameter("time");
//		System.out.println(time);
		if(time==null) {
			time="morning";
		}
		int itime=0;
		if(time.equals("morning")) {
			itime=1;
		}else if(time.equals("afternoon")) {
			itime=2;
		}else if(time.equals("evening")) {
			itime=3;
		}
		
	
		String nation_name="미지정";
		String greeting = "몰라요";
		
		if(nation.equals("kor")) {
			nation_name = "한국";
			switch(itime) {
			case 1 :greeting="아침인사";break; 
			case 2 :greeting="오후인사";break; 
			case 3 :greeting="저녁인사";break; 
			}
			
		}else if(nation.equals("eng")) {
			nation_name = "미국";
			switch(itime) {
			case 1 :greeting="Good morning";break; 
			case 2 :greeting="Afternoon greetings";break; 
			case 3 :greeting="Good evening";break; 
			}
		}else if(nation.equals("jpn")) {
			nation_name = "일본";
			switch(itime) {
			case 1 :greeting="오하요 고자이마스";break; 
			case 2 :greeting="곤니치와";break; 
			case 3 :greeting="곰방와";break; 
			}
		}else if(nation.equals("chn")) {
			nation_name = "중국";
			switch(itime) {
			case 1 :greeting="早上好 (zǎoshang hǎo)";break; 
			case 2 :greeting="午安 (wǔ ān)";break; 
			case 3 :greeting="下午好 (xiàwǔ hǎo";break; 
			}
		}else if(nation.equals("ger")) {
			nation_name = "독일";
			switch(itime) {
			case 1 :greeting="Guten Morgen (구텐 모르겐)";break; 
			case 2 :greeting="Guten Tag (구텐 탁)";break; 
			case 3 :greeting="Guten Abend (구텐 아벤트)";break; 
			}
		}else if(nation.equals("fra")) {
			nation_name = "프랑스";
			switch(itime) {
			case 1 :greeting="Bonjour(봉주흐)";break; 
			case 2 :greeting="Bon après-midi (봉나쁘헤흐미디)";break; 
			case 3 :greeting="Bonsoir (봉수와흐)";break; 
			}
		}
		 String time_name=null;
		switch(itime) {
		case 1 : time_name= "오전"; break;
		case 2 : time_name= "오후"; break;
		case 3 : time_name= "저녁"; break;
		}
		
		
		//응답처리
		//						mime-type : image/jpg  image/tiff\
		//								  : text/html  text/xml
		//								  : application/json
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter(); //출력스트림을 얻어온다
		out.print("<html>");
		out.print("<body>");
		out.print(String.format("<h2>%s 나라 [%s]인사말</h2>", nation_name,time_name));
		out.print(String.format("<h4>%s</h4>", greeting));
		
		out.print("<a href='hello.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
		
	}//end : service
}
