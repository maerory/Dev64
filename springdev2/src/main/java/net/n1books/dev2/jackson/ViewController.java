package net.n1books.dev2.jackson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ViewController {
	
	@RequestMapping("view")
	public void view(Model model) {
		model.addAttribute("msg", "goodbye view");
	}
}
