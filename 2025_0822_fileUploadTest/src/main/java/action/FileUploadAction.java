package action;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import util.FileUploadUtils;

/**
 * Servlet implementation class FileUploadAction
 */

//저장하려는 파일크기정보 설정하기
@MultipartConfig(location = "/tmp", 
					fileSizeThreshold = 1024 * 1024, // 1메가
					maxFileSize = 1024 * 1024 * 5, // 5메가
					maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		
        
        //parameter변수
        String filename="no_file";
        //String filename2="no_file";
        String title="";
        
        //저장경로..   // 웹경로 , 물리적경로 2개가 있다. 파일 저장은 절대경로로 해야한다.
        //전역객체 (현재 웹컨텍스트)를 관리하는 객체
        ServletContext application = request.getServletContext();
        
        // 현재 웹프로그램 실제경로
        System.out.println(application.getRealPath(""));
        
        
        
        String saveDir = request.getServletContext().getRealPath("/upload/");
        //업로드경로
        //System.out.println(saveDir);
        
        
        request.setCharacterEncoding("utf-8");
        String contentType = request.getContentType();
        System.out.println(contentType);
        
        // /upload.do?title=병아리&photo=병아리.png
        //파일 업로드 전송영역 contentType 이 "multipart/"으로 시작하면 참
        if(contentType!=null && contentType.toLowerCase().startsWith("multipart/")) {
        	
        	//각각 파트 구해라 / 업로드된 파라메터 목록을 구한다(text/binary)
        	Collection<Part> parts = request.getParts();
        	
        	for(Part part : parts) {
        		
        		System.out.println(part.getHeader("Content-Disposition"));
        		
        		//upload화일이 있으면
        		if(part.getHeader("Content-Disposition").contains("filename")) { //업로드된 파일 체크 contains("해당문자있는지 체크")

        			if(part.getHeader("Content-Disposition").contains("photo")) {
        			    filename = FileUploadUtils.saveFile(part, saveDir, "photo");
        			}
        			
//        			if(part.getHeader("Content-Disposition").contains("photo2")) {
//        			   filename2 = FileUploadUtils.saveFile(part, saveDir, "photo2");
//        			}
        				

        		}else { //일반 파라메터면
        			//String formValue = request.getParameter(part.getName());
        			title = request.getParameter("title");
        		}
        		
        	}
        }//end:if
        
        //모델2 request binding
        request.setAttribute("title", title);
        request.setAttribute("filename", filename);
       // request.setAttribute("filename2", filename2);
        
        
        //포워드해jsp에서 출력
        request.getRequestDispatcher("result1.jsp").forward(request, response);
        
        
        
		

	}

}
