package util;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class FileUploadUtils {
	
												//saveDir : 저장경로
	public static String saveFile(Part part,String saveDir,String photo) throws IOException {
							//파일이름 추출
		String filename = extractFileName(part.getHeader("Content-Disposition"), photo);
	    if(part.getSize()>0) {
	    	
	    	File  f = new File(saveDir,filename);
	    	
	    	//동일파일명이존재하는지 체크
	    	if(f.exists()) {
	    		long tm = System.currentTimeMillis(); //시간을 아주 작은 단위로 가져온다 (파일이름에 넣기위해서)
	    		filename = String.format("%d_%s", tm,filename);
	    		f = new File(saveDir,filename);
	    	}
	    	
	    	//임시파일내용 저장
			part.write(saveDir + File.separator + filename);
			//임시파일내용 삭제 (디스크에 올라간 파일삭제)
			part.delete();
		}
		
		return filename;
	}
	
	
	static String extractFileName(String partHeader,String name) {
		
		//System.out.println(partHeader);
		
		if(partHeader.contains(name)) {
			for(String cd : partHeader.split(";")) {// ; 기준으로 배열형으로 분리된다.
				
				if(cd.contains("filename")) { //배열을 하나씩 뽑아서 filename 포함된것을 찾는다.
					//System.out.println(cd);
					
					//							lastIndexOF("해당문자의 인덱스값")  replace(해당문자를,해당문자로 변경)
					String fileName = cd.substring(cd.lastIndexOf("=")+1).trim().replace("\"","");
				
					
					return fileName;
					//        filename=병아리.jpg
				}
				//int index = fileName.lastIndexOf(File.separator);
				//return fileName.substring(index+1);
			}
		}
		return null;
	}
	

}
