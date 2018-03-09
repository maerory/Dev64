package net.n1books.dev.text2speech;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;

@Controller
public class Text2SpeechController {
	private static final Logger logger = 
			LoggerFactory.getLogger(Text2SpeechController.class);
	@Autowired
	private Text2SpeechService service;
	
	@RequestMapping(value="text2speech", method=RequestMethod.GET)
	public void text2speech(Model model) throws Exception {
		model.addAttribute("voiceLists", service.getVoiceLists());
	}
	
	
	@RequestMapping(value="speak")
	public void text2speech(
		String statement, String voice, HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename='" +
				URLEncoder.encode("voice.ogg", "UTF-8") + "'");
		InputStream is = service.convertText2Speech(statement, voice, AudioFormat.OGG);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);
	}
}
