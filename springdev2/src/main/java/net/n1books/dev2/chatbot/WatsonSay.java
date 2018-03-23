package net.n1books.dev2.chatbot;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@RestController
@RequestMapping("chatbot")
public class WatsonSay {
	private static final Logger logger = LoggerFactory.getLogger(WatsonSay.class);
	
	@RequestMapping("watsonsay")
	public MessageResponse watsonsay(String isay, HttpSession session) {
		logger.info("user input : " + isay);
		
		Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("b01c78b1-3d04-4094-b0e1-d6d3ab89a3b5", "bfKJbndhdjHq");
		
		MessageOptions options = null; 
		if (!isay.equals("")) {
			options = new MessageOptions.Builder(
					"5495f262-af1b-4a78-b4b7-e3101a12dabd")
					.input(new InputData.Builder(isay).build())
					.context((Context)session.getAttribute("context"))
					.build();
		} else {
			options = new MessageOptions.Builder(
					"5495f262-af1b-4a78-b4b7-e3101a12dabd")
					.input(new InputData.Builder(isay).build())
					.build();
		}
		MessageResponse response = service.message(options).execute();
		session.setAttribute("context", response.getContext());
		String watsonsay = response.getOutput().getText().get(0);

		logger.info(response.toString());
		return response;
	}
}
