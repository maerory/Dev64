package board.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;

public class ArticleView extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		
		try {
			BoardDAO boardDAO = BoardDAOImpl.getInstance();
			boardVO = boardDAO.getArticle(boardVO);
			return new ModelAndView("/WEB-INF/views/article/content.jsp","article", boardVO);
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}

}
