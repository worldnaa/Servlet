package servlet02_JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 6단계 : Connection Pool을 SPEC화 한 javax.sql.DataSource 사용
// oracle 11g를 사용해서 그런지 해당 실습 실행 불가

//@WebServlet("/LoginBenaDataSource")
public class LoginBeanDataSource extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		// Client Form Data 처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		// UserVO instance 생성 및 Client Form Data 전달(Binding)
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);

		// DB 접근 Data 검색 비교 UserVO.active true/false 변경
		UserDataSourceDao userDataSourceDao = new UserDataSourceDao();
		userDataSourceDao.getUser(userVO);

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>Login 화면</h2>");

		if (userVO.isActive()) {
			out.print(id + "님 환영합니다.");
		} else {
			out.print("Login 실패 id,pwd를 확인하세요.");
		}

		out.print("<p><p><a href='/Servlet/servlet02_JDBC/loginBeanDataSource.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
	
	}

}//end of class
