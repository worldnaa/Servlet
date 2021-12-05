package servlet01_GetPost;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletdoGet extends HttpServlet{

	// init() : 금번 예제에선 method overriding no need
	// service() : method overriding 하지 않음

	// doGet() : HttpServlet의 메서드로, 서블릿이 Get 요청을 처리할 수 있도록 서버에서 (서비스 메서드를 통해) 호출
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	
		System.out.println(":: servlet doGet() 시작");
		System.out.println(":: Request Client IP : " + req.getRemoteAddr());

		// 한글처리 (안 하면 한글 깨짐)
		res.setContentType("text/html;charset=UTF-8");
		
		// PrintWriter 인스턴스 생성을 Encapsulation 한 API 사용 Stream 생성
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head><title>hello Servlet</title></head>");
		out.println("<body>");
		
		out.println("English : Hello Servlet");
		out.println("<p>");
		out.println("Korea : 헬로 서블릿");
		
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
		
		System.out.println(":: servlet doGet() 종료");
	}
	
	// destroy() : 금번 예제에선 method overriding no need

}//end of class	
	
/*
[ 정리 ]
1) HelloServletService 에서 service() 대신 doGet() 사용
2) service() 안에는 doGet() 과 doPost() 를 호출하는 기능이 있다
3) 결과는 HelloServletService.java 와 동일하다 (실행방법도 동일)
*/








		