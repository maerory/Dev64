package board.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.models.BoardDAO;
import board.models.BoardDAOImpl;
import board.models.BoardVO;

public class ArticleUpdateAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		boardVO.setName(name);
		boardVO.setTitle(title);;
		boardVO.setContent(content);
		boardVO.setPasswd(passwd);
		
		BoardDAO boardDAO = BoardDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			boardDAO.updateBoard(boardVO);
			mav.addObject("msg", "Modified.");
			mav.addObject("url", "view?no=" + no);
		} catch (Exception e) {
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
	
}
