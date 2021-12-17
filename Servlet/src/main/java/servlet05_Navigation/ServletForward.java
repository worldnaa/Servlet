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

// Servlet Navigation : Forward
// JSP Standard Action Tag : <jsp:forward page="~~.jsp"/> 와 비교
// Servlet에서 각각의 Object Scope에 저장한 Bean을 JSP로 Forward 시, 저장된 Bean 공유 유무 확인

@WebServlet("/servlet06_Navigation/ServletForward")
public class ServletForward extends HttpServlet {
	
	// service()
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[ServletForward.service() start...]");
		
		// Request Object Scope에 저장
		request.setAttribute("user01", new User("홍길동","1111"));
		
		// Session Object Scope에 저장
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("이순신","2222"));
		
		// Application Object Scope에 저장
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고","3333"));
		
		// 1. ServletContext Object 추출
		ServletContext sc = this.getServletContext();
		
		// 2. Context 내의 resource 이동할 수 있는 기능을 제공하는 RequestDispatcher 객체 추출
		RequestDispatcher rd = sc.getRequestDispatcher("/servlet06_Navigation/view.jsp");
		
		// 3. Forward
		rd.forward(request, response);
		
		System.out.println("[ServletForward.service() end...]");
	
	}

}//end of class

