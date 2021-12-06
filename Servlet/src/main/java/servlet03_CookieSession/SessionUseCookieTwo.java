package servlet03_CookieSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 서버에 필요한 정보를 HttpSession 을 이용하여 저장

//@WebServlet("/SessionUseCookieTwo")
public class SessionUseCookieTwo extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		
		// Cookie에 HttpSession을 구분,GET 할 수 있는 unique한 session id 존재 유무 확인
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				System.out.println("\nCookie에 저장된 정보 : ");
				System.out.println(cookies[i].getName() + " : " + cookies[i].getValue());
				System.out.print("\n");
			}
		}
	
		// false이고 요청에 유효한 HttpSession이 없으면, null을 반환
		HttpSession session = req.getSession(false);
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<center><h2>SessionUseCookieTwo</h2></center>");
		
		// session이 null인 경우     : 기존에 생성, 사용중인 HttpSession 객체가 없다
		// session이 null이 아닌 경우 : 기존에 생성된 HttpSession 객체가 있다
		if(session != null) {
			out.print("<hr> SESSION ID = " + session.getId() + "<hr>");
			String name = (String)session.getAttribute("name");
			out.println("이름 : " + name);
		}else {
			out.println("처음이십니다.");
		}
		out.println("</body></html>");	
	}
}//end of class
