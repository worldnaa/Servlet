package connectionPool.service.user.vo;

// Client 의 From Data 를 Object Modeling 한 Bean
// Data 만 갖는 객체 ==> Value Object  (Value Object Pattern)
 
public class UserVO {

	// Field
	private int no;
	private String id;
	private String name;
	private String pwd;
	private boolean active;
	
	// Constructor
	public UserVO() {
	}

	// Method
	// getter/setter Method
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "UserVO [no=" + no + ", id=" + id + ", name=" + name + ", pwd=" + pwd + ", active=" + active + "]";
	}
	
	
}//end of class
