package servlet.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Game() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		go_view("/WEB-INF/views/game_form.jsp",request,response);
	}

	private void go_view(
			String viewName,
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Integer, String> rsp = new HashMap<>();
		rsp.put(1, "가위"); rsp.put(2, "바위"); rsp.put(3, "보");
		
		String name = request.getParameter("name");
		Integer player =  Integer.parseInt(request.getParameter("player"));
		int comp = (int) Math.random()*3 + 1;
		
		request.setAttribute("player", rsp.get((Integer) player)); 
		request.setAttribute("comp", rsp.get((Integer) comp));
		
		int result = rsp_result(player, comp);
		String resultmsg = "";
		if (result == 0) resultmsg = "비겼습니다!!";
		if (result == -1) resultmsg = "졌네요, 다음기회에!!";
		if (result == 1) resultmsg = "당신의 승리입니다!!";
		
		request.setAttribute("result", resultmsg);
		
		go_view("/WEB-INF/views/game_result.jsp",request,response);
	}
	
	//가위 = 1, 바위 = 2, 보 = 3
	public int rsp_result (int player, int comp) {
		if (player == comp) {
			return 0;
		} else if (player == 1) {
			switch (comp) {
				case 2: return -1;
				case 3: default: return 1;
			}
		} else if (player == 2) {
			switch (comp) {
				case 1: return 1;
				case 3: default: return -1;
			}
		} else {
			switch (comp) {
				case 1: return -1;
				case 3: default: return 1;
			}
		}

	}
}
