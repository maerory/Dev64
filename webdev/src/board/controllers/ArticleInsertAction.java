package board.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;

public class ArticleInsertAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		BoardVO boardVO = new BoardVO();
		boardVO.setName(name);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setPasswd(passwd);
		
		BoardDAO boardDAO = BoardDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			boardDAO.insertBoard(boardVO);
			mav.addObject("msg","Entry Success");
			mav.addObject("url", "list");
			return mav;
			
		} catch (Exception e) {
			mav.addObject("msg", "Fail to Upload");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
