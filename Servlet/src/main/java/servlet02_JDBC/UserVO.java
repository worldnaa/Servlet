package servlet02_JDBC;

// 3단계 : VO, DAO 로 분리

public class UserVO {
	
	// Field
	private String id;
	private String pwd;
	private boolean active;
	
	// Constructor
	public UserVO() {
	}

	// Method
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", active=" + active + "]";
	}
	
}//end of class
