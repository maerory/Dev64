package board.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;

public class ArticleList extends AbstractController {
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO boardDAO = BoardDAOImpl.getInstance();
		try {
			List<BoardVO> list = boardDAO.getBoardList();
			return new ModelAndView("/WEB-INF/views/article/list.jsp","list", list);
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "List Error");
			mav.addObject("url", "error");
			return mav;
		}
	}
}
