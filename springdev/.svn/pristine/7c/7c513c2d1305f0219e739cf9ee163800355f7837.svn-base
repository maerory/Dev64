package net.n1books.dev.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mapping")
public class AnnoController {

	@RequestMapping("hello") public void mapping() {}
	
	@RequestMapping("hello2") public String mapping2() {
		return "mapping/hello";
	}
	
	@RequestMapping("hello3") public void mapping3(Model model) {
		model.addAttribute("msg", "호우~!!!!");
	}
	
	@RequestMapping("hello4") public String mapping4(Model model) {
		model.addAttribute("msg", "View와 Model 모두 사용");
		return "mapping/hello";
	}
	
	@RequestMapping("hello5") public ModelAndView mapping5() {
		return new ModelAndView("mapping/hello", "msg", "ModelAndView 사용");
	}
}
