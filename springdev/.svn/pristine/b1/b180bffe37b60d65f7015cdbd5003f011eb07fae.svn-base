package net.n1books.dev.mvc;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("memo")
public class MemoController {
	private static final Logger logger = LoggerFactory.getLogger(MemoController.class);
	
	@RequestMapping(value = "insert", method=RequestMethod.GET)
	public void insert() {}

	@RequestMapping(value = "insert", method=RequestMethod.POST)
	public ModelAndView insert(@Valid @ModelAttribute MemoVO memoVO, BindingResult br) {
		logger.info(memoVO.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memoVO", memoVO);
		
		if (br.hasErrors()) {
			mav.setViewName("memo/insert");
			return mav;
		} else {
			mav.setViewName("memo/insert_action");
			return mav;
		}
	}

}
