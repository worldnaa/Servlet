package servlet02_JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 5단계 : Connection Pool 사용 (VO는 재활용)
// JDBC 절차 중 Connection 인스턴스 생성 및 관리는 이를 전담하는 Connection Pool 사용
// oracle 11g를 사용해서 그런지 해당 실습 실행 불가

//@WebServlet("/LoginBeanPool")
public class LoginBeanPool extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		// Client Form Data 처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		// UserVO instance 생성 및 Client Form Data 전달(Binding)
		UserVO userVO = new UserVO();
		userVO.setId(id);   // Client Form Data 전달 (Binding)
		userVO.setPwd(pwd); // Client Form Data 전달 (Binding)

		// DB 접근 Data 검색 비교하여 UserVO.active true/false 변경
		UserPoolDao userPoolDao = new UserPoolDao();
		userPoolDao.getUser(userVO);

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>Login 화면</h2>");

		if (userVO.isActive()) {
			out.print(id + "님 환영합니다.");
		} else {
			out.print("Login 실패 id,pwd를 확인하세요.");
		}

		out.print("<p><p><a href='/Servlet/servlet02_JDBC/loginBeanPool.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
	
	}

}//end of class
