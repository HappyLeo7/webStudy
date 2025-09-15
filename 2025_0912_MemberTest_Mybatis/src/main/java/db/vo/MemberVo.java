package db.vo;

public class MemberVo {
	int mem_idx;
	String mem_name;
	String mem_id;
	String mem_pwd;
	String mem_email;
	String mem_zippcode;
	String mem_addr;
	String mem_ip;
	String mem_regdate;
	String mem_grade;
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	//데이터 추가하기위한 vo생성자
	public MemberVo(String mem_name, String mem_id, String mem_pwd, String mem_email, String mem_zippcode,
			String mem_addr, String mem_ip, String mem_grade) {
		super();
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_email = mem_email;
		this.mem_zippcode = mem_zippcode;
		this.mem_addr = mem_addr;
		this.mem_ip = mem_ip;
		this.mem_grade = mem_grade;
	}
	
	
	/**데이터 수정을 위한 vo생성자*/
	public MemberVo(int mem_idx, String mem_name, String mem_id, String mem_pwd, String mem_email, String mem_zippcode,
			String mem_addr, String mem_grade) {
		super();
		this.mem_idx = mem_idx;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_email = mem_email;
		this.mem_zippcode = mem_zippcode;
		this.mem_addr = mem_addr;
		this.mem_grade = mem_grade;
	}
	
	
	/** 데이터 수정을 위한 vo생성자 IP 추가*/
	public MemberVo(int mem_idx, String mem_name, String mem_id, String mem_pwd, String mem_email, String mem_zippcode,
			String mem_addr, String mem_ip, String mem_grade) {
		super();
		this.mem_idx = mem_idx;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_email = mem_email;
		this.mem_zippcode = mem_zippcode;
		this.mem_addr = mem_addr;
		this.mem_ip = mem_ip;
		this.mem_grade = mem_grade;
	}


	public int getMem_idx() {
		return mem_idx;
	}


	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_zippcode() {
		return mem_zippcode;
	}
	public void setMem_zippcode(String mem_zipcode) {
		this.mem_zippcode = mem_zipcode;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_ip() {
		return mem_ip;
	}
	public void setMem_ip(String mem_ip) {
		this.mem_ip = mem_ip;
	}
	public String getMem_regdate() {
		return mem_regdate;
	}
	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	public String getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}


	@Override
	public String toString() {
		return "MemberVo [mem_idx=" + mem_idx + ", mem_name=" + mem_name + ", mem_id=" + mem_id + ", mem_pwd=" + mem_pwd
				+ ", mem_email=" + mem_email + ", mem_zippcode=" + mem_zippcode + ", mem_addr=" + mem_addr + ", mem_ip="
				+ mem_ip + ", mem_regdate=" + mem_regdate + ", mem_grade=" + mem_grade + "]";
	}
	
}
