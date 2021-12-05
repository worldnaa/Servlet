package servlet02_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 2단계 : JDBC 분리하기 (LoginBean - DbBean)

public class DbBean {

	// Field
	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuser = "scott";
	private String dbpwd = "tiger123";
	private String id;
	private String pwd;
	
	// Constructor
	public DbBean() {
	}

	// Method
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	// DB 접근 Data 검색 비교하여 true/false return
	public boolean getUser() {
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			
			// 1단계 : Connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			// 2단계 : Statement
			pStmt = con.prepareStatement("SELECT user_id,password FROM users WHERE user_id=?");
			pStmt.setString(1,id);
			
			// 3단계 : ResultSet
			rs = pStmt.executeQuery();
			String str = null;
			
			if(rs.next()) {
				str = rs.getString("password");
				System.out.println("db에서 확인 한 id,pwd==>: "+id+" : "+str);
			}else {
				System.out.println("db에 <"+id+">에 해당하는 자료가 없습니다.");
			}
			
			// 회원 유무를 확인하고, 회원이면 true, 아니면 false return
			if(str != null && str.equals(pwd)) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false; // 왜 catch문 안에 return문이 존재하는가?
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(Exception e1) {}
			}
			if(pStmt != null) {
				try {
					pStmt.close();
				}catch(Exception e2) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(Exception e3) {}
			}
		
		}
	
	}

}//end of class
