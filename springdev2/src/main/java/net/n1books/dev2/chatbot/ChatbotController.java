package net.n1books.dev2.chatbot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chatbot")
public class ChatbotController {
	
	@RequestMapping("/")
	public String init() {
		return "chatbot";
	}
}
