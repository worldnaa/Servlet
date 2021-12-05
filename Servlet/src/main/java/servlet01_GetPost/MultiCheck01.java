package servlet01_GetPost;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MultiCheck01")
public class MultiCheck01 extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<boby><center><h2>Client에서 전송된 내용</h2></center><p>");

		String name = convertKo(req.getParameter("name"));
		String addr = this.convertKo(req.getParameter("addr"));
	
		out.println("<li>이름 : "+ name);
		out.println("<li>주소 : "+ addr);
		// =====================================================================================
		// 방법1) sw는 checkbox 다중 선택이 가능, getParameter()로 처리한 경우
		// ==> 선택한 것 중 제일 최상단의 한 가지 항목만 나온다
//        out.println("<li>사용중인 SW : " + req.getParameter("sw"));
		// =====================================================================================
        // 방법2) 1. sw checkbox 다중 선택일 경우 array 을 return 하는 getParameterValues() 사용
        out.println("<br>선택하신 sw는 아래와 같습니다.<br>");
        
        // 변수를 만들어 반복문 돌리는 방법
//        String[] sw = req.getParameterValues("sw");
//        for(int i=0; i<sw.length; i++){
//                out.println("<li>사용중인 SW : " + sw[i]);
//        }
        
        // 변수 선언 없이 하는 방법
        for(int i=0; i<req.getParameterValues("sw").length; i++){
            out.println("<li>사용중인 SW : " + req.getParameterValues("sw")[i]);
        }
        // =====================================================================================
        out.println("<li>사용중인 OS : "+  req.getParameter("os"));
		out.println("<li>사용중인 cpu : "+ req.getParameter("cpu"));
		out.println("</body></html>");
	}
	
	///Method
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
