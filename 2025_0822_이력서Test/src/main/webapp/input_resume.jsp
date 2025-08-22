<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function send(f){
		
		let name = f.name.value.trim();
		let profile_photo = f.profile_photo.value;
		
		if(name==""){
			alert("이름을 적어주세요");
			f.name.value="";
			f.name.focus();
		}
		if(profile_photo==""){
			alert("프로필 사진을 넣어주세요");
		}
		
		//매서드 정의 GET or POST
		f.method="POST";
		//타입 정의 이미지업로드때 필요 
		f.enctype="multipart/form-data"
		//서블릿 경로
		f.action="resume_view.do";
		//서버로전송
		f.submit();
	}
</script>
</head>
<body>
	<form action="">
		성명 : <input name="name"><br>
		증명사진 : <input type="file" name="profile_photo"><br>
		<input type="button" value="출력" onclick="send(this.form);">
	</form>
</body>
</html>