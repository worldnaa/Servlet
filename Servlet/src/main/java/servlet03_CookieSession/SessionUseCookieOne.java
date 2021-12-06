package servlet03_CookieSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/SessionUseCookieOne")
public class SessionUseCookieOne extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// HttpSession 객체가 없을 경우 : 새로운 HttpSession 객체 생성 
		// HttpSession 객체가 있을 경우 : 기존 HttpSession 객체 GET 
		
		// 세션은 인터페이스라서 생성이 불가하므로, req.getSession()을 통해 Session을 반환 시킨다
		// req.getSession() : default는 true이며, false도 선택 가능
		HttpSession session = req.getSession(true);
		
		// 새로 만들어진 HttpSession 객체라면 (true 라면),
		// 개체를 바인딩하고, 아니면 그냥 넘어간다
		if(session.isNew()) {
			// name = "name" / value = "홍길동" 으로 저장
			session.setAttribute("name", new String("홍길동"));
		}
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<center><h2>SessionUseCookieOne</h2></center>");
		
		// HttpSession 을 구분, GET 할 수 있는 unique 한 ID 값 확인
		System.out.println("UNIQUE한 SESSION ID는 : " + session.getId());
		
		if(session.isNew()) {
			out.println("세션이 새로 생성됨<br>"); // 새로 만들어진 세션일 경우 출력
		}else {
			out.println("UNIQUE한 SESSION ID는 : " + session.getId() + " 사용중"); // 기존 세션일 경우 출력
		}
		out.println("<hr>");
		out.println("<a href='/Servlet/servlet03_CookieSession/SessionUseCookieTwo'>링크</a>");
		out.println("</body></html>");	
	}
	
}//end of class

/*

- Interface HttpSession ==> 인터페이스라서 인스턴스 생성 불가. but 참조형 변수로는 사용가능

[ getSession() ]
- HttpSession을 반환한다
- 이 요청과 관련된 현재 세션을 반환하거나, 요청에 세션이 없는 경우 새로 하나 만든다

[ getSession(boolean create) ]
- HttpSession을 반환한다
- 이 요청과 연결된 현재 세션을 반환. 현재 세션이 없고, create이 true일 경우 새 세션을 반환한다
- create가 false이고 요청에 유효한 HttpSession이 없으면 이 메서드는 null을 반환한다

[ session.inNew() ]
- Boolean 반환
- 세션을 모르거나, 세션을 만들지 않기로 결정한 경우 true 반환
- 서버가 세션을 생성 했지만, 클라이언트가 아직 참여하지 않은 경우 true 반환
- 새 세션이면 true 반환

[ session.setAttribute(String name , Object value) ]
- 지정된 이름을 사용하여(name), 이 세션에 개체를 바인딩
- 동일한 이름의 개체가 이미 세션에 바인딩 된 경우 개체가 바뀐다

*/

