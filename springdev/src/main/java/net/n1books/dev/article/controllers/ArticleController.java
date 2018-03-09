package net.n1books.dev.article.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService service;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public void insert() {}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public ModelAndView insert(ArticleVO articleVO) {
		try {
			service.insert(articleVO);
			
			return new ModelAndView("redirect:list");
			
		} catch (Exception e) {
			logger.info("입력실패 : " + e.getMessage());
			
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	
	@RequestMapping(value="list")
	public ModelAndView list() {
		try {
			List<ArticleVO> list = service.getArticleList();
			return new ModelAndView("article/list", "list",list);
		} catch(Exception e) {
			logger.info("예외 발생: " + e.getMessage());
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","리스트 출력 불가");
			mav.addObject("url","../");
			return mav;
		}
	}
	
	@RequestMapping(value="view")
	public ModelAndView view(@RequestParam long no) {
		try {
			service.updateReadcount(no);
			ArticleVO vo = service.getArticle(no);
			return new ModelAndView("article/content","articleVO",vo);
		} catch (Exception e) {
			logger.info("예외 발생: " + e.getMessage());
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",no + "번 게시물 상세보기 실패");
			mav.addObject("url","list");
			return mav;
		}
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(long no) {
		return new ModelAndView("article/delete","no",no);
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView delete(ArticleVO articleVO) {
		ModelAndView mav = new ModelAndView("result");
		try {
			service.delete(articleVO);
			mav.addObject("msg", articleVO.getNo() + "번 게시물이 삭제되었습니다.");
			mav.addObject("url","list");
		} catch(Exception e) {
			//logger.info(e.getMessage());
			mav.addObject("msg", e.getMessage());
			mav.addObject("url","javascript:history.go(-1);");
		}
		return mav;
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView update(long no) {
		try {
			ArticleVO vo = service.getArticle(no);
			return new ModelAndView("article/update","articleVO",vo);
		} catch (NoArticleException e) {
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","list");
			return mav;
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "시스템 오류");
			mav.addObject("url","list");
			return mav;
		}
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute ArticleVO articleVO) {
		try {
			service.update(articleVO);
			return new ModelAndView("redirect:view?no=" + articleVO.getNo());
		} catch (Exception e) {
			logger.info("수정실패 : " + e.getMessage());

			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","수정 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
}
