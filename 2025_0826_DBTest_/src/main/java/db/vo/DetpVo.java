package db.vo;

//VO ( Value Object ) : 1개의 레코드를 담는 객체
//삼위일체
//VO property 명 == DB Column 명 == 폼의 parameter 명
public class DetpVo {
	//property 속성 , member field, 변수
	int deptno;
	String dname;
	String loc;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
