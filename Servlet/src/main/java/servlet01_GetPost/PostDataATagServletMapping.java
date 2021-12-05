package servlet01_GetPost;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Post 방식으로 전송된 Client Form Data 처리
public class PostDataATagServletMapping extends HttpServlet{
	
	// 정상 실행을 위해 doGet() 추가
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
	}

	// doPost()만 사용할 경우 405에러 발생
	// URL을 직접 쓰고 엔터를 치는 행위는 Get방식인데, Get방식이 오버라이딩 되어 있지 않아서 에러 발생
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		// 16진수 인코딩된 client form data 한글 디코딩
		// setCharacterEncoding(java.lang.String env) 
		//:Overrides the name of the character encoding used in the body of this request (Body에만 적용, Get에선 X)
		req.setCharacterEncoding("UTF-8");

		// 아래의 두 실행문은 servlet에서 client로 html을 전송 시 필수 코딩
		res.setContentType("text/html;charset=UTF-8"); // 한글처리
		PrintWriter out = res.getWriter();             // 출력 스트림

		// client form data (= QueryString, URL 안에 name=value 형태의 것) 처리
		// req.getParameter("addr") => html에서 input 태그의 name 값
		// req에 모든 데이터가 저장된다!
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		// client form data 콘솔창에 출력
		System.out.println(clientName+" : "+clientAddr);

		// End User가 postData.html 에서 데이터 입력하고
		// 전송을 누르면 결과로 보여지는 출력문
		out.println("<html>");
		out.println("<head><title>PostDataATagServletMapping.java</title></head>");
		out.println("<body>");
		
		out.println("<h2>PostDataATagServletMapping Test</h2>");
		out.println("<li> 이름 : "+clientName);
		out.println("<li> 주소 : "+clientAddr);
		
		out.println("<p><p><a href ='/Servlet/servlet01_GetPost/postDataATagServletMapping.html'>뒤로</a>");
		out.println("<p><p><a href ='/Servlet/servlet01_GetPost/PostDataATagServletMapping?name=홍길동&addr=서울'>자기자신</a>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}

}//end of class