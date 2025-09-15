package action;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import util.FileUploadUtils;

/**
 * Servlet implementation class FileUploadUsePartAction
 */
//TODO 용량 설정
@MultipartConfig(location="/", 
                 fileSizeThreshold=1024*1024, //1메가
                 maxFileSize=1024*1024*5, //5메가
                 maxRequestSize=1024*1024*5*5)

@WebServlet("/upload.do")
public class FileUploadUsePartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        
        //parameter변수
        String filename1="no_file";
        String filename2="no_file";
        String title="";
        
        //저장경로..   // 웹경로 , 물리적경로 2개가 있다. 파일 저장은 절대경로로 해야한다.
        String saveDir = request.getServletContext().getRealPath("/upload/");
        //System.out.println(saveDir);
        
        
        request.setCharacterEncoding("utf-8");
        String contentType = request.getContentType();
        
        if(contentType!=null && contentType.toLowerCase().startsWith("multipart/")) {
        	
        	Collection<Part> parts = request.getParts();
        	
        	for(Part part : parts) {
        		
        		//upload화일이 있으면
        		if(part.getHeader("Content-Disposition").contains("filename")) {

        			if(part.getHeader("Content-Disposition").contains("photo1")) {
        			    filename1 = FileUploadUtils.saveFile(part, saveDir, "photo1");
        			}
        			
        			if(part.getHeader("Content-Disposition").contains("photo2")) {
        			   filename2 = FileUploadUtils.saveFile(part, saveDir, "photo2");
        			}
        				

        		}else { //일반 파라메터면
        			//String formValue = request.getParameter(part.getName());
        			title = request.getParameter("title");
        		}
        		
        	}
        }//end:if
        
        
        request.setAttribute("title", title);
        request.setAttribute("filename1", filename1);
        request.setAttribute("filename2", filename2);
        
        
        request.getRequestDispatcher("result1.jsp").forward(request, response);
        
        
        
		

	}//end:service()
	
	
	
	
	/*
	 * String saveFile(Part part,String saveDir,String photo) throws IOException {
	 * 
	 * String filename = extractFileName(part.getHeader("Content-Disposition"),
	 * photo); if(part.getSize()>0) {
	 * 
	 * File f = new File(saveDir,filename); if(f.exists()) { long tm =
	 * System.currentTimeMillis(); filename = String.format("%d_%s", tm,filename); f
	 * = new File(saveDir,filename); }
	 * 
	 * part.write(saveDir + File.separator + filename); part.delete(); }
	 * 
	 * return filename; }
	 * 
	 * 
	 * String extractFileName(String partHeader,String name) {
	 * 
	 * //System.out.println(partHeader);
	 * 
	 * if(partHeader.contains(name)) { for(String cd : partHeader.split(";")) {
	 * 
	 * if(cd.contains("filename")) { //System.out.println(cd);
	 * 
	 * String fileName =
	 * cd.substring(cd.lastIndexOf("=")+1).trim().replace("\"",""); return fileName;
	 * } //int index = fileName.lastIndexOf(File.separator); //return
	 * fileName.substring(index+1); } } return null; }
	 */
	

}