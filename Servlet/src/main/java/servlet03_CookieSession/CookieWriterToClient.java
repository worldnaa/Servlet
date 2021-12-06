package servlet03_CookieSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Client 에 필요정보를 저장하는 Cookie 사용

//@WebServlet("/CookieWriterToClient")
public class CookieWriterToClient extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		// Cookie 생성(name=value) :: 한글 인코딩 후 저장
		// name = "name" / value = "홍길동" 으로 저장
		Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동"));

        cookie.setMaxAge(60*60);	//cookie 유효기간(초)
		//cookie.setMaxAge(-1);		//cookie memory 저장X
		//cookie.setMaxAge(0);	 	//cookie 0초동안 유효 (삭제됨) 
		res.addCookie(cookie);		//Client 로 response 인스턴스를 사용 cookie 전송
				
        out.println("<html><body>");
		out.println("Cookie 저장 완료");
		out.println("</body></html>");
	}

}//end of class

/*

- javax.servlet.http.Cookie 
- Cookie (String name , String value) ==> n-v (map 구조)

[ getMaxAge() ]
- 초 단위로 지정된 쿠키의 최대 사용기간을 반환
- -1은 브라우저가 종료될 때 까지 쿠키가 유지됨을 나타냄

[ setMaxAge(int expiry) ]
- 쿠키의 최대 사용기간을 초 단위로 설정
- 양수값은 몇 초가 지난후에 쿠키가 만료됨을 나타냄 (값은 쿠키가 만료되는 최대 기간)
- 음수값은 쿠키가 영구적으로 저장되지 않고, 웹브라우저가 종료될 때 삭제됨 (즉 쿠키가 저장X)
- 0은 쿠키가 삭제됨을 나타냄

[ res.addCookie(Cookie cookie) ]
- 응답(res)에 지정된 쿠키를 추가. 둘 이상의 쿠키 설정 OK

 */

