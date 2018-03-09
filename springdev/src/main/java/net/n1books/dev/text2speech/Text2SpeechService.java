package net.n1books.dev.text2speech;

import java.io.InputStream;
import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;

public interface Text2SpeechService {
	public List<String[]> getVoiceLists() throws Exception;

	public InputStream convertText2Speech(String statement, String voice, AudioFormat ogg);
}
