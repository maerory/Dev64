package board.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;

public class ArticleDeleteAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		String passwd = request.getParameter("passwd");
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		boardVO.setPasswd(passwd);
		
		BoardDAO boardDAO = BoardDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			boardDAO.deleteBoard(boardVO);
			mav.addObject("msg","Delete Success");
			mav.addObject("url", "list");
			return mav;
		} catch (Exception e) {
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
}
