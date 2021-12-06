package servlet03_CookieSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet02_JDBC.UserDataSourceDao;
import servlet02_JDBC.UserVO;

//@WebServlet("/LoginBenaDataSource")
public class LoginBeanDataSourceSession extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		// Client Form Data 처리
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		// session 유무확인 :: 새로운 HttpSession 생성 or 기존 HttpSession GET
		HttpSession session = req.getSession(true);
		
		// 기 login 한 회원 :: session에 저장된 UserVO Get
		// 미 login 한 회원 :: session에 저장된 UserVO 없으므로 null Get
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		System.out.println("session에 저장된 UserVO 유무확인 : " + userVO);
		
		// 아래의 두 경우를 고려
		// 고려사항 1)
		// loginBeanPoolSession.html을 거쳐서 오는 경우
		// id를 입력하지 않은 경우: req.getParameter("id");의 값 ==> ""(NullString)
		
		// 고려사항 2)
		// Browser 주소창에 직접 http://127.0.0.1:8080/Servlet/servlet03_CookieSession/LoginBeanDataSourceSession을
		// 입력한 경우: req.getParameter("id");의 값 ==> null
		
		// 고려사항 1,2인 경우 DB 접근 불필요 : 입력값의 유효셩을 check하는 if문
		if(!(id==null || id.equals(""))){
			//UserVO 인스턴스 생성 및 Client Form Data 전달 (Binding)
			userVO = new UserVO();
			userVO.setId(id);
			userVO.setPwd(pwd);
			
			//DB 접근 Data 검색, 비교하여 UserVO.active true/false 변경
			UserDataSourceDao userDataSourceDao = new UserDataSourceDao();
			userDataSourceDao.getUser(userVO);
		}

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.println("<h2>Login 화면</h2>");

		if (userVO != null && userVO.isActive()) {
			out.print(id + "님 환영합니다.");
			// Login이 정상적으로 이루어진 경우 :: session에 로그인 정보로 userVO 인스턴스 저장
			session.setAttribute("userVO", userVO);
		} else {
			out.print("Login 실패 id,pwd를 확인하세요.");
		}

		out.print("<p><p><a href='/Servlet/servlet03_CookieSession/loginBeanDataSource.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
	
	}

}//end of class
