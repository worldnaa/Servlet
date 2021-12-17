package servlet05_Navigation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet04_ObjectScope.User;

// Servlet Navigation : SendRedirect
// HttpServletResponse.sendRedirect() API 확인
// Servlet에서 각각의 Object Scope에 저장한 Bean을 JSP로 Forward 시, 저장된 Bean 공유 유무 확인

@WebServlet("/servlet06_Navigation/ServletSendRedirect")
public class ServletSendRedirect extends HttpServlet {
	
	// service()
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[ServletSendRedirect.service() start...]");
		
		// Request Object Scope에 저장
		request.setAttribute("user01", new User("홍길동","1111"));
		
		// Session Object Scope에 저장
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("이순신","2222"));
		
		// Application Object Scope에 저장
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고","3333"));
		
		// Request 다시 생성하여 Request 하는 sendRedirect 이해
		response.sendRedirect("/Servlet/servlet06_Navigation/view.jsp");
		
		System.out.println("[ServletSendRedirect.service() end...]");
	}

}//end of class

