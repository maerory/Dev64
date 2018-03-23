package servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet2 extends HttpServlet {
	
	public HelloServlet2() {
		System.out.println("HelloServlet2()");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}
	
}
