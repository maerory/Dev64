package net.n1books.dev.text2speech;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;

@Service
public class Text2SpeechServiceImpl extends TextToSpeech implements Text2SpeechService {
	public Text2SpeechServiceImpl() {
		try {
			InputStream is =
				this.getClass().getClassLoader().getResourceAsStream("../system.properties");
			Properties props = new Properties();
			props.load(is);
			
			setUsernameAndPassword(
				props.getProperty("text2speech.username"), 
				props.getProperty("text2speech.password"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String[]> getVoiceLists() throws Exception {
		List<Voice> list = getVoices().execute();
		List<String[]> voiceLists = new ArrayList<String[]>();
		List<String> voiceList = new ArrayList<String>();
		
		for(Voice voice:list) {
			voiceList.add(
				voice.getLanguage() + ":" + 
				voice.getDescription() + "$" + voice.getName());
		}
		
		for(String v:voiceList) {
			StringTokenizer st = new StringTokenizer(v, "$");
			String[] temp = new String[2];
			temp[0] = st.nextToken();
			temp[1] = st.nextToken();
			voiceLists.add(temp);
		}
		
		return voiceLists;
	}
	
	@Override
	public InputStream convertText2Speech(String statement, String voice, AudioFormat format) {
		RequestBuilder request = RequestBuilder.get("/v1/synthesize");
		request.query("text", statement);
		request.query("voice", voice);
		request.query("accept", format);
		return createServiceCall(
			request.build(), ResponseConverterUtils.getInputStream()).execute();
	}
}
