package servlet02_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import connectionPool.common.pool.OracleConnectionPool;

// 6단계 : Connection Pool을 SPEC화 한 javax.sql.DataSource 사용
// oracle 11g를 사용해서 그런지 해당 실습 실행 불가

public class UserDataSourceDao {	
	// Field(정적인 코드)
//	String dburl  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	String dbuser = "scott";
//	String dbpwd  = "tiger123";

	// Constructor
	public UserDataSourceDao() {	
	}
	
	// Method
	public void getUser(UserVO userVO) {
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			// 1단계 connection
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			// OracleConnectionPool로 부터 Connection 인스턴스 GET
//			con = OracleConnectionPool.getInstance().getConnection();
			
			//=======================================================
			// DataSource에서 connection GET (import javax.sql.DataSource;)
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/ora");
												// java:comp : naming service root
												// env : enviroment
												// jdbc/ora : server.xml에 등록된 name
			con = ds.getConnection();
			//=======================================================
			
			//2단계 statement
			pStmt = con.prepareStatement("SELECT user_id, password FROM users WHERE user_id=? AND password=?");
			pStmt.setString(1,userVO.getId());
			pStmt.setString(2,userVO.getPwd());
			
			//3단계 resultSet
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("db에서 확인 한 id,pwd==>: "+userVO.getId()+" : "+userVO.getPwd());
				userVO.setActive(true); //Data가 존재하면 실행
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
