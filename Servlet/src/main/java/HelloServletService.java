import java.io.*;            // Java API
import javax.servlet.*;      // Servlet API
import javax.servlet.http.*; // Servlet API

// Servlet에서 Client로 Html 전송 시 필수로 코딩해야 할 것!
// 1. 한글처리  2. PrintWriter 인스턴스 생성 API 사용
public class HelloServletService extends HttpServlet{
	
	// init() : 금번 예제에선 method overriding no need
	
	// service() method overriding
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		System.out.println(":: servlet service() 시작");
		System.out.println(":: Request Client IP : " + req.getRemoteAddr());// req.getRemoteAddr() : IP 주소 반환
		
		
		// 한글처리
		res.setContentType("text/html;charset=UTF-8");
//		res.setContentType("text/html"); => 이렇게 하면 한글 깨진다
		
		// 방법1) Client Html Text 전송을 위한 Stream을 생성
//		OutputStream outputStream = res.getOutputStream(); //res.getOutputStream() : ServletOutputStream 반환
//		Writer writer = new OutputStreamWriter(outputStream);
//		PrintWriter out = new PrintWriter(writer);
		
		// 방법2) PrintWriter 인스턴스 생성을 Encapsulation 한 API 사용 Stream 생성
		// 클라이언트한테 문자를 보낼 수 있는 PrintWriter 객체 반환
		// PrintWriter : 웹 브라우저에 출력하기 위한 스트림
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
		
		System.out.println(":: servlet service() 종료");
	}
	
	// destroy() : 금번 예제에선 method overriding no need

}//end of class	
	
/* 
[ 정리 ]
1) Servlet Class는 'HttpServlet'을 상속 받음
2) HttpServlet Class 안에 있는 service() 메서드를 오버라이딩 (req,res를 매개변수로)
3) res.setContentType() 메서드를 통해 '한글처리'
4) PrintWriter 인스턴스 생성을 캡슐화 한 res.getWriter() 메서드를
   사용하여 클라이언트에게 HTML 형식의 텍스트 전송

[ 실행방법 ]
- 브라우저 검색창에 http://내IP주소:포트번호/프로젝트명/파일명.java
- ex) http://192.168.1.250:8080/Servlet/HelloServletService
- ex) http://localhost:8080/Servlet/HelloServletService

[ API ]
- javax.servlet.GenericServlet
	ㄴjavax.servlet.http.HttpServlet
		- service(servletRequest req, servletResponse res)
			- req : getRemoteAddr() 있다
			- res : getWriter() 있다 
*/
