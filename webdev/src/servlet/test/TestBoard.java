package servlet.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;


@WebServlet("/TestBoard")
public class TestBoard extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO boardDAO = BoardDAOImpl.getInstance();
		List<BoardVO> list = boardDAO.getBoardList();
		
		request.setAttribute("list", list);
		request.setAttribute("pg", 5);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/testboard.jsp");
		dispatcher.forward(request, response);
	}

}
