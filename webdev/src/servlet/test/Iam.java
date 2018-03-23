package servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Iam")
public class Iam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Iam() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		go_view("/WEB-INF/views/form.jsp",request,response);
	}


	private void go_view(
			String viewName,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String iam = "Requiescat in Pace " + name;
		request.setAttribute("iam", iam);
		go_view("/WEB-INF/views/process.jsp",request,response);
	}

}
