package servlet03_CookieSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Client 에 필요정보를 저장하는 Cookie 사용

//@WebServlet("/CookieReaderToServer")
public class CookieReaderToServer extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		// Client로 부터 전송된 Cookie 처리
		Cookie[] cookies = req.getCookies();
		
		// Cookie의 name=value 처리 변수
		String userName = null;
		
		// Cookie의 존재유무 및 name=value 처리
		if(cookies != null) {
			// out.print 를 사용할 경우 HTML 문법 사용 
			out.println("Client에서 전송된 Cookie 있습니다.<br/>");
			
			// Array로 return :: Array 갯수만큼 처리
			for(int i=0; i<cookies.length; i++) {
				
				// name=value 형식의 저장값 중 name 추출 (결과: name)
				String name = cookies[i].getName();
				
				// name=value 형식의 저장값 중 value 추출 (결과: 홍길동)
				String value = URLDecoder.decode(cookies[i].getValue());
				
				// System.out.print : 디버깅 (콘솔에 출력)
				System.out.println("Client로 부터 전송된 cookie : " + name + " = " + value);
				
				if(name.equals("name")) {
					userName = value;
				}
			}
			
		}else {// 쿠키가 null일 경우
			out.println("Client에서 전송된 cookie가 없습니다.<br/>");
		}
        		
        out.println("<html><body>");
        
        // userName이 null인 경우의 의미 :: cookie에 id가 저장되지 않았음 ==> 처음방문
		if(userName == null) {
			out.print("처음입니다.");
		}else {
			out.print(userName+"님 환영");
		}
		out.println("</body></html>");
	}

}//end of class

/*
[ getCookies() ]
- 클라이언트가 이 요청(req)과 함께 보낸 모든 Cookie 개체를 포함하는 배열을 반환
- 쿠키가 전송되지 않은 경우 null 반환  
*/

