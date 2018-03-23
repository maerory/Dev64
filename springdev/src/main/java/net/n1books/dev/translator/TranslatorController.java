package net.n1books.dev.translator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiedLanguages;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifyOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

@Controller
@RequestMapping("translator")
public class TranslatorController {
	private static final Logger logger = LoggerFactory.getLogger(TranslatorController.class);
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String form() {
		return "translator/form";
	}
	
	//You have both the Get and Post method for security reasons.

	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public String process(String source, Model model) {
		logger.info("source : " + source);
		
		if (source == null || source == "") {
			return(" ");
		}
		
		
		LanguageTranslator service = new LanguageTranslator();
		service.setUsernameAndPassword(
				"db8c1aee-e44b-46e9-b92e-322bf4e3b568",
				"i5HNRApy7vRR");
		
		IdentifyOptions options = new IdentifyOptions.Builder()
				.text(source)
				.build();
		
		IdentifiedLanguages languages = service.identify(options)
				.execute();
		
		logger.info("sourceLang : " + languages.getLanguages().get(0).getLanguage());
		
		String sourceLang = languages.getLanguages().get(0).getLanguage();
		
		TranslateOptions translateOptions = new TranslateOptions.Builder()
		  .addText(source)
		  .modelId("fr-ko")
		  .build();

		TranslationResult result = service.translate(translateOptions)
		  .execute();

		System.out.println(result.getTranslations().get(0).getTranslation());
		model.addAttribute("result",result.getTranslations().get(0).getTranslation());
		return "translator/process";
	}
	
	@Test
	public void testTraslator() {
		LanguageTranslator service = new LanguageTranslator();
		service.setUsernameAndPassword(
				"db8c1aee-e44b-46e9-b92e-322bf4e3b568",
				"i5HNRApy7vRR");

		TranslateOptions translateOptions = new TranslateOptions.Builder()
		  .addText("hello")
		  .modelId("en-ko")
		  .build();

		TranslationResult result = service.translate(translateOptions)
		  .execute();

		System.out.println(result);
	
	}
}
