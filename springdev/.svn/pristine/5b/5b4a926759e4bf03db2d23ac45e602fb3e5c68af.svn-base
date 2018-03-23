package net.n1books.dev.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("music")
public class MusicController {

	@RequestMapping("pop")
	public ModelAndView pop() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music");
		mav.addObject("msg", "King of POP");
		return mav;
	}
	
	@RequestMapping("rock")
	public ModelAndView rock() {
		return new ModelAndView("music","msg","We will rock you");
	}

	@RequestMapping("funk")
	public String funk(Model model) {
		model.addAttribute("msg", "Get the funk out");
		return "music";
	}

	@RequestMapping("classic")
	public String classic(Model model) {
		model.addAttribute("msg", "RIP, Mozart");
		return "music";
	}
}
