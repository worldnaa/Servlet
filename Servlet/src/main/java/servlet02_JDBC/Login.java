package servlet02_JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1단계 : 하나의 Servlet에 다 몰아넣기

// JRE System Library build path에 ojdbc6.jar 추가
// C:\tools\apache-tomcat-8.5.72\lib 폴더에 ojdbc6_g.jar 추가

//@WebServlet("/Login")
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		// Client Form Data 처리 
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		////////////////////////JDBC 시작////////////////////////
		
		// DBMS 에서 추출한 id, pwd 처리를 위한 변수 선언
		String fromDbId = null;
		String fromDbPwd = null;
		
		try {
			String dburl  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbuser = "scott";
			String dbpwd  = "tiger123";
			
			// 1단계 : Connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			// 2단계 : Statement
			PreparedStatement pStmt = con.prepareStatement("SELECT user_id,password FROM users WHERE user_id=?");
			pStmt.setString(1,id);
			
			// 3단계 : ResultSet
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				fromDbId = rs.getString("user_id");
				fromDbPwd = rs.getString("password");
				System.out.println("db에서 확인한 id, pwd ==> " + fromDbId + " / " + fromDbPwd);
			}else {
				System.out.println("db에 client에서 입력한 <"+id+"> 와 <"+pwd+"> 가 없습니다.");
			}
			
			// 각각의 JDBC 관련 인스턴스 close
			rs.close();
			pStmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println("===> JDBC관련 Exception이 발생한 모양 <===");
			e.printStackTrace();
		}
		
		////////////////////////JDBC 관련 부분 종료////////////////////////
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>Login 화면</h2>");
		
		// DBMS Data 와 Client Form Data 비교하여 회원유무 판단
		if(fromDbId != null && fromDbPwd != null && fromDbId.equals(id) && fromDbPwd.equals(pwd)) {
			out.println(id+"님 환영합니다.");
		}else {
			out.println("id,pwd를 확인하세요.");
		}
		
		out.println("<p><p><a href='/Servlet/servlet02_JDBC/login.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}

}//end of class
