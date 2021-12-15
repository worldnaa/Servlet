package connectionPool.common.util;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// JDBC 절차와 관련된 Utility Bean : Connection return 하는 static method

public class DBUtil {
	// Field
	// Constructor
	public DBUtil() {
	}
	
	// Method 
	// DBMS 의 접속정보로 Connection
	public static Connection getConnection(String driverClassName, String url, String id, String passwd ) {
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, id, passwd);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("db 접속시 오류 발생 : "+e);
		}
		return con;
	}
	
	// DataSource 이용하여 Connection 생성
	public static Connection getConnection() {
		Connection con = null;
		try {
//			InitialContext ic = new InitialContext();
//			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/ora");
//			con = ds.getConnection();
			
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/ora");
			con = ds.getConnection();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			
			// DataSource Connection return 받지 못한 경우
			// 기본적인 방법인 1EA Connection return
			if(con == null) {
				con = getConnection("oracle.jdbc.driver.OracleDriver",
									"jdbc:oracle:thin:@127.0.0.1:1521:xe",
									"scott","tiger123");
			}
		}
		return con;
	}
}//end of class
