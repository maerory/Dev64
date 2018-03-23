package servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game2")
public class Game1 extends HttpServlet {
	private static Logger logger = LoggerFactory.getLogger(Game.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		go_view("/WEB-INF/views/game/form.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] caption = {"가위", "바위", "보"};
		int you = Integer.parseInt(request.getParameter("you"));
		
		logger.info("you : " + you);
		if (true) return;
		int com = (int)(Math.random() * 3) + 1;
		request.setAttribute("you", caption[you - 1]); 
		request.setAttribute("com", caption[com - 1]); 
		request.setAttribute("win", winner(you, com)); 
		go_view("/WEB-INF/views/game/process.jsp", request, response);
	}
	
	private String winner(int you, int com) {
		if (you==1 && com==3 ||
			you==2 && com==1 ||
			you==3 && com==2) return "당신의 승리입니다";
		else if (you == com) return "비겼습니다";
		else return "당신의 패배입니다";
	}

	private void go_view(
			String viewName,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
}
