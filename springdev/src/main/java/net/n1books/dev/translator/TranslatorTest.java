package net.n1books.dev.translator;

import org.junit.Test;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.IdentifiableLanguages;

public class TranslatorTest {
	
	@Test
	public void testTrans1() {
		LanguageTranslator service = new LanguageTranslator();
		service.setUsernameAndPassword(
				"db8c1aee-e44b-46e9-b92e-322bf4e3b568",
				"i5HNRApy7vRR");
		
		IdentifiableLanguages languages =
				service.listIdentifiableLanguages()
					.execute();
		
		for(int i=0; i < languages.getLanguages().size(); i++) {
			String language = languages.getLanguages().get(i).getLanguage();
			String name = languages.getLanguages().get(i).getName();
			System.out.println(i + "." + language + ":" + name);
		}
	}
}
