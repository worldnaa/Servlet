package servlet01_GetPost;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletdoPost extends HttpServlet{
	
	// init() : 금번 예제에선 method overriding no need
	// service() : method overriding 하지 않음
	
	// 정상 실행을 위해 doGet() 추가
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		doPost(req,res);
	}

	// doPost()만 사용할 경우 405에러 발생
	// URL을 직접 쓰고 엔터를 치는 행위는 Get방식인데, Get방식이 오버라이딩 되어 있지 않아서 에러 발생
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	
		System.out.println(":: servlet doPost() 시작");
		System.out.println(":: Request Client IP : "+req.getRemoteAddr());

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
		System.out.println(":: servlet doPost() 종료");
	}
	
	// destroy() : 금번 예제에선 method overriding no need

}//end of class	
	
		