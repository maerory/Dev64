package board.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleDelete extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		return new ModelAndView("/WEB-INF/views/article/delete.jsp","no",no);
	}
}
