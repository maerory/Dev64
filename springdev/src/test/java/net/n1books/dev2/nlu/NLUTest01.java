package net.n1books.dev2.nlu;

import org.junit.Test;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;

public class NLUTest01 {
	
	@Test
	public void testNLU() {
		NaturalLanguageUnderstanding service =
				new NaturalLanguageUnderstanding(
					NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
					"ba25f708-5b65-4033-96d2-bd09c84b050b",
					"KO5RqUWkJ3ks");
		String url = "http://entertain.naver.com/ranking/read?oid=001&aid=0009959412";
		ConceptsOptions concepts = 
				new ConceptsOptions.Builder().limit(20).build();
		Features features = new Features.Builder().concepts(concepts).build();
		AnalyzeOptions parameters =
				new AnalyzeOptions.Builder().url(url).features(features).build();
		AnalysisResults response = service.analyze(parameters).execute();
		System.out.println(response);
		
	}
}
