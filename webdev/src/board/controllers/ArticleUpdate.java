package board.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;

public class ArticleUpdate extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		try {
			BoardDAO boardDAO = BoardDAOImpl.getInstance();
			BoardVO boardVO = new BoardVO();
			boardVO.setNo(no);
			boardVO = boardDAO.getArticle(boardVO);
			return new ModelAndView(
				"/WEB-INF/views/article/update.jsp","article", boardVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}

}
