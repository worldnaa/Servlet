package servlet02_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 4단계 : Init Param (VO는 재활용)
// 특정 DBMS에 종속적이지 않은 DAO

public class UserInitParamDao {

	// Field
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPasswd;
	
	// Constructor
	public UserInitParamDao() {
	}

	// Method
	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}

	public void setJdbcPasswd(String jdbcPasswd) {
		this.jdbcPasswd = jdbcPasswd;
	}
	
	public void getUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			//1단계 connection
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPasswd);
			
			//2단계 statement
			pStmt = con.prepareStatement("SELECT user_id,password FROM users WHERE user_id=? AND password=?");
			pStmt.setString(1,userVO.getId());
			pStmt.setString(2,userVO.getPwd());
			
			//3단계 resultSet
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("db에서 확인 한 id,pwd==>: "+userVO.getId()+" : "+userVO.getPwd());
				userVO.setActive(true); // Data가 존재한다면 UserVO의 active를 true로 변경
			}else {
				System.out.println("db에 <"+userVO.getId()+">에 해당하는 자료가 없습니다.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
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
	}//end of getUser()
	
}//end of class
