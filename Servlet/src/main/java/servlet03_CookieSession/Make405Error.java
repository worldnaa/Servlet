package servlet03_CookieSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// doPost() Method OverRiding :: Get 방식으로 접근시 405 Error(상태코드) 발생

//@WebServlet("/Make405Error")
public class Make405Error extends HttpServlet{
	// init()
	
	// service()
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
	}
	
	// destroy()
	
}//end of class
