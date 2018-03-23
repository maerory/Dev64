package net.n1books.dev.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAnnotation {

	@RequestMapping("/helloAnno")
	public String hello() {
		return "hello2";
	}

	@RequestMapping("/helloAnno2")
	public ModelAndView hello2() {
		return new ModelAndView("hello", "msg", "Hello @Annotation2");
	}

}
