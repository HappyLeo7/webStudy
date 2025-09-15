package vo;

import java.util.List;

/*
 VO : Value Object

 */
public class SawonVo {
	int sabun,deptno,sapay,samgr;
	String saname,sasex,sajob,sahire;
	
	//사원이 관리하는 고객 목록도 가져오기
		List<GogekVo> go_list;
	
	public List<GogekVo> getGo_list() {
			return go_list;
		}
		public void setGo_list(List<GogekVo> go_list) {
			this.go_list = go_list;
		}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSasex() {
		return sasex;
	}
	public void setSasex(String sasex) {
		this.sasex = sasex;
	}
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getSahire() {
		return sahire.substring(0,10);
	}
	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
	
	
}
