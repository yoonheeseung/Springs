package model;

public class InfoBean {

	/* 
	 * 테이블 필드명과 변수명을 같게 한다. 자료형도 같게한다.
	 */
	private String name;
	private String addr;
	private String regdate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate.substring(0, 10);
	}
	
	
}
