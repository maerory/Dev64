package net.n1books.dev.restful;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("restful")
public class RestfulController {

	@RequestMapping("{name}")
	public String iam(@PathVariable String name, Model model) {
		model.addAttribute("msg","그래, 난 " + name);
		return "restful/iam";
	}

	@RequestMapping("want")
	public String want(Model model) {
		model.addAttribute("msg", "want()");
		return "restful/iam";
	}
	
	@RequestMapping("want/{want}")
	public String want(
			@PathVariable String want, Model model) {
		model.addAttribute("msg", "안 성생님, " + want + " 가 하고 싶어요");
		return "restful/iam";
	}
	
	@RequestMapping("iam/{age}/{name}")
	public String want(
			@PathVariable int age,
			@PathVariable String name, Model model) {
		model.addAttribute("msg", "그래, 난 " + age + "세 " + name + " 야!");
		return "restful/iam";
	}
	
}
