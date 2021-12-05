package servlet02_JDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

// 4단계 : Init Param (VO는 재활용)

// UserDao.java : 특정 DB에 종속적
// DB 접속정보를 web.xml(Meta-Data)에 등록하여 특정 DB에 종속적이지 않은 DAO 구성가능

//@WebServlet("/LoginBeanInitParam")
public class LoginBeanInitParam extends HttpServlet {
	
	// Field (Meta-Data : 부가정보)
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPasswd;
	
	// init() Method OverRiding
	// ==> web.xml(Meta-Data)에 등록된 정보추출
	// ==> init() Method는 Client의 최초 request에 1회만 호출 :: Servlet Life Cycle
	@Override
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		jdbcDriver = sc.getInitParameter("jdbcDriver");
		jdbcURL = sc.getInitParameter("jdbcURL");
		jdbcUser = sc.getInitParameter("jdbcUser");
		jdbcPasswd = sc.getInitParameter("jdbcPasswd");
		
		// 디버깅용
		System.out.println("web.xml에 등록된 InitParam값을 추출유무 확인");
		System.out.println("jdbcDriver : "+jdbcDriver);
		System.out.println("jdbcURL : "+jdbcURL);
		System.out.println("jdbcUser : "+jdbcUser);
		System.out.println("jdbcPasswd : "+jdbcPasswd);
	}
	
	// doPost() Method OverRiding
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
		UserInitParamDao dao = new UserInitParamDao();
		
		// DB 접속정보 driver, url, user, password 설정
		dao.setJdbcDriver(jdbcDriver);
		dao.setJdbcURL(jdbcURL);
		dao.setJdbcUser(jdbcUser);
		dao.setJdbcPasswd(jdbcPasswd);
		
		// UserVO.active true/false 변경
		dao.getUser(userVO);
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.println("<h2>Login 화면</h2>");
		
		if(userVO.isActive()) {
			out.print(id+"님 환영합니다.");
		}else {
			out.print("Login 실패 id,pwd를 확인하세요.");
		}
		
		out.print("<p><p><a href='/Servlet/servlet02_JDBC/loginBeanInitParam.html'>뒤로</a>");
		out.print("</body>");
		out.print("</html>");
		
	}

}//end of class

/*
 [ web.xml의 servlet 안에 추가 ]
		
		<init-param>
			<param-name>jdbcDriver</param-name>
			<param-value>oracle.jdbc.driver.OracleDriver</param-value>
		</init-param>
		<init-param>
			<param-name>jdbcURL</param-name>
			<param-value>jdbc:oracle:thin:@127.0.0.1:1521:xe</param-value>
		</init-param>
		<init-param>
			<param-name>jdbcUser</param-name>
			<param-value>scott</param-value>
		</init-param>
		<init-param>
			<param-name>jdbcPasswd</param-name>
			<param-value>tiger123</param-value>
		</init-param> 
*/







