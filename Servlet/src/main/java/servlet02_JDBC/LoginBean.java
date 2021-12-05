package servlet02_JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 2단계 : JDBC 분리하기 (LoginBean - DbBean)
// Servlet implementation class LoginBean

//@WebServlet("/LoginBean")
public class LoginBean extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		// Client Form Data 처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		// DB 접근 data 검색은 DbBean을 이용하여 회원유무 확인
		DbBean dbBean = new DbBean();
		dbBean.setId(id);
		dbBean.setPwd(pwd);
		
		// DbBean.getUser() : DB 접근 Data 검색 비교하여 true/false return
		boolean isLogin = dbBean.getUser();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.println("<h2>Login 화면</h2>");
		
		if(isLogin) {
			out.print(id+"님 환영합니다.");
		}else {
			out.print("Login 실패 id,pwd를 확인하세요.");
		}
		
		out.print("<p><p><a href='/Servlet/servlet02_JDBC/loginBean.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
		
	}
}
