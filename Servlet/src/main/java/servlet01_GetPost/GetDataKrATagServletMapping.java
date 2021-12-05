package servlet01_GetPost;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Get 방식으로 전송된 Client Form Data 처리
public class GetDataKrATagServletMapping extends HttpServlet{

	// 1. Client Get 방식으로 Request : doGet() method O/R
	// 2. service() O/R 가능
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{

		// 아래의 두 실행문은 servlet에서 client로 html을 전송 시 필수 코딩
		res.setContentType("text/html;charset=UTF-8"); // 한글처리 (안 쓰면 한글깨짐)
		PrintWriter out = res.getWriter();             // 출력 스트림
		
		// client form data (= QueryString, URL 안에 name=value 형태의 것) 처리
		// req.getParameter("addr") => html에서 input 태그의 name 값
		// req에 모든 데이터가 저장된다!
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		// 16진수 인코딩된 client form data 한글 디코딩
		String clientNameKo = this.convertKo(clientName); // this 생략가능
		String clientAddrKo = convertKo(clientAddr);
 
		// client form data 콘솔창에 출력
		System.out.println(clientNameKo+" : "+clientAddrKo);

		// End User가 getDataKrATagServletMapping.html 에서 데이터 입력하고
		// 전송을 누르면 결과로 보여지는 출력문
		out.println("<html>");
		out.println("<head><title>GetDataKrATagServletMapping.java</title></head>");
		out.println("<body>");

		out.println("<h2>GetDataKrATagServletMapping Test</h2>");
		out.println("<li> 이름 : "+clientNameKo);
		out.println("<li> 주소 : "+clientAddrKo);

		out.println("<p><p><a href='/Servlet/servlet01_GetPost/getDataKrATagServletMapping.html'>뒤로</a>");
		out.println("<p><a href='/Servlet/servlet01_GetPost/GetDataKrATagServletMapping?name=홍길동&addr=서울'>자기자신</a>");
		
		out.println("</body>");
		out.println("</html>");
	}

	//Method
	private String convertKo(String paramValue){
		String convertParamValue = null;
		try{
			byte[] b = paramValue.getBytes();
			convertParamValue = new String(b,"UTF-8");
		}catch(UnsupportedEncodingException uee){
			System.out.println("한글 변환중 Exception 발생");
			uee.printStackTrace();
		}
		return convertParamValue;
	}

}//end of class	
	
		