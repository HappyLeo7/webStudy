package comments.vo;

//Vo는 순수한 데이터 이다.
public class CommentsVo {
	
	/**댓글번호*/
	int commentes_idx;
	/**사용자이름*/
	String commentes_name;
	/**댓글내용*/
	String commentes_content;
	/**댓글비번*/
	String  commentes_pwd;
	/**댓글IP*/
	String commentes_ip;
	/**댓글작성일*/
	String commentes_regdate;
	public int getCommentes_idx() {
		return commentes_idx;
	}
	public void setCommentes_idx(int commentes_idx) {
		this.commentes_idx = commentes_idx;
	}
	public String getCommentes_name() {
		return commentes_name;
	}
	public void setCommentes_name(String commentes_name) {
		this.commentes_name = commentes_name;
	}
	public String getCommentes_content() {
		return commentes_content;
	}
	public void setCommentes_content(String commentes_content) {
		this.commentes_content = commentes_content;
	}
	public String getCommentes_pwd() {
		return commentes_pwd;
	}
	public void setCommentes_pwd(String commentes_pwd) {
		this.commentes_pwd = commentes_pwd;
	}
	public String getCommentes_ip() {
		return commentes_ip;
	}
	public void setCommentes_ip(String commentes_ip) {
		this.commentes_ip = commentes_ip;
	}
	public String getCommentes_regdate() {
		return commentes_regdate;
	}
	public void setCommentes_regdate(String commentes_regdate) {
		this.commentes_regdate = commentes_regdate;
	}
	
	
		
	
	
	
}
