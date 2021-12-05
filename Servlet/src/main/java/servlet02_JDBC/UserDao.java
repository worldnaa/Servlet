package servlet02_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 3단계 : VO, DAO 로 분리

public class UserDao {	
	
	// Field(정적인 코드)
	String dburl  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String dbuser = "scott";
	String dbpwd  = "tiger123";

	// Constructor
	public UserDao() {	
	}
	
	//Method
	public void getUser(UserVO userVO) {
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			//1단계 connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			//2단계 statement
			pStmt = con.prepareStatement("SELECT user_id,password FROM users WHERE user_id=? AND password=?");
			pStmt.setString(1,userVO.getId());
			pStmt.setString(2,userVO.getPwd());
			
			//3단계 resultSet
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("db에서 확인 한 id,pwd ==> "+userVO.getId()+" : "+userVO.getPwd());
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
